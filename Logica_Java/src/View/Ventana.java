package View;
import Controller.GameManager;
import Controller.MonoController;
import Models.Entidades.Entidad;
import Models.Entidades.Movibles.EntidadMovible;
import Models.Entidades.Movibles.Fruta;
import Models.Entidades.Utils.PuntoMatriz;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ventana extends JFrame {

    private GameManager gameManager;
    private CampoBoton[][] matrizButton;
    private JPanel panel;
    private Integer WIDTH = 920;
    private Integer HEIGHT = 820;
    private ArrayList<String> pressed;
    private JButton botonCocodriloRojo;
    private JButton botonCocodriloAzul;
    private JButton botonFrutaBanano;
    private JButton botonFrutaManzana;
    private JButton botonFrutaMelocoton;
    private JLabel entidadSeleccionada;
    private JTextField puntosEntry;
    private JLabel labelPuntuacion;
    private int puntos = 0;

    private Ventana() {
        super("DonkeyKongJr_Server_View");
        gameManager = new GameManager();
        matrizButton = new CampoBoton[GameManager.TAMANO_MATRIZ][GameManager.TAMANO_MATRIZ];
        pressed = new ArrayList<>();
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        panel.addKeyListener(new MyKeyListener());

        initComponents();

        //botonCocodriloAzul = new JButton("Cocodrilo rojo")

        new Hilo().start();
    }

    private void initComponents(){
        JLabel titulo = new JLabel("   servidor donkinkongJr: " + gameManager.getIdGame());
        titulo.setFont(new java.awt.Font("CONSOLAS", Font.BOLD, 31));
        titulo.setBounds(10,10, 700,60);
        titulo.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK,Color.BLACK));
        panel.add(titulo);

        int yInicial = 75;

        labelPuntuacion = new JLabel("Puntuacion: 0");
        labelPuntuacion.setFont(new java.awt.Font("CONSOLAS", Font.BOLD, 15));
        labelPuntuacion.setBounds(730,10, 160,60);
        labelPuntuacion.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK,Color.BLACK));
        labelPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelPuntuacion);

        entidadSeleccionada = new JLabel("No ha seleccionado");
        entidadSeleccionada.setFont(new java.awt.Font("CONSOLAS", Font.BOLD, 15));
        entidadSeleccionada.setBounds(730,yInicial, 160,60);
        entidadSeleccionada.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK,Color.BLACK));
        entidadSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(entidadSeleccionada);

        botonCocodriloRojo = new JButton("Coco rojo");
        botonCocodriloRojo.setBackground(Color.RED);
        botonCocodriloRojo.setBounds(752,yInicial+70,100,100);
        botonCocodriloRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entidadSeleccionada.setText("Coco rojo");
                gameManager.setEntidadSeleccionada(Entidad.TipoEntidad.COCODRILO_ROJO);
            }
        });

        botonCocodriloAzul = new JButton("Coco azul");
        botonCocodriloAzul.setBackground(Color.BLUE);
        botonCocodriloAzul.setBounds(752,yInicial+90*2,100,100);
        botonCocodriloAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entidadSeleccionada.setText("Coco azul");
                gameManager.setEntidadSeleccionada(Entidad.TipoEntidad.COCODRILO_AZUL);
            }
        });

        puntosEntry = new JTextField("Puntos");
        puntosEntry.setHorizontalAlignment(SwingConstants.CENTER);
        puntosEntry.setBounds(752, yInicial+120*3-60, 100, 50);
        puntosEntry.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                puntosEntry.setText("");
            }
        });

        botonFrutaBanano = new JButton("Banano");
        botonFrutaBanano.setBackground(Color.YELLOW);
        botonFrutaBanano.setBounds(752, yInicial+120*3, 100, 100);
        botonFrutaBanano.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entidadSeleccionada.setText("Banano");
                gameManager.setEntidadSeleccionada(Entidad.TipoEntidad.BANANO);
            }
        });

        botonFrutaManzana = new JButton("Manzana");
        botonFrutaManzana.setBackground(Color.RED);
        botonFrutaManzana.setBounds(752, yInicial+117*4, 100, 100);
        botonFrutaManzana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entidadSeleccionada.setText("Manzana");
                gameManager.setEntidadSeleccionada(Entidad.TipoEntidad.MANZANA);
            }
        });

        botonFrutaMelocoton = new JButton("Melocoton");
        botonFrutaMelocoton.setBackground(Color.ORANGE);
        botonFrutaMelocoton.setBounds(752, yInicial+115*5, 100, 100);
        botonFrutaMelocoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entidadSeleccionada.setText("Melocoton");
                gameManager.setEntidadSeleccionada(Entidad.TipoEntidad.MELOCOTON);
            }
        });

        panel.add(botonCocodriloAzul);
        panel.add(botonCocodriloRojo);
        panel.add(botonFrutaBanano);
        panel.add(botonFrutaManzana);
        panel.add(botonFrutaMelocoton);
        panel.add(puntosEntry);
    }

    private void ejecuta() {
        setSize(WIDTH, HEIGHT);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMatriz();
        setVisible(true);
        //actualizarMatrizInterfaz();
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

        CampoBoton boton = new CampoBoton(fila,columna,"vacio");
        boton.addKeyListener(new MyKeyListener());
        boton.setBounds(8+columna*7,75+fila*7, 7,7);
        boton.addActionListener(e -> generarEntidad(boton));
        boton.setBorder(BorderFactory.createBevelBorder(5, Color.BLACK,Color.BLACK));
        panel.add(boton);
        matrizButton[fila][columna] = boton;
    }


    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    private void generarEntidad(CampoBoton boton){

        System.out.println(boton.getFila() + " , " + boton.getColumna() );

        if(boton.getId().contains("fruta")){
            Fruta fruta = gameManager.getFrutaController().buscarFrutaById(boton.getId());
            gameManager.getFrutaController().borrarFruta(fruta);
        }
        if(gameManager.getEntidadSeleccionada() == null){
            JOptionPane.showMessageDialog(null, "aun no ha seleccionado una entidad para crear",
                    "Aviso!", JOptionPane.INFORMATION_MESSAGE);

        }
        if(boton.getId().contains("liana")){
            gameManager.crearCocodrilo(boton.getId());
        }
        if(boton.getId().equals("vacio")){

            if(gameManager.getEntidadSeleccionada() == Entidad.TipoEntidad.COCODRILO_ROJO || gameManager.getEntidadSeleccionada()
                    == Entidad.TipoEntidad.COCODRILO_AZUL){
                JOptionPane.showMessageDialog(null, "solo se pueden colocar cocodrilos en las lianas",
                        "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if(puntosEntry.getText().isBlank() && !isNumeric(puntosEntry.getText())){
                JOptionPane.showMessageDialog(null, "no se ha ingresado el valor en puntos",
                        "Aviso!", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(isNumeric(puntosEntry.getText())){
                    gameManager.crearFruta(new PuntoMatriz(boton.getFila(),boton.getColumna()), Integer.parseInt(puntosEntry.getText()));
                }else{
                    JOptionPane.showMessageDialog(null, "error en el valor de los puntos",
                            "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        }

    }

    private void actualizarMatrizInterfaz(){
        /*
        if(gameManager.getDonkeyKongJr().isHaPerdido()){
             gameManager.setCondicionesIniciales();
             return;
        }*/

        for(int fila = 0; fila < GameManager.TAMANO_MATRIZ; fila++){
            for(int columna = 0; columna < GameManager.TAMANO_MATRIZ; columna++){

                if(gameManager.getMatriz()[fila][columna] == null && matrizButton[fila][columna] != null){
                    matrizButton[fila][columna].setId("vacio");
                }

                if(gameManager.getMatriz()[fila][columna] != null && matrizButton[fila][columna] != null){

                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.MONO){
                        matrizButton[fila][columna].setBackground(Color.WHITE);
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.PLATAFORMA){
                        matrizButton[fila][columna].setBackground(new Color( 226, 112, 41));
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.LIANA){
                        matrizButton[fila][columna].setBackground(Color.ORANGE);
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.AGUA){
                        matrizButton[fila][columna].setBackground(Color.CYAN);
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.TROFEO){
                        matrizButton[fila][columna].setBackground(Color.BLUE);
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_AZUL){
                        matrizButton[fila][columna].setBackground(Color.BLUE);
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_ROJO){
                        matrizButton[fila][columna].setBackground(Color.RED);
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.BANANO){
                        matrizButton[fila][columna].setBackground(Color.YELLOW);
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.MANZANA){
                        matrizButton[fila][columna].setBackground(Color.RED);
                    }
                    if(gameManager.getMatriz()[fila][columna] != null && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.MELOCOTON){
                        matrizButton[fila][columna].setBackground(Color.ORANGE);
                    }

                    if(gameManager.getMatriz()[fila][columna] != null ){
                        matrizButton[fila][columna].setId(gameManager.getMatriz()[fila][columna].getId());
                    }else{
                        matrizButton[fila][columna].setId("vacio");
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
                if(gameManager.getDonkeyKongJr().isHaGanado()){
                    JOptionPane.showMessageDialog(null, "Ha ganado, sigue un nivel mas veloz!",
                            "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                    gameManager.setNivel(gameManager.getNivel()+1);
                    pressed.clear();
                    gameManager.setCondicionesIniciales();
                }
                if(gameManager.getDonkeyKongJr().isHaPerdido()){
                    JOptionPane.showMessageDialog(null, "Ha perdido",
                            "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                    pressed.clear();
                    gameManager.setCondicionesIniciales();
                }else{
                    labelPuntuacion.setText("Puntuacion: " + gameManager.getDonkeyKongJr().getPuntuacion());
                    actualizarMatrizInterfaz();
                }

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
                }else if(pressed.get(i).equals("ARRIBA") && gameManager.getDonkeyKongJr().isOnLiana()
                        && !gameManager.verificarChoquePlataformaArriba()){
                    gameManager.getMonoController().moverMono(EntidadMovible.Direccion.ARRIBA);
                }
                if(pressed.get(i).equals("ABAJO") && gameManager.getDonkeyKongJr().isOnLiana()
                        && !gameManager.verificarChoquePlataformaAbajo()){
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
                    gameManager.getCreadorDeMapa().crearLianas();
                }
                //actualizarMatrizInterfaz();
            }
            //actualizarMatrizInterfaz();
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
