package Controller;

import Models.Entidades.Entidad;
import Models.Entidades.Estaticas.EntidadEstatica;
import Models.Entidades.Movibles.Cocodrilo;
import Models.Entidades.Movibles.EntidadMovible;
import Models.Entidades.Movibles.Fruta;
import Models.Entidades.Movibles.Mono;
import Models.Entidades.Utils.PuntoMatriz;

import java.util.ArrayList;

public class GameManager extends Thread{

    private Entidad[][] matriz;

    private Mono donkeyKongJr;
    private EntidadEstatica donkeyKong;
    private ArrayList<Cocodrilo> cocodrilos;
    private ArrayList<Fruta> frutas;
    private EntidadEstatica[] lianas;
    private EntidadEstatica[] plataformas;
    private EntidadEstatica[] agua;

    private MonoController monoController;
    private CocodriloController cocodriloController;
    private FrutaController frutaController;

    private String id;
    static int count = 0;

    private Entidad.TipoEntidad entidadSeleccionada;
    public static Integer TAMANO_MATRIZ = 100;
    public static PuntoMatriz POSICION_INICIAL = new PuntoMatriz(25,1);
    private int contadorCaida;
    private boolean haPerdido;
    private int nivel;
    private int vidas;

    public GameManager()
    {
        id = "gameManager" + count;
        System.out.println("Se ha creado un nuevo juego, asignado a: gamenager" + count);
        count++;
        setCondicionesIniciales();
    }
    public void setCondicionesIniciales(){
        donkeyKongJr = new Mono("dkjr", POSICION_INICIAL, EntidadMovible.Direccion.DERECHA, Entidad.TipoEntidad.MONO);
        donkeyKong = new EntidadEstatica("dk", null, null, Entidad.TipoEntidad.MONO);
        cocodrilos =  new ArrayList<>();
        frutas = new ArrayList<>();
        lianas = new EntidadEstatica[10];
        plataformas = new EntidadEstatica[6];
        matriz = new Entidad[TAMANO_MATRIZ][TAMANO_MATRIZ];
        frutaController = new FrutaController(matriz, frutas);
        monoController = new MonoController(donkeyKongJr, matriz, frutaController);
        cocodriloController = new CocodriloController(matriz, cocodrilos, lianas, monoController);

        contadorCaida = 0;
        haPerdido = false;
        nivel = 1;
        vidas = 1;
        new HiloCocodrilos().start();
        crearPlataformaPrueba();
        crearPlataformas();
        crearLianaPrueba();
        crearLianas();
        //actualizarMatriz();
    }

    public void actualizarMatriz(){
        //actualizarMono();
    }


    public void crearPlataformas(){
        for(int i = 0; i < plataformas.length; i++){
            if(plataformas[i] != null){
                for(int e = 0; e < plataformas[i].getArea().length; e++){
                    matriz[plataformas[i].getArea()[e].getFila()][plataformas[i].getArea()[e].getColumna()] = plataformas[i];
                }
            }
        }
    }

    public void crearLianas(){
        for(int i = 0; i < lianas.length; i++){
            if(lianas[i] != null){
                for(int e = 0; e < lianas[i].getArea().length; e++){
                    matriz[lianas[i].getArea()[e].getFila()][lianas[i].getArea()[e].getColumna()] = lianas[i];
                }
            }
        }
    }

    public void crearCocodrilo(String idLiana){

        if(entidadSeleccionada != null && entidadSeleccionada == Entidad.TipoEntidad.COCODRILO_AZUL
                || entidadSeleccionada == Entidad.TipoEntidad.COCODRILO_ROJO ){
            Cocodrilo cocodrilo = new Cocodrilo(null, null, null, null, null, 0,
                    null);
            cocodrilo.setId("cocodrilo" + cocodrilos.size());
            EntidadEstatica liana = buscarLianaById(idLiana);
            if(liana != null){
                cocodrilo.setPosicion(liana.getPosicion());
            }
            cocodrilo.direccionAreaAbajo();
            //La area se define en la clase COCODRILO
            cocodrilo.setTipoEntidad(entidadSeleccionada);
            cocodrilo.setDireccion(EntidadMovible.Direccion.ABAJO);
            cocodrilo.setVelocidad(nivel);
            cocodrilo.setIdLiana(idLiana);
            cocodrilos.add(cocodrilo);
        }
    }

    public void crearFruta(PuntoMatriz posicion, int puntos) {

        if (entidadSeleccionada != null && entidadSeleccionada != Entidad.TipoEntidad.COCODRILO_AZUL
                && entidadSeleccionada != Entidad.TipoEntidad.COCODRILO_ROJO) {
            Fruta fruta = new Fruta(posicion, null, entidadSeleccionada, null, puntos);
            frutas.add(fruta);
            frutaController.actualizarFruta(fruta);
        }
    }

    private EntidadEstatica buscarLianaById(String id){
        for(int i = 0; i < lianas.length; i++){
            if(lianas[i].getId().equals(id)){
                return lianas[i];
            }
        }
        return null;
    }

    public void imprimirMatriz(){

        for(int i = 0; i < TAMANO_MATRIZ; i++){
            for(int e = 0; e < TAMANO_MATRIZ; e++){
                if(matriz[i][e] == null){
                    System.out.print(" ⬜ ");
                }else{
                    System.out.print(" ⬛ ");
                }
            }
            System.out.println();
        }
        System.out.println();
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

    public void setId(String id) {
        this.id = id;
    }

    public Mono getDonkeyKongJr() {
        return donkeyKongJr;
    }

    public void setDonkeyKongJr(Mono donkeyKongJr) {
        this.donkeyKongJr = donkeyKongJr;
    }

    public EntidadEstatica getDonkeyKong() {
        return donkeyKong;
    }

    public void setDonkeyKong(EntidadEstatica donkeyKong) {
        this.donkeyKong = donkeyKong;
    }

    public ArrayList<Cocodrilo> getCocodrilos() {
        return cocodrilos;
    }

    public void setCocodrilos(ArrayList<Cocodrilo> cocodrilos) {
        this.cocodrilos = cocodrilos;
    }

    public ArrayList<Fruta> getFrutas() {
        return frutas;
    }

    public void setFrutas(ArrayList<Fruta> frutas) {
        this.frutas = frutas;
    }

    public EntidadEstatica[] getLianas() {
        return lianas;
    }

    public void setLianas(EntidadEstatica[] lianas) {
        this.lianas = lianas;
    }

    public EntidadEstatica[] getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(EntidadEstatica[] plataformas) {
        this.plataformas = plataformas;
    }

    public void setMatriz(Entidad[][] matriz) {
        this.matriz = matriz;
    }

    public MonoController getMonoController() {
        return monoController;
    }

    public void setMonoController(MonoController monoController) {
        this.monoController = monoController;
    }

    public int getContadorCaida() {
        return contadorCaida;
    }

    public void setContadorCaida(int contadorCaida) {
        this.contadorCaida = contadorCaida;
    }

    public CocodriloController getCocodriloController() {
        return cocodriloController;
    }

    public void setCocodriloController(CocodriloController cocodriloController) {
        this.cocodriloController = cocodriloController;
    }

    public FrutaController getFrutaController() {
        return frutaController;
    }

    public void setFrutaController(FrutaController frutaController) {
        this.frutaController = frutaController;
    }

    public boolean isHaPerdido() {
        return haPerdido;
    }

    public void setHaPerdido(boolean haPerdido) {
        this.haPerdido = haPerdido;
    }

    public String getIdGame(){
        return id;
    }

    private void crearPlataformaPrueba(){

        EntidadEstatica plataforma = new EntidadEstatica(null, null, null, null);
        plataforma.setId("prueba");
        plataforma.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma.setArea(new PuntoMatriz[50]);
        for(int i = 0; i < 50; i++){
            plataforma.getArea()[i] = new PuntoMatriz(95, i);
        }

        plataformas[0] = plataforma;

        EntidadEstatica plataforma2 = new EntidadEstatica(null, null, null, null);
        plataforma2.setId("prueba");
        plataforma2.setPosicion(new PuntoMatriz(0,0));
        plataforma2.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma2.setArea(new PuntoMatriz[50]);
        for(int i = 0; i < 50; i++){
            plataforma2.getArea()[i] = new PuntoMatriz(30, i);
        }

        plataformas[1] = plataforma2;

    }

    private void crearLianaPrueba(){

        EntidadEstatica liana = new EntidadEstatica(null, null, null, null);
        liana.setId("liana1");
        liana.setPosicion(new PuntoMatriz(0,23));
        liana.setUltimaPosicion(new PuntoMatriz(20,23));
        liana.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana.setArea(new PuntoMatriz[20]);
        for(int i = 0; i < 20; i++){
            liana.getArea()[i] = new PuntoMatriz(i, 23);
        }

        lianas[0] = liana;

        EntidadEstatica liana2 = new EntidadEstatica(null, null, null, null);
        liana2.setId("liana2");
        liana2.setPosicion(new PuntoMatriz(0,30));
        liana2.setUltimaPosicion(new PuntoMatriz(20,30));
        liana2.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana2.setArea(new PuntoMatriz[20]);
        for(int i = 0; i < 20; i++){
            liana2.getArea()[i] = new PuntoMatriz(i, 30);
        }

        lianas[1] = liana2;

    }

    public void run() {
        while(true){

            if(!donkeyKongJr.isJumping() && !donkeyKongJr.isOnLiana() && !getMonoController().estaEnSuelo()){
                //donkeyKongJr.setFalling(true);
                contadorCaida++;
                monoController.moverMono(EntidadMovible.Direccion.ABAJO);
            }else{
                if(contadorCaida >= 15){
                    haPerdido = true;
                }
                contadorCaida = 0;
            }
            crearLianas();
            crearPlataformas();
            //actualizarMatriz();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class HiloCocodrilos extends Thread {

        @Override
        public void run() {
            while (!haPerdido){

                cocodriloController.moverCocodrilos();

                try {
                    sleep(150-nivel*30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
