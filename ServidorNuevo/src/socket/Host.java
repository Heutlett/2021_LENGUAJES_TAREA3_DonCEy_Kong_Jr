package socket;

import java.io.IOException;

public class Host implements Runnable {

    // constantes
    public final static int port1 = 9501;
    public final static int port2 = 9502;

    // Attributes
    private Sockets socket = new Sockets();
    private static Host host1 = null;
    private static Host host2 = null;

    private Integer guessIndex = 0;
    private static Integer playerIndex = 0;
    public String[] IPs = {"", "", ""}; // {Player, Viewer1, Viewer2}
    private int player, port;
    private String jsonMatrix = "";


    // Constructor
    private Host(int player, Integer port){
        this.player = player;
        this.port = port;
        System.out.printf("➽ Host %d. Running in port: %d!%n", player, port);

    }

    // Singleton
    public static Host getInstance(Integer host) {
        if (host == 1) {
            return (host1 == null) ? (host1 = new Host(1, Host.port1)) : host1;
        } else {
            return (host2 == null) ? (host2 = new Host(2, Host.port2)) : host2;
        }
    }

    public void addGuess(String IP){
        IPs[guessIndex++] = IP;
    }

    public boolean isEmpty(){
        return this.IPs[playerIndex].equals("");
    }

    public boolean isFull(){
        if (this.isEmpty()) return false;
        for(String ip : IPs) {
            if (ip.equals("")) return false;
        }
        return true;
    }


    @Override
    public void run() {
        while(true){
            this.jsonMatrix = socket.listen(port);
            for (int i = 1; i < IPs.length ; i++){
                try{
                    if (!IPs[i].equals("")){
                        socket.send(IPs[i], port, jsonMatrix);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
//                if (this.player == 1){
//                    if (Game.p1Kremlin != null){
//                        socket.send(IPs[0], port, Game.p1Kremlin);
//                        Game.p1Kremlin = null;
//                    }if (Game.p1Fruit != null){
//                        socket.send(IPs[0], port, Game.p1Fruit);
//                        Game.p1Fruit = null;
//                    }
//                }else{
//                    if (Game.p2Kremlin != null){
//                        socket.send(IPs[0], port, Game.p1Kremlin);
//                        Game.p2Kremlin = null;
//                    }if (Game.p2Fruit != null){
//                        socket.send(IPs[0], port, Game.p1Fruit);
//                        Game.p2Fruit = null;
//                    }
//                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

