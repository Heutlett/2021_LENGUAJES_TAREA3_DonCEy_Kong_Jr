package sockets;

import settings.Settings;

import java.io.*;
import java.net.*;
import java.util.*;

// Client class
class Client {

    // driver code
    public static void main(String[] args)
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 9090)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

//            while (!"exit".equalsIgnoreCase(line)) {
//                System.out.println("☯ Write your message below...");
//                // reading from user
//                line = sc.nextLine();
//
//                // sending the user input to server
//                out.println(line);
//                out.flush();
//
//                // displaying server reply
//                System.out.println("Server replied: " + in.readLine());
//            }



//            // test
//            System.out.println("☯ Testing...");
            String json1;
////
//            json1 = "{\"username\": \"Jugador1\",\"type\": \"player\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("● Server replied: " + in.readLine());
//
//            Thread.sleep(2500);
//            json1 = "{\"username\": \"Jugador2\",\"type\": \"player\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("● Server replied: " + in.readLine());
//
//            Thread.sleep(2500);
            json1 = "{\"username\": \"Spectator1\",\"type\": \"viewer\"}";
            out.println(json1);
            out.flush();
            System.out.println("● Server replied: " + in.readLine());
            // analizar json
            out.println("1");
//
//            Thread.sleep(2500);
//            json1 = "{\"username\": \"Spectator2\",\"type\": \"viewer\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("● Server replied: " + in.readLine());
//            out.println("1");
//
//            Thread.sleep(2500);
//            json1 = "{\"username\": \"Spectator1.2\",\"type\": \"viewer\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("● Server replied: " + in.readLine());
//            out.println("1");

//            Thread.sleep(2500);
//            json1 = "{\"username\": \"Spectator4\",\"type\": \"viewer\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("● Server replied: " + in.readLine());
//            out.println("2");


            while(true){
                Thread.sleep(8000);
//                out.println("keypressed");
                out.println("request matrix");

                System.out.println("● Server replied: " + in.readLine());
            }


            // closing the scanner object
//            sc.close();
        }
        catch (IOException | InterruptedException e) {
            System.out.println("▙ ERROR. Client crashed!");
//            e.printStackTrace();
        }
    }
}

