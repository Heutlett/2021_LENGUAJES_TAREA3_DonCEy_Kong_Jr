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

    private String id;
    static int count = 0;
    private Mono donkeyKongJr;
    private EntidadEstatica donkeyKong;
    private ArrayList<Cocodrilo> cocodrilos;
    private ArrayList<Fruta> frutas;
    private EntidadEstatica[] lianas;
    private EntidadEstatica[] plataformas;
    private MonoController monoController;
    private Entidad[][] matriz;
    public static Integer TAMANO_MATRIZ = 100;
    public static PuntoMatriz POSICION_INICIAL = new PuntoMatriz(10,1);

    public GameManager()
    {
        id = "gameManager" + count;
        System.out.println("Se ha creado un nuevo juego, asignado a: gamenager" + count);
        count++;
        setCondicionesIniciales();
    }
    private void setCondicionesIniciales(){
        donkeyKongJr = new Mono("dkjr", POSICION_INICIAL, EntidadMovible.Direccion.DERECHA, Entidad.TipoEntidad.MONO);
        donkeyKong = new EntidadEstatica("dk", null, null, Entidad.TipoEntidad.MONO);
        cocodrilos =  new ArrayList<>();
        frutas = new ArrayList<>();
        lianas = new EntidadEstatica[10];
        plataformas = new EntidadEstatica[6];
        matriz = new Entidad[TAMANO_MATRIZ][TAMANO_MATRIZ];
        monoController = new MonoController(donkeyKongJr, matriz);
        crearPlataformaPrueba();
        crearPlataformas();
        actualizarMatriz();
    }

    public void actualizarMatriz(){
        //actualizarMono();
    }





    /**
     * Verifica si un punto esta fuera de la matriz
     * @param posicion
     * @return
     */
    private boolean verificarLimitesPosicionMatriz(PuntoMatriz posicion){

        if(posicion != null
                && posicion.getFila() < TAMANO_MATRIZ
                && posicion.getColumna() < TAMANO_MATRIZ
                && posicion.getFila()  >= 0
                && posicion.getColumna() >= 0){
            return true;
        }
        return false;
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

    private void crearPlataformaPrueba(){

        EntidadEstatica plataforma = new EntidadEstatica(null, null, null, null);
        plataforma.setId("prueba");
        plataforma.setPosicion(new PuntoMatriz(0,0));
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

    public void run() {
        while(true){
            monoController.moverMono(EntidadMovible.Direccion.ABAJO);
            actualizarMatriz();


            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
