import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.net.Socket;



class MyClient{
    private static int port  = 9500;
    private static String message = "", response = "";

    public static void main(String args[])throws Exception{

        Socket s=new Socket(InetAddress.getLocalHost(), port);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Client IP: "+ InetAddress.getLocalHost());
        PrintWriter pw=new PrintWriter(s.getOutputStream());

        while(!message.equals("stop")){

//            input();

            pw.flush();
            pw.write("198.68.0.0");

            dout.flush();
            dout.writeUTF("player");

            response=din.readUTF();
            System.out.println("Server says: "+response);
        }
        dout.close();
        s.close();
    }
    private static void input(){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter message:");
            message =  myObj.nextLine(); ;
    }

}
