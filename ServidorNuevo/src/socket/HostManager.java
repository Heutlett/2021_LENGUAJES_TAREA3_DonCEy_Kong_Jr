package socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;

public class HostManager implements Runnable {

    // constante
    final static int port = 9500;

    private Sockets socket = new Sockets();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Host host1 = null;
    private Host host2 = null;
    private Game game = null;
    private final int currentHost = 0;
    private String ip = "";
    private String guessType = "";


    // Constructor
    public HostManager() throws IOException {
        System.out.println("➽ HostManager. Start!");
        host1 = Host.getInstance(1);
        host2 = Host.getInstance(2);
        game = Game.getInstance();
        Thread th = new Thread(this);
        th.start();
    }

//    // Initializer
//    public static void main(String[] args) throws IOException {
//        HostManager hostManager = new HostManager();
//    }

    // Methods
    @Override
    public void run() {
        try {
            menu();
            System.out.println("Salió del menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // menu.
    // player - lo hace host si hay campo.
    // spectator - envia partidas en juego, espera respuesta y luego deja espectear la partida.
    private void menu() throws IOException {
        this.ip = socket.listen(port); // se recibe la IP.
        this.guessType = socket.listen(port); // se recibe el tipo de invitado.
        String response, seeGame;// Se logró? No / Yes: Puerto
        if ("player".equals(guessType)) {
            response = setHostPlayer();
        } else {
            response = getCurrentGames();
            socket.send(ip, port, response); // si response es "", significa que no hay partidas en juego.
            seeGame = socket.listen(port); // peticion de entrar a un host determinado.
            response = setGuessSpectator(Integer.parseInt(seeGame)); // Se logró? No / Yes: Puerto
        }
//        response = (("player".equals(guessType)) ? setHostPlayer() : setGuessSpectator());
        socket.send(ip, port, response);// responde: 1-H1, 2-H2, no-Ocupado.
    }

    private String setHostPlayer() {
        if (host1.isEmpty()) {
            host1.addGuess(ip);
            System.out.println("➽ A player own Host 1.");
            return String.valueOf(Host.port1);
        } else if (host2.isEmpty()) {
            host2.addGuess(ip);
            System.out.println("➽ A player own Host 2.");
            return String.valueOf(Host.port2);
        }
        return "no";
    }

    private String getCurrentGames() {
        String currentGames = "";
        if (!host1.isEmpty()) currentGames += "1,";
        if (!host2.isEmpty()) currentGames += "2";
        return (!currentGames.equals("")) ? currentGames : "no";
    }

    private String setGuessSpectator(int host) {
        if (host == 1) {
            if (!host1.isFull()) {
                host1.addGuess(ip);
//                System.out.println("➽ A guess logged into Host 1.");
                System.out.printf("➽ A guess logged into Host 2. port: %d.",Host.port2);
                return String.valueOf(Host.port1);
            }
        } else if (host == 2) {
            if (!host2.isFull()) {
                host2.addGuess(ip);
                System.out.printf("➽ A guess logged into Host 2. port: %d.",Host.port2);
                return String.valueOf(Host.port2);
            }
        }
        return "no";
    }

}

