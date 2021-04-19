package View;
import Controller.GameManager;
import Controller.MonoController;
import Models.Entidades.Entidad;
import Models.Entidades.Movibles.EntidadMovible;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Ventana extends JFrame {

    private GameManager gameManager;
    private CampoBoton[][] matrizButton;
    private JPanel panel;
    private Integer WIDTH = 800;
    private Integer HEIGHT = 820;
    private ArrayList<String> pressed;


    private Ventana() {
        super("DonkeyKongJr_Server_View");
        gameManager = new GameManager();
        matrizButton = new CampoBoton[GameManager.TAMANO_MATRIZ][GameManager.TAMANO_MATRIZ];
        pressed = new ArrayList<>();
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        panel.addKeyListener(new MyKeyListener());
        Hilo hilo = new Hilo();
        hilo.start();
    }

    private void ejecuta() {
        setSize(WIDTH, HEIGHT);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMatriz();
        setVisible(true);
        actualizarMatrizInterfaz();
    }

    private void initMatriz(){
        for(int fila = 0; fila < GameManager.TAMANO_MATRIZ; fila++){
            for(Integer columna = 0; columna < GameManager.TAMANO_MATRIZ; columna++){
                addButtonMatriz(fila,columna);
            }
        }
    }

    private void addButtonMatriz(Integer fila, Integer columna){

        /**
         * esto se quita, es para mover al mono pero solo deberia poder hacerlo el servidor
         */

        CampoBoton boton = new CampoBoton(fila,columna);
        boton.addKeyListener(new MyKeyListener());
        boton.setBounds(8+columna*7,8+fila*7, 7,7);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boton.setBackground(Color.GREEN);
            }
        });
        panel.add(boton);
        matrizButton[fila][columna] = boton;
    }

    private void actualizarMatrizInterfaz(){
        if(gameManager.isHaPerdido()){
            JOptionPane.showMessageDialog(null, "HA PERDIDO: su puntuacion es", "ha perdido", JOptionPane.INFORMATION_MESSAGE);
            gameManager.setCondicionesIniciales();
        }

        for(int fila = 0; fila < GameManager.TAMANO_MATRIZ; fila++){
            for(int columna = 0; columna < GameManager.TAMANO_MATRIZ; columna++){
                if(gameManager.getMatriz()[fila][columna] != null && matrizButton[fila][columna] != null){

                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.MONO){
                        matrizButton[fila][columna].setBackground(Color.WHITE);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.PLATAFORMA){
                        matrizButton[fila][columna].setBackground(Color.GREEN);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.LIANA){
                        matrizButton[fila][columna].setBackground(Color.ORANGE);
                    }

                }else if(matrizButton[fila][columna] != null){
                    matrizButton[fila][columna].setBackground(Color.BLACK);
                }

            }
        }
    }

    public class Hilo extends Thread{

        @Override
        public void run() {
            while (true){
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                actualizarMatrizInterfaz();
            }
        }
    }


    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

            if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W'){

                if(!pressed.contains("ARRIBA") ){
                    pressed.add("ARRIBA");
                }
            }
            if(e.getKeyChar() == 's' || e.getKeyChar() == 'S'){
                if(!pressed.contains("ABAJO")){
                    pressed.add("ABAJO");
                }
            }
            if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                if(!pressed.contains("DERECHA")){
                    pressed.add("DERECHA");
                }
            }
            if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A'){
                if(!pressed.contains("IZQUIERDA")){
                    pressed.add("IZQUIERDA");
                }
            }

            for(int i = 0; i < pressed.size(); i++){

                if(pressed.contains("ARRIBA") && pressed.contains("DERECHA") && !gameManager.getDonkeyKongJr().isJumping()
                        && gameManager.getMonoController().estaEnSuelo()){
                    gameManager.getDonkeyKongJr().setJumping(true);
                    gameManager.getMonoController().saltar(EntidadMovible.Direccion.DERECHA);

                }if(pressed.contains("ARRIBA") && pressed.contains("IZQUIERDA") && !gameManager.getDonkeyKongJr().isJumping()
                        && gameManager.getMonoController().estaEnSuelo()){
                    gameManager.getDonkeyKongJr().setJumping(true);
                    gameManager.getMonoController().saltar(EntidadMovible.Direccion.IZQUIERDA);

                    //gameManager.getMonoController().moverMono(EntidadMovible.Direccion.ARRIBA);
                }else if(pressed.get(i).equals("ARRIBA") && !gameManager.getDonkeyKongJr().isJumping()
                        && gameManager.getMonoController().estaEnSuelo()) {

                    gameManager.getDonkeyKongJr().setJumping(true);
                    gameManager.getMonoController().saltar(null);
                }else if(pressed.get(i).equals("ARRIBA") && gameManager.getDonkeyKongJr().isOnLiana()){
                    gameManager.getMonoController().moverMono(EntidadMovible.Direccion.ARRIBA);
                }
                if(pressed.get(i).equals("ABAJO") && gameManager.getDonkeyKongJr().isOnLiana()){
                    gameManager.getMonoController().moverMono(EntidadMovible.Direccion.ABAJO);
                }
                if(pressed.get(i).equals("DERECHA") && !gameManager.getDonkeyKongJr().isJumping()
                        && !gameManager.getDonkeyKongJr().isFalling()){
                    gameManager.getMonoController().moverMono(EntidadMovible.Direccion.DERECHA);
                }
                if(pressed.get(i).equals("IZQUIERDA") && !gameManager.getDonkeyKongJr().isJumping()
                        && !gameManager.getDonkeyKongJr().isFalling()){
                    gameManager.getMonoController().moverMono(EntidadMovible.Direccion.IZQUIERDA);
                }
                if(gameManager.getDonkeyKongJr().isOnLiana()){
                    gameManager.crearLianas();
                }
                actualizarMatrizInterfaz();
            }
            actualizarMatrizInterfaz();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()) {

                case KeyEvent.VK_W:
                    pressed.remove("ARRIBA");
                    break;
                case KeyEvent.VK_S:
                    pressed.remove("ABAJO");
                    break;
                case KeyEvent.VK_A:
                    pressed.remove("IZQUIERDA");
                    break;
                case KeyEvent.VK_D:
                    pressed.remove("DERECHA");
                    break;
            }
        }
    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // se pueden crear n ventanas
                Ventana ventana = new Ventana();

                ventana.ejecuta();
                ventana.gameManager.start();

                //new Ventana().ejecuta();

            }
        });
    }
}
