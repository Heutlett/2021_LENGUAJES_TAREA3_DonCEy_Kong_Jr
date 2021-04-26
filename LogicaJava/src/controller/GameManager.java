package controller;

import models.entidades.Entidad;
import models.entidades.estaticas.EntidadEstatica;
import models.entidades.movibles.Cocodrilo;
import models.entidades.movibles.EntidadMovible;
import models.entidades.movibles.Fruta;
import models.entidades.movibles.Mono;
import models.entidades.utils.JSON_Generator;
import models.entidades.utils.PuntoMatriz;
import java.util.ArrayList;

/**
 * Controlador principal del juego, en este se maneja toda la logica del juego como la creacion de entidades, el
 * movimiento de las mismas, las condiciones de victoria y derrota.
 */
public class GameManager extends Thread{

    /**
     * Matriz principal que contiene todas las entidades del juego
     */
    private volatile Entidad[][] matriz;

    /**
     * Contenedores para almacenar las entidades
     */
    private volatile Mono donkeyKongJr;
    private volatile ArrayList<Cocodrilo> cocodrilos;
    private volatile ArrayList<Fruta> frutas;
    private volatile EntidadEstatica[] lianas;
    private volatile EntidadEstatica[] plataformas;
    private volatile EntidadEstatica[] agua;
    private volatile EntidadEstatica trofeo;

    /**
     * Controladores de las entidades
     */
    private volatile MonoController monoController;
    private volatile CocodriloController cocodriloController;
    private volatile FrutaController frutaController;

    /**
     * Controlador para crear y actualizar las estructuras bases del juego
     */
    public CreadorDeMapa creadorDeMapa;

    /**
     * Constantes y variables del controlador controlador principal GameManager
     */
    private String id;
    public static int count = 0;
    private Entidad.TipoEntidad entidadSeleccionada;
    public static Integer TAMANO_MATRIZ = 100;
    public static PuntoMatriz POSICION_INICIAL = new PuntoMatriz(79,1);
    private int contadorCaida;
    private int nivel;
    private int vidas;
    private int MAXIMA_ALTURA_CAIDA = 20;

    /**
     * Constructor del controlador principal, se instancian todos los objetos y variables necesarias para iniciar el
     * juego
     */
    public GameManager()
    {
        id = "gameManager" + count;
        System.out.println("Se ha creado un nuevo juego, asignado a: " + id);
        count++;

        vidas = 1;
        nivel = 1;
        contadorCaida = 0;

        donkeyKongJr = new Mono("dkjr", POSICION_INICIAL, EntidadMovible.Direccion.DERECHA, Entidad.TipoEntidad.MONO);
        cocodrilos =  new ArrayList<>();
        frutas = new ArrayList<>();
        lianas = new EntidadEstatica[14];
        plataformas = new EntidadEstatica[11];
        agua = new EntidadEstatica[1];
        matriz = new Entidad[TAMANO_MATRIZ][TAMANO_MATRIZ];
        setearMatrizVacia();

        frutaController = new FrutaController(matriz, frutas);
        monoController = new MonoController(donkeyKongJr, matriz, frutaController);
        cocodriloController = new CocodriloController(matriz, cocodrilos, lianas, monoController, donkeyKongJr);

        creadorDeMapa = new CreadorDeMapa(matriz,lianas,plataformas,agua, trofeo);
        creadorDeMapa.inicializarMapa();
        setCondicionesIniciales();

        new HiloMoverCocodrilosFrutas().start();
    }

    /**
     * Funcion: generarMatrizPosicionesActuales
     * Genera una matriz de enteros con las posiciones actuales de cada entidad para pasarla al cliente en formato json
     * @return matriz int
     */
    private int[][] generarMatrizPosicionesActuales(){
        int [][] matrizPos = new int[TAMANO_MATRIZ][TAMANO_MATRIZ];
        try{
            matrizPos[donkeyKongJr.getPosicion().getFila()][donkeyKongJr.getPosicion().getColumna()] = 1;

            for (Cocodrilo cocodrilo : cocodrilos) {
                if (cocodrilo.getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_ROJO) {
                    matrizPos[cocodrilo.getPosicion().getFila()][cocodrilo.getPosicion().getColumna()] = 2;
                } else {
                    matrizPos[cocodrilo.getPosicion().getFila()][cocodrilo.getPosicion().getColumna()] = 3;
                }
            }

            for (Fruta fruta : frutas) {
                if (fruta.getTipoEntidad() == Entidad.TipoEntidad.BANANO) {
                    matrizPos[fruta.getPosicion().getFila()][fruta.getPosicion().getColumna()] = 4;
                }
                if (fruta.getTipoEntidad() == Entidad.TipoEntidad.MANZANA) {
                    matrizPos[fruta.getPosicion().getFila()][fruta.getPosicion().getColumna()] = 5;
                }
                if (fruta.getTipoEntidad() == Entidad.TipoEntidad.MELOCOTON) {
                    matrizPos[fruta.getPosicion().getFila()][fruta.getPosicion().getColumna()] = 6;
                }
            }
            return matrizPos;
        }catch (Exception e){

        }
        return matrizPos;
    }


    /**
     * Funcion: setearMatrizVacia
     * Inicializa la matriz llenando todos los campos como entidades vacias
     */
    public void setearMatrizVacia(){
        for(int i = 0; i < TAMANO_MATRIZ; i++){
            for(int e = 0; e < TAMANO_MATRIZ; e++){
                matriz[i][e] = Entidad.crearEntidadVacia();
            }
        }
    }

    /**
     * Funcion: setCondicionesIniciales
     * Se setean las condiciones iniciales del juego
     */
    public void setCondicionesIniciales(){
        setearMatrizVacia();


        monoController.limpiarAreaAnteriorMono();
        donkeyKongJr.moverConPosicion(POSICION_INICIAL);
        contadorCaida = 0;
        donkeyKongJr.setHaGanado(false);
        donkeyKongJr.setHaPerdido(false);
        donkeyKongJr.setJumping(false);
        donkeyKongJr.setOnLiana(false);
        cocodriloController.limpiarAreaAnteriorCocodrilos();
        cocodrilos.clear();
        frutaController.limpiarAreaAnteriorFrutas();
        frutas.clear();
    }

    /**
     * Funcion: siHaPerdido
     * Se establecen las condiciones en el caso de que el jugador haya perdido
     */
    public void siHaPerdido(){
        donkeyKongJr.setHaPerdido(false);
        vidas--;
        if(vidas == 0){
            setCondicionesIniciales();
            vidas = 1;
            nivel = 1;
            donkeyKongJr.setPuntuacion(0);  
        }else{
            monoController.limpiarAreaAnteriorMono();
            donkeyKongJr.moverConPosicion(POSICION_INICIAL);
        }
    }

    /**
     * Funcion: setReinicioGanar
     * Establece las condiciones cuando el jugador gana
     */
    public void setReinicioGanar(){
        nivel++;
        vidas++;
        setCondicionesIniciales();
    }

    /**
     * Funcion: crearCocodrilo
     * Crea un cocodrilo y lo agrega a la matriz
     * @param idLiana liana donde se colocara el cocodrilo
     */
    public void crearCocodrilo(String idLiana){

        if(entidadSeleccionada != null && entidadSeleccionada == Entidad.TipoEntidad.COCODRILO_AZUL
                || entidadSeleccionada == Entidad.TipoEntidad.COCODRILO_ROJO ) {
            Cocodrilo cocodrilo = new Cocodrilo(null, null, null, null, null,
                    null);
            cocodrilo.setId("cocodrilo" + cocodrilos.size());
            EntidadEstatica liana = buscarLianaById(idLiana);
            if (liana != null) {
                cocodrilo.setPosicion(liana.getPosicion());
            }
            cocodrilo.direccionAreaAbajo();
            cocodrilo.setTipoEntidad(entidadSeleccionada);
            cocodrilo.setDireccion(EntidadMovible.Direccion.ABAJO);
            cocodrilo.setIdLiana(idLiana);
            cocodrilos.add(cocodrilo);
            System.out.println("Se ha creado un cocodrilo: " + cocodrilo.toStringCreado());
        }
    }

    /**
     * Funcion: crearFruta
     * Crea una fruta y la agrega a la matriz
     * @param posicion posicion donde se ubicara la fruta creada
     * @param puntos puntos que otorgara la fruta creada
     */
    public void crearFruta(PuntoMatriz posicion, int puntos) {

        if (entidadSeleccionada != null && entidadSeleccionada != Entidad.TipoEntidad.COCODRILO_AZUL
                && entidadSeleccionada != Entidad.TipoEntidad.COCODRILO_ROJO) {
            Fruta fruta = new Fruta(posicion, null, entidadSeleccionada, null, puntos);
            frutas.add(fruta);
            frutaController.actualizarFruta(fruta);
            System.out.println("Se ha creado una fruta: " + fruta.toString());
        }
    }

    /**
     * Funcion: buscarLianaById
     * Busca una liana con el id pasado por parametro en el arreglo de lianas
     * @param id id de la fruta a buscar
     * @return retorna la liana si la encuentra y si no la encuentra retorna null
     */
    private EntidadEstatica buscarLianaById(String id){
        for(int i = 0; i < lianas.length; i++){
            if(lianas[i].getId().equals(id)){
                return lianas[i];
            }
        }
        return null;
    }

    /**
     * Funcion: verificarChoquePlataformaArriba
     * Devuelve true si el mono choca con una plataforma al brincar
     * @return true si choca con una plataforma, false de lo contrario
     */
    public boolean verificarChoquePlataformaArriba(){

        for(int i = 0; i < getDonkeyKongJr().getArea().length; i++){
            if(getDonkeyKongJr().getArea()[i] != null){

                if(matriz[donkeyKongJr.getArea()[i].getFila()-1][donkeyKongJr.getArea()[i].getColumna()].getTipoEntidad() != Entidad.TipoEntidad.VACIO){

                    if(matriz[donkeyKongJr.getArea()[i].getFila()-1][donkeyKongJr.getArea()[i].getColumna()].getTipoEntidad() == Entidad.TipoEntidad.PLATAFORMA){
                        return true;
                    }

                }

            }
        }
        return false;
    }

    /**
     * Funcion: verificarChoquePlataformaAbajo
     * Devuelve true si el mono choca con una plataforma al estar en el suelo
     * @return true si choca con una plataforma, false de lo contrario
     */
    public boolean verificarChoquePlataformaAbajo(){
        for(int i = 0; i < getDonkeyKongJr().getArea().length; i++){
            if(getDonkeyKongJr().getArea()[i] != null){

                if((donkeyKongJr.getArea()[i].getFila()+1) >= 0 && (donkeyKongJr.getArea()[i].getFila()+1) < TAMANO_MATRIZ
                        &&  donkeyKongJr.getArea()[i].getColumna() >= 0 && donkeyKongJr.getArea()[i].getColumna() < TAMANO_MATRIZ && matriz[donkeyKongJr.getArea()[i].getFila()+1][donkeyKongJr.getArea()[i].getColumna()] != null
                ){
                    if(matriz[donkeyKongJr.getArea()[i].getFila()+1][donkeyKongJr.getArea()[i].getColumna()].getTipoEntidad() == Entidad.TipoEntidad.PLATAFORMA){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String generateJSON(){
        return JSON_Generator.generateJSON(generarMatrizPosicionesActuales(), nivel, donkeyKongJr.getPuntuacion(), vidas, donkeyKongJr.isHaGanado(), donkeyKongJr.isHaPerdido());
    }

    /**
     * ################################################################################################################
     * THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS
     * ################################################################################################################
     */

    /**
     * Hilo principal del controlador, se encarga de verificar los estados del mono como el salto, la gravedad,
     * condiciones de victoria y derrota.
     */
    public void run() {
        while(true){

            if(donkeyKongJr.isHaGanado()){
                setReinicioGanar();
            }
            if(donkeyKongJr.isHaPerdido()){
                siHaPerdido();
            }

            if(!donkeyKongJr.isJumping() && !donkeyKongJr.isOnLiana() && !getMonoController().estaEnSuelo()
                && !verificarChoquePlataformaAbajo() ){
                contadorCaida++;
                monoController.moverMono(EntidadMovible.Direccion.ABAJO);
            }else{
                if(contadorCaida >= MAXIMA_ALTURA_CAIDA && !donkeyKongJr.isOnLiana()){
                    donkeyKongJr.setHaPerdido(true);
                }
                contadorCaida = 0;
            }

            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Hilo controlador del movimiento de los cocodrilos y las frutas, se encarga de mover a los cocodrilos y las frutas
     */
    class HiloMoverCocodrilosFrutas extends Thread {

        @Override
        public void run() {
            while (true) {
                 if(!donkeyKongJr.isHaPerdido()) {

                    cocodriloController.moverCocodrilos();
                    frutaController.actualizarFrutas();

                    creadorDeMapa.crearLianas();
                    creadorDeMapa.crearAgua();
                    creadorDeMapa.crearPlataformas();
                    creadorDeMapa.crearTrofeo();

                    try {
                        if(250 - nivel * 30 < 20){
                            sleep(20);
                        }else
                        if(250 - nivel * 30 > 10){
                            sleep(250 - nivel * 30);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    /**
     * Funcion: imprimirMatriz
     * Imprime la matriz en la consola para hacer pruebas
     */
    public void imprimirMatriz(){

        for(int i = 0; i < TAMANO_MATRIZ; i++){
            for(int e = 0; e < TAMANO_MATRIZ; e++){
                if(matriz[i][e].getTipoEntidad() == Entidad.TipoEntidad.VACIO){
                    System.out.print(" ⬜ ");
                }else if(matriz[i][e].getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_AZUL
                        || matriz[i][e].getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_ROJO){
                    System.out.print(" ⬛ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * ################################################################################################################
     * SETTERS AND GETTERS
     * ################################################################################################################
     */

    public int getVidas() {
        return vidas;
    }

    public int getNivel() {
        return nivel;
    }

    public Entidad[][] getMatriz() {
        return matriz;
    }

    public Entidad.TipoEntidad getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    public void setEntidadSeleccionada(Entidad.TipoEntidad entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    public Mono getDonkeyKongJr() {
        return donkeyKongJr;
    }

    public MonoController getMonoController() {
        return monoController;
    }

    public FrutaController getFrutaController() {
        return frutaController;
    }

    public String getIdGame(){
        return id;
    }

    public CreadorDeMapa getCreadorDeMapa() {
        return creadorDeMapa;
    }
}