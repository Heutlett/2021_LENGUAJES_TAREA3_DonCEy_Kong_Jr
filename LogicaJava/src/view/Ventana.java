package view;
import controller.GameManager;
import models.entidades.Entidad;
import models.entidades.movibles.EntidadMovible;
import models.entidades.movibles.Fruta;
import models.entidades.utils.JSON_Generator;
import models.entidades.utils.PuntoMatriz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ventana extends JFrame {

    public GameManager gameManager;
    private CampoBoton[][] matrizButton;
    private JPanel panel;
    private Integer WIDTH = 1020;
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
    private JLabel labelVidas;
    private JLabel labelNivel;
    private int puntos = 0;

    public Ventana() {
        super("DonkeyKongJr_Server_View");
        gameManager = new GameManager();
        matrizButton = new CampoBoton[GameManager.TAMANO_MATRIZ][GameManager.TAMANO_MATRIZ];
        pressed = new ArrayList<>();
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        panel.addKeyListener(new MyKeyListener());
        initComponents();
        new HiloVentana().start();
    }

    /**
     * Funcion: initComponents
     * Inicializa todos los componentes de la interfaz grafica del servidor
     */
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

        labelVidas = new JLabel("Vidas: 1");
        labelVidas.setFont(new java.awt.Font("CONSOLAS", Font.BOLD, 15));
        labelVidas.setBounds(910,10, 90,60);
        labelVidas.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK,Color.BLACK));
        labelVidas.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelVidas);

        labelNivel = new JLabel("Nivel: 1");
        labelNivel.setFont(new java.awt.Font("CONSOLAS", Font.BOLD, 15));
        labelNivel.setBounds(910,yInicial, 90,60);
        labelNivel.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK,Color.BLACK));
        labelNivel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelNivel);

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

    /**
     * Funcion: ejecuta
     * Inicia la interfaz grafica
     */
    public void ejecuta() {
        setSize(WIDTH, HEIGHT);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMatriz();
        setVisible(true);
    }

    /**
     * Funcion: initMatriz
     * Inicializa la matriz de botones que se utiliza en la interfaz grafica
     */
    private void initMatriz(){
        for(int fila = 0; fila < GameManager.TAMANO_MATRIZ; fila++){
            for(Integer columna = 0; columna < GameManager.TAMANO_MATRIZ; columna++){
                addButtonMatriz(fila,columna);
            }
        }
    }

    /**
     * Funcion: addButtonMatriz
     * @param fila fila de la matriz donde se ubicara el boton
     * @param columna columna de la matriz donde se ubicara el boton
     */
    private void addButtonMatriz(Integer fila, Integer columna){

        CampoBoton boton = new CampoBoton(fila,columna,"vacio");
        boton.addKeyListener(new MyKeyListener());
        boton.setBounds(8+columna*7,75+fila*7, 7,7);
        boton.addActionListener(e -> generarEntidad(boton));
        boton.setBorder(BorderFactory.createBevelBorder(5, Color.BLACK,Color.BLACK));
        panel.add(boton);
        matrizButton[fila][columna] = boton;
    }

    /**
     * Funcion: isNumeric
     * Verifica si una cadena es un numero entero
     * @param cadena
     * @return
     */
    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    /**
     * Funcion: generarEntidad
     * Crea una entidad en el juego cuando se presiona un boton (campo) en el que es posible crear un cocodrilo como
     * en las lianas o una fruta en cualquier casilla vacia.
     * @param boton boton que se ha presionado para crear la entidad
     */
    private void generarEntidad(CampoBoton boton){

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

    /**
     * Funcion: actualizarMatrizInterfaz
     * Actualiza la matriz de botones de la interfaz grafica
     */
    private void actualizarMatrizInterfaz(){

        for(int fila = 0; fila < GameManager.TAMANO_MATRIZ; fila++){
            for(int columna = 0; columna < GameManager.TAMANO_MATRIZ; columna++){

                if(gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.VACIO
                        && matrizButton[fila][columna] != null){
                    matrizButton[fila][columna].setId("vacio");
                    matrizButton[fila][columna].setBackground(Color.BLACK);
                }

                if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && matrizButton[fila][columna] != null){

                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.MONO){
                        matrizButton[fila][columna].setBackground(Color.WHITE);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.PLATAFORMA){
                        matrizButton[fila][columna].setBackground(new Color( 226, 112, 41));
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.LIANA){
                        matrizButton[fila][columna].setBackground(Color.ORANGE);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.AGUA){
                        matrizButton[fila][columna].setBackground(Color.BLUE);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.TROFEO){
                        matrizButton[fila][columna].setBackground(Color.BLUE);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_AZUL){
                        matrizButton[fila][columna].setBackground(Color.BLUE);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_ROJO){
                        matrizButton[fila][columna].setBackground(Color.RED);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.BANANO){
                        matrizButton[fila][columna].setBackground(Color.YELLOW);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.MANZANA){
                        matrizButton[fila][columna].setBackground(Color.RED);
                    }
                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO && gameManager.getMatriz()[fila][columna].getTipoEntidad() == Entidad.TipoEntidad.MELOCOTON){
                        matrizButton[fila][columna].setBackground(new Color(158, 74, 15));
                    }

                    if(gameManager.getMatriz()[fila][columna].getTipoEntidad() != Entidad.TipoEntidad.VACIO ){
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



    /**
     * ################################################################################################################
     * THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS
     * ################################################################################################################
     */

    /**
     * Hilo de la ventana, se encarga de actualizar la matriz de botones, este hilo mantiene la interfaz grafica
     * sincronizada con el controlador del juego, GameManager.
     */
    public class HiloVentana extends Thread{

        @Override
        public void run() {
            while (true){
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // SI GANA
                if(gameManager.getDonkeyKongJr().isHaGanado()){
                    pressed.clear();
                }
                if(gameManager.getDonkeyKongJr().isHaPerdido()){
                    pressed.clear();
                }
                labelPuntuacion.setText("Puntuacion: " + gameManager.getDonkeyKongJr().getPuntuacion());
                labelVidas.setText("Vidas: " + gameManager.getVidas());
                labelNivel.setText("Nivel: " + gameManager.getNivel());
                actualizarMatrizInterfaz();

            }
        }
    }

    /**
     * Listener para mover al mono desde la interfaz del servidor con las teclas WASD
     */
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

                if(pressed.contains("ARRIBA") && pressed.contains("DERECHA")){
                    controladorDeMovimiento("WD");
                }if(pressed.contains("ARRIBA") && pressed.contains("IZQUIERDA")){
                    controladorDeMovimiento("WA");
                }else if(pressed.get(i).equals("ARRIBA")) {
                    controladorDeMovimiento("W");
                }
                if(pressed.get(i).equals("ABAJO")){
                    controladorDeMovimiento("S");
                }
                if(pressed.get(i).equals("DERECHA")){
                    controladorDeMovimiento("D");
                }
                if(pressed.get(i).equals("IZQUIERDA")){
                    controladorDeMovimiento("A");
                }
            }
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
    /**
     * ################################################################################################################
     * API DE CONTROL PARA EL SERVIDOR
     * ################################################################################################################
     */

    /**
     * Funcion: controladorDeMovimiento
     * Maneja el movimiento del mono a partir de un comando de direccion en formato WASD
     * @param command String que determina hacia donde se movera el mono  (W=ARRIBA, A=IZQUIERAD, D= DERECHA, S=ABAJO)
     */
    public void controladorDeMovimiento(String command) {

        if(command.equals("WD") && !gameManager.getDonkeyKongJr().isJumping()
                && gameManager.getMonoController().estaEnSuelo()){
            gameManager.getDonkeyKongJr().setJumping(true);
            gameManager.getMonoController().saltar(EntidadMovible.Direccion.DERECHA);

        }if(command.equals("WA") && !gameManager.getDonkeyKongJr().isJumping()
                && gameManager.getMonoController().estaEnSuelo()){
            gameManager.getDonkeyKongJr().setJumping(true);
            gameManager.getMonoController().saltar(EntidadMovible.Direccion.IZQUIERDA);

        }else if(command.equals("W") && !gameManager.getDonkeyKongJr().isJumping()
                && gameManager.getMonoController().estaEnSuelo()) {

            gameManager.getDonkeyKongJr().setJumping(true);
            gameManager.getMonoController().saltar(null);
        }else if(command.equals("W") && gameManager.getDonkeyKongJr().isOnLiana()
                && !gameManager.verificarChoquePlataformaArriba()){
            gameManager.getMonoController().moverMono(EntidadMovible.Direccion.ARRIBA);
        }
        if(command.equals("S") && gameManager.getDonkeyKongJr().isOnLiana()
                && !gameManager.verificarChoquePlataformaAbajo()){
            gameManager.getMonoController().moverMono(EntidadMovible.Direccion.ABAJO);
        }
        if(command.equals("D") && !gameManager.getDonkeyKongJr().isJumping()
                && !gameManager.getDonkeyKongJr().isFalling()){
            gameManager.getMonoController().moverMono(EntidadMovible.Direccion.DERECHA);
        }
        if(command.equals("A") && !gameManager.getDonkeyKongJr().isJumping()
                && !gameManager.getDonkeyKongJr().isFalling()){
            gameManager.getMonoController().moverMono(EntidadMovible.Direccion.IZQUIERDA);
        }
        if(gameManager.getDonkeyKongJr().isOnLiana()){
            gameManager.getCreadorDeMapa().crearLianas();
        }
    }

    /**
     * Funcion: generarJSON
     * Genera un JSON con la informacion actual del juego
     * @return retorna un string en formato json de la informacion actual del juego
     */

    public String generarJSON(){

        return gameManager.generateJSON();

    }




    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // se pueden crear n ventanas
                Ventana ventana = new Ventana();
                //Ventana ventana2 = new Ventana();

                ventana.ejecuta();
                ventana.gameManager.start();
                //ventana2.ejecuta();
                //ventana2.gameManager.start();

                //new Ventana().ejecuta();

            }
        });
    }
}
