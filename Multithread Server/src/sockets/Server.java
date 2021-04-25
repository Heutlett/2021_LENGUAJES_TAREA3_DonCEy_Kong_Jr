package sockets;

import settings.Settings;
import java.net.*;
import java.io.*;


/**
 * Clase principal que instancia un socket servidor, acepta una conexión
 * de un cliente y le envía un entero y una cadena de caracteres.
 */
public class Server {
    // ATRIBUTES
    private static final Manager manager = new Manager();
    private static Server server = null;

    /* Constructor  */
    Server(){}

    /* Singleton */
    public static Server getInstance(){
        if (server == null){
            server = new Server();
            server.run();
        } return server;
    }

    private void run()
    {
        ServerSocket server = null;
        try {
            // server is listening on port 1234
            server = new ServerSocket(Settings.serverPort);
            server.setReuseAddress(true);

            System.out.printf("➽ Server running in port: %d!%n", Settings.serverPort);

            // running infinite loop for getting
            // client request
            while (true) {

                // Se acepata una conexión con un cliente. Esta llamada se queda
                // bloqueada hasta que se arranque el cliente.
                Socket client = server.accept();

                // Displaying that new client is connected
                // to server
                System.out.printf("%n❤ Client accepted: %s%n",client.getInetAddress().getHostAddress());

                // create a new thread object
                ClientHandler clientSock = new ClientHandler(client);

                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
//                    e.printStackTrace();
                    System.out.println("▙ ERROR. Server crashed!%n");
                }
            }
        }
    }

    /**
     *  ClientHandler class
     *  Clase auxiliar del servidor para el manejo de peticiones
     *  de diferentes clientes a la vez, utilizando un hilo
     *  por cada cliente.
     */

    static class ClientHandler implements Runnable {
        private static int counter = 0;
        private final int id;

        private final Socket clientSocket;
        private final String myIP;

        private String username;
        private int roomNumber;
        private boolean isLoggedIn = false;
        private boolean isHost = false;

        // Constructor
        public ClientHandler(Socket socket)
        {
            this.id = counter++;
            this.clientSocket = socket;
            this.myIP = clientSocket.getInetAddress().getHostAddress();
        }

        /**
         * Funcion que procesa el mensaje que se recibe del cliente
         * y lo almacena en un buffer de entrada.
         * Output: buffer de entrada con el mensaje leido.
         */
        public String read() throws IOException {
            // Se prepara el flujo de entrada de datos, es decir, la clase encargada de leer datos del socket.
            DataInputStream bufferEntrada = new DataInputStream (clientSocket.getInputStream());

            // Se crea un dato a leer y se le dice que se rellene con el flujo de entrada de datos.
            SocketData aux = new SocketData("");
            aux.readObject (bufferEntrada);
            System.out.printf("%n● Received: %s%n", aux.d);

            // Retorna el mensaje leido sin su tamano.
            return aux.d;
        }

        /**
         * Funcion que procesa el mensaje que se queire enviar al cliente y lo envia
         * en un buffer de salida.
         * Input: el mensaje que debe enviarse.
         * Output: el mensaje parseado a buffer de salida.
         */
        public void send(String mensaje) throws IOException {
            // Se prepara un flujo de salida de datos, es decir, la clase encargada de escribir datos en el socket.
            PrintWriter reply = new PrintWriter(clientSocket.getOutputStream(), true);
            // Se envía el dato.
            reply.write(mensaje);
            reply.flush();
            System.out.printf("✘ Sent to %s: %s.%n", username, mensaje);
        }

        /**
         * Funcion que controla y define la secuencia de acciones, para que
         * el cliente ingrese a una sala como jugador o invitado.
         * Output: Escribe al socket: si tiene éxito loggeando , 1
         *                            si no, 0.
         */
        private void logInProcedure() throws IOException {
            if (!read().equals("join")) return;
            /* Este send retorna:
             * [{"roomNumber": 1,"player": "Jugador1","guests": [Ana, Tama]}, {"roomNumber": 2,"player": null,"guests": []}] */
            send(manager.getCurrentGames());

            /* Si el servidor está lleno o vacio, esperar petición del cliente para
             * volver a enviar los cuartos por si alguno se desocupó. */
            if (Server.manager.isFull()) {
                if (read().equals("reload"))
                logInProcedure();
                return;
            }

            /* Este read recibe:
             * { "username":"Player1", "type":"player", "room":"2" }"; */
            String json = read();
            int result = manager.addMember(json, this);  // retorna 1 si tiene éxito, 0 si no.

            /* Si no se logra loggear se desconecta al cliente. */
            if (result == 0) {
                System.out.println("▙ ERROR. Couldn't log in!\n");
                endConnection();
            }
            System.out.printf("☰ LoggedIn: %s%n", Server.manager.getCurrentGames());

            /* Este send retorna: Matriz inicial del juego. */
//            send("Initial matrix");
            send(manager.getMatrix(roomNumber));
            isLoggedIn = true;
        }

        /**
         * Funcion que controla y define la secuencia de acciones,
         * para cada pedido del cliente.
         */
        private void gameProcedure() throws IOException, InterruptedException {
            String k;
            while (isLoggedIn) {
                /* Este read recibe:
                 * Player -->  (Keypressed) i.e: "W"
                 * Viewer -->  "" */
                k = read();
                if (isHost) manager.updateMatrix(roomNumber, k); // update matrix with new move
                send(manager.getMatrix(roomNumber));
//                Thread.sleep(2000);
            }
        }

        /**
         * Funcion bucle para que el thread del client handler se mantenga activo y
         * constantemente recibiendo pedidos del cliente y respondiendo a ellos.
         */
        public void run() {
            try {
                logInProcedure(); // Método que maneja la secuencia de acciones de loggeo.
                gameProcedure(); // Método que maneja la secuencia de acciones en el juego.
            } catch (NullPointerException | IOException | InterruptedException e) {
//                e.printStackTrace();
                System.out.println("▙ ERROR. Connection interrupted!");
            }
            finally {
                LogOut(); // Remove member.
            }
        }

        /**
         * Funcion que remueve al cliente de la lista de
         * participantes de la sala.
         */
        private void LogOut() {
            isLoggedIn = false;
            isHost = false;
            Server.manager.removeMember(this.id);
        }

        /**
         * Funcion que cierra el socket del cliente.
         */
        public void endConnection() {
            try {
                clientSocket.close();
                System.out.printf("ꕥ Client has disconnected: %s\t%s%n%n", username, myIP);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("▙ ERROR. Couldn't close the socket!\n");
            }
        }


        /* Getters & Setters */

        /**
         * Retorna la variable username
         * @return String
         */
        public String getUsername() {
            return username;
        }

        /**
         * Retorna el id del cliente
         * @return id
         */
        public int getClientId() {
            return id;
        }

        /**
         * Asigna un valor booleano a isPlayer
         * @param player El valor booleano que se debe asignar.
         */
        public void setIsPlayer(boolean player) {
            isHost = player;
        }

        /**
         * Asigna el username
         * @param username El nombre que se quiere asignar.
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * Asigna el username
         * @param roomNumber El numero de sala que se debe asignar.
         */
        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }
    }
}
