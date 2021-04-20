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
        try (Socket socket = new Socket("localhost", 80)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            while (!"exit".equalsIgnoreCase(line)) {
                System.out.println("☯ Write your message below...");
                // reading from user
                line = sc.nextLine();

                // sending the user input to server
                out.println(line);
                out.flush();

                // displaying server reply
                System.out.println("Server replied: " + in.readLine());
            }



//            // test
//            System.out.println("☯ Testing...");
//            String json1;
//
//            json1 = "{\"username\": \"Shakime\",\"type\": \"player\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("\n● Server replied: " + in.readLine());
//
//            Thread.sleep(2500);
//            json1 = "{\"username\": \"Jose\",\"type\": \"player\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("● Server replied: " + in.readLine());
//
//            Thread.sleep(2500);
//            json1 = "{\"username\": \"Adrian\",\"type\": \"viewer\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("\n● Server replied: " + in.readLine());
//            out.println("1");

//            Thread.sleep(2500);
//            json1 = "{\"username\": \"Dylana\",\"type\": \"viewer\"}";
//            out.println(json1);
//            out.flush();
//            System.out.println("\n● Server replied: " + in.readLine());
//            out.println("2");

//            while(true){
//                Thread.sleep(5000);
//                out.println(json1);
//                System.out.println("\n● Server replied: " + in.readLine());
//            }


            // closing the scanner object
//            sc.close();
        }
        catch (IOException e) {
            System.out.println("Se cae");
            e.printStackTrace();
        }
    }
}

