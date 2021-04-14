package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Sockets{

    /*
        Abre un socket en un puerto especifico para quedar a la espera de un mensaje.
    */
    public String listen(int port){
        try {
            ServerSocket server= new ServerSocket(port);
            System.out.printf("%n⌛ Listening in port: %d.%n",port);
            Socket socket=server.accept();
            System.out.println("❤ Client accepted.");
            InputStreamReader isr =new InputStreamReader(socket.getInputStream());
            BufferedReader buff=new BufferedReader(isr);
            String message=buff.readLine();
            System.out.printf("✘ Message: %s.%n",message);
            socket.close();
            server.close();
            return message;
        } catch (IOException e) {
            return "";
        }

    }
    /*
         Abre un socket en un puerto especifico para enviar un mensaje.
    */
    public void send(String ip ,int port,String message) throws IOException {
        Socket socket=new Socket(ip,port);
        PrintWriter pw=new PrintWriter(socket.getOutputStream());
        pw.flush();
        pw.write(message);
        pw.close();
        socket.close();
    }
}