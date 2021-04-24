package sockets;

import com.fasterxml.jackson.core.JsonProcessingException;
import settings.Settings;

import org.json.JSONObject;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

// Server class
class Server {

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

                // socket object to receive incoming client
                // requests
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

        /*
         Funcion de loggeo para el cliente conectado.
         Output: En caso de tener éxito, devuelve la sala a la que se agregó el cliente si es jugador,
         si es espectador devuelve además el número correspondiente de espectador.
         Si no hay espacio, devuelve "Rooms are full".
         Si no hay partidas, en juego "No games".
         */
        private String logIn(String json) throws IOException {

            if (Server.manager.isFull()) return "Rooms are full";
            // get the outputstream and inputstream of client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            JSONObject obj = new JSONObject(json);
            username = obj.getString("username");
            String type = obj.getString("type");
            String s = "";
            if (type.equalsIgnoreCase("player")) {
                s = Server.manager.addPlayer(this); // Agregar a sala.
                System.out.printf("☰ Update %s%n", Server.manager.getCurrentGames());
                return s;
            } else if (type.equalsIgnoreCase("viewer")){
                if (Server.manager.isEmpty()) return "No games."; // Existen partidas en juego?
                String currentGames = Server.manager.getCurrentGames();
                System.out.printf("✘ Message to %s: %s.%n", username, currentGames);
                out.println(currentGames); // Enviar partidas en juego.
                out.flush();
                s = Server.manager.addViewer(Integer.parseInt(in.readLine()), this); // Agregar a sala.
                System.out.printf("☰ Update %s%n", Server.manager.getCurrentGames());
                return s;
            }
            System.out.println("▙ ERROR. Could not log in!%n");
            return "I do not know what to do.";
        }

        private String gameProcedure(String json) {
//            System.out.printf("✘ Message to %s: %s.%n", username, Server.manager.getCurrentGames());
            String jsonMatrix = "";
            System.out.print("➤ Updated Matrix because of player\n");
            jsonMatrix = Server.manager.updateMatrix(json);
            return jsonMatrix;
        }
        private String getMatrix(){
            return "This is the last matrix";
        }


        private void LogOut() throws IOException {
            inRoom = false;
            isPlayer = false;
            Server.manager.removeSomeone(this.id);
        }

        public void endConnection() throws IOException {
            clientSocket.close();
        }

        public void run()
        {
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                // get the outputstream and inputstream of client
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String jsonIn;
                String jsonOut;

                while (true) {

                    //out.println("Mensaje del Server!");
                    //out.flush();

                    jsonIn = in.readLine();
                    if (jsonIn.equals("exit")) break;
                    System.out.printf("%n● Message from Cliente: %s%n",jsonIn);


//                     Process Message.
//                    jsonOut = (!inRoom) ? logIn(jsonIn) : gameProcedure(jsonIn);
                    if (!inRoom) {
                        jsonOut = logIn(jsonIn);
                    }else{
//                        System.out.printf("▙ Note: Already log in Host %d.%n", roomNumber);
//                        jsonOut = logIn(jsonIn);
                        jsonOut = (isPlayer) ? gameProcedure(jsonIn) : getMatrix();
                    }


                    // Reply to client.
                    System.out.printf("✘ Message to %s: %s.%n", username, jsonOut);
                    out.println(jsonOut);
                    out.flush();
                }
                // Remove client from guestsArray.
                LogOut();
            }
            catch (IOException | NullPointerException e) {
                e.printStackTrace();
                System.out.println("▙ ERROR. Connection interrupted!");
                try {
                    LogOut();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            finally {
                try {
                    if (out != null) { out.close(); }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                        System.out.printf("ꕥ Client has disconnected: %s\t%s%n", username, myIP);
                    }
                }
                catch (IOException e) {
                    System.out.println("▙ ERROR. Client crashed!");
                }
            }
        }


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
