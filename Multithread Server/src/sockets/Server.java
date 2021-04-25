package sockets;

import settings.Settings;
import java.net.*;
import java.io.*;
import org.json.JSONObject;


/**
 * Clase principal que instancia un socket servidor, acepta una conexión
 * de un cliente y le envía un entero y una cadena de caracteres.
 */
class Server {
    // ATRIBUTES
    private static final Manager manager = new Manager();

    public static void main(String[] args)
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

    // ClientHandler class
    static class ClientHandler implements Runnable {
        private static int counter = 0;
        private final int id;

        private final Socket clientSocket;
        private final String myIP;

        private String username;
        private int roomNumber;
        private boolean inRoom = false;
        private boolean isPlayer = false;

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
            System.out.printf("● Received: %s%n", aux);

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
         * Funcion que controla y define la secuencia de acciones,
         * para cada pedido del cliente.
         */
        private void procedure() throws IOException {
            String message = read();
            String reply = "Soy el chico de las poesias";
            send(reply);
            String reply2 = "Tu fiel admirador";
            send(reply2);
        }

        /**
         * Funcion bucle para que el thread del client handler se mantenga activo y
         * constantemente recibiendo pedidos del cliente y respondiendo a ellos.
         */
        public void run() {
            try {
                while (true) {
                    procedure(); // Llamar al método que maneja la secuencia de acciones.
                    Thread.sleep(3000);
                }
            } catch (NullPointerException | InterruptedException | IOException e) {
                e.printStackTrace();
                System.out.println("▙ ERROR. Connection interrupted!");
                try {
                    LogOut(); // Remove client
                } catch (IOException f) {
                    f.printStackTrace();
                    System.out.println("▙ ERROR. Couldn't log out!");
                }
            }
            finally {
                try {
                    clientSocket.close();
                } catch (IOException e) { e.printStackTrace();
                    System.out.printf("ꕥ Client has disconnected: %s\t%s%n", username, myIP);
                }
            }
        }



        /**
         * Funcion que remueve al cliente de la lista de
         * participantes de la sala.
         */
        private void LogOut() throws IOException {
            inRoom = false;
            isPlayer = false;
            Server.manager.removeSomeone(this.id);
        }

        /**
         * Funcion que cierra el socket del cliente.
         */
        public void endConnection() throws IOException {
            clientSocket.close();
        }


//         Funcion de loggeo para el cliente conectado.
//         Output: En caso de tener éxito, devuelve la sala a la que se agregó el cliente si es jugador,
//         si es espectador devuelve además el número correspondiente de espectador.
//         Si no hay espacio, devuelve "Rooms are full".
//         Si no hay partidas, en juego "No games".
//         */
//        private String logIn(String json) throws IOException {
//
//            if (Server.manager.isFull()) return "Rooms are full";
//            // get the outputstream and inputstream of client
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//            JSONObject obj = new JSONObject(json);
//            username = obj.getString("username");
//            String type = obj.getString("type");
//            String s = "";
//            if (type.equalsIgnoreCase("player")) {
//                s = Server.manager.addPlayer(this); // Agregar a sala.
//                System.out.printf("☰ Update %s%n", Server.manager.getCurrentGames());
//                return s;
//            } else if (type.equalsIgnoreCase("viewer")){
//                if (Server.manager.isEmpty()) return "No games."; // Existen partidas en juego?
//                String currentGames = Server.manager.getCurrentGames();
//                System.out.printf("✘ Message to %s: %s.%n", username, currentGames);
//                out.flush();
//                out.write(currentGames); // Enviar partidas en juego.
//
//                s = Server.manager.addViewer(Integer.parseInt(in.readLine()), this); // Agregar a sala.
//                System.out.printf("☰ Update %s%n", Server.manager.getCurrentGames());
//                return s;
//            }
//            System.out.println("▙ ERROR. Could not log in!%n");
//            return "I do not know what to do.";
//        }
//
//        private String gameProcedure(String json) {
////            System.out.printf("✘ Message to %s: %s.%n", username, Server.manager.getCurrentGames());
//            String jsonMatrix = "";
//            System.out.print("➤ Updated Matrix because of player\n");
//            jsonMatrix = Server.manager.updateMatrix(json);
//            return jsonMatrix;
//        }
//        private String getMatrix(){
//            return "This is the last matrix";
//        }





        // Getters & Setters
        public String getUsername() {
            return username;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public void setInRoom(boolean inRoom) {
            this.inRoom = inRoom;
        }

        public int getClientId() {
            return id;
        }

        public void setPlayer(boolean player) {
            isPlayer = player;
        }

    }
}
