package View;
import Logica.GameManager;
import Models.Entidades.Movibles.EntidadMovible;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana extends JFrame {

    private GameManager gameManager;
    private Boton[][] matrizButton;
    private JPanel panel;
    private int WIDTH = 800;
    private int HEIGHT = 820;


    private Ventana() {
        super("DonkeyKongJr_Server_View");
        gameManager = GameManager.getInstance();
        matrizButton = new Boton[GameManager.TAMANO_MATRIZ][GameManager.TAMANO_MATRIZ];
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
    }

    private void ejecuta() {
        setSize(WIDTH, HEIGHT);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMatriz();
        setVisible(true);
        actualizarMatriz();
    }

    private void initMatriz(){
        for(int fila = 0; fila < GameManager.TAMANO_MATRIZ; fila++){
            for(int columna = 0; columna < GameManager.TAMANO_MATRIZ; columna++){
                addButtonMatriz(fila,columna);
            }
        }
    }

    private void addButtonMatriz(int fila, int columna){

        /**
         * esto se quita, es para mover al mono pero solo deberia poder hacerlo el servidor
         */
        KeyListener listener = new MyKeyListener();

        Boton boton = new Boton(fila,columna);
        boton.setBounds(8+columna*7,8+fila*7, 7,7);
        boton.addKeyListener(listener);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("fila: " + boton.getFila() + " columna: " + boton.getColumna());
                boton.setBackground(Color.GREEN);
            }
        });
        panel.add(boton);
        matrizButton[fila][columna] = boton;
    }

    private void actualizarMatriz(){

        for(int fila = 0; fila < GameManager.TAMANO_MATRIZ; fila++){
            for(int columna = 0; columna < GameManager.TAMANO_MATRIZ; columna++){
                if(gameManager.getMatriz()[fila][columna] != null){
                    matrizButton[fila][columna].setBackground(Color.WHITE);
                }else{
                    matrizButton[fila][columna].setBackground(Color.BLACK);
                }
            }
        }
    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().ejecuta();
            }
        });
    }

    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

            if(KeyEvent.getKeyText(e.getKeyCode()).equals("Derecha")){
                gameManager.moverMono(EntidadMovible.Direccion.DERECHA);
                actualizarMatriz();
            }
            if(KeyEvent.getKeyText(e.getKeyCode()).equals("Izquierda")){
                gameManager.moverMono(EntidadMovible.Direccion.IZQUIERDA);
                actualizarMatriz();
            }
            if(KeyEvent.getKeyText(e.getKeyCode()).equals("Arriba")){
                gameManager.moverMono(EntidadMovible.Direccion.ARRIBA);
                actualizarMatriz();
            }
            if(KeyEvent.getKeyText(e.getKeyCode()).equals("Abajo")){
                gameManager.moverMono(EntidadMovible.Direccion.ABAJO);
                actualizarMatriz();
            }


        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

}
