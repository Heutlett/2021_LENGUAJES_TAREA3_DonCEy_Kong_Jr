package controller;

import models.entidades.Entidad;
import models.entidades.movibles.EntidadMovible;
import models.entidades.movibles.Fruta;
import models.entidades.movibles.Mono;
import models.entidades.utils.PuntoMatriz;

import java.util.ArrayList;

public class MonoController {

    private Mono donkeyKongJr;
    private Entidad[][] matriz;
    public static Integer TAMANO_MATRIZ = 100;
    private FrutaController frutaController;
    private String idFrutaBorrar;


    public MonoController(Mono donkeyKongJr, Entidad[][] matriz, FrutaController frutaController){
        this.donkeyKongJr = donkeyKongJr;
        this.matriz = matriz;
        this.frutaController = frutaController;
    }

    private boolean reglasMoverDerecha(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getColumna()+donkeyKongJr.getLIMITE_DERECHA() < GameManager.TAMANO_MATRIZ)){
            if(manejarColisiones(obtenerColisionAlMoverse(direccion))) {
                return true;
            }
        }
        return false;

    }
    private boolean reglasMoverIzquierda(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getColumna()-donkeyKongJr.getLIMITE_IZQUIERDA() > 0)){
            if(manejarColisiones(obtenerColisionAlMoverse(direccion))) {
                return true;
            }
        }
        return false;
    }


    private boolean reglasMoverArriba(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getFila()-3 > 0)){
            if(manejarColisiones(obtenerColisionAlMoverse(direccion))) {
                return true;
            }
        }
        return false;
    }
    private boolean reglasMoverAbajo(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getFila()+2 < GameManager.TAMANO_MATRIZ)){
            if(manejarColisiones(obtenerColisionAlMoverse(direccion))) {
                return true;
            }
        }
        return false;
    }

    private boolean manejarColisiones(ArrayList<Entidad.TipoEntidad> listaEntidad){
        if(listaEntidad.isEmpty()){
            donkeyKongJr.setOnLiana(false);
            return true;
        }
        for(int i = 0; i < listaEntidad.size(); i++){
            Entidad.TipoEntidad tipoEntidad = listaEntidad.get(i);
            /*
            if(tipoEntidad == null){
                donkeyKongJr.setOnLiana(false);
                return true;
            }*/
            switch (tipoEntidad){
                case COCODRILO_AZUL:
                case COCODRILO_ROJO:
                case AGUA:
                    /**
                     * AGREGAR CODIGO SI COLISIONA COCODRILOS
                     */
                    donkeyKongJr.setHaPerdido(true);
                    return false;
                case PLATAFORMA:
                    return false;
                case LIANA:
                    donkeyKongJr.setOnLiana(true);
                    donkeyKongJr.setJumping(false);
                    return true;
                case BANANO:
                case MELOCOTON:
                case MANZANA:
                    return true;
                case TROFEO:
                    donkeyKongJr.setHaGanado(true);
                    return false;

            }

        }



        return false;
    }

    /**
     * Devuelve true si hay colisiones con plataformas al moverse a la izquierda
     * @return
     */

    private ArrayList<Entidad.TipoEntidad> obtenerColisionAlMoverse(EntidadMovible.Direccion direccion){

        ArrayList<Entidad.TipoEntidad> listaTipoEntidades = new ArrayList<>();
        int limiteFila = 0;
        int limiteColumna = 0;

        switch (direccion) {
            case DERECHA:
                limiteFila = 0;
                limiteColumna = donkeyKongJr.getLIMITE_DERECHA();
                break;
            case IZQUIERDA:
                limiteFila = 0;
                limiteColumna = -1 * donkeyKongJr.getLIMITE_DERECHA();
                break;
            case ARRIBA:
                limiteFila = -1 * donkeyKongJr.getLIMITE_ARRIBA();
                limiteColumna = 0;
                break;
            case ABAJO:
                limiteFila = donkeyKongJr.getLIMITE_ABAJO();
                limiteColumna = 0;
                break;

        }

        for(int i = 0; i < donkeyKongJr.getArea().length; i++){
            PuntoMatriz p = donkeyKongJr.getArea()[i];
            if(p != null && p.getColumna()+limiteColumna >= 0 && p.getFila()+limiteFila >= 0
                    &&  p.getColumna()+limiteColumna < TAMANO_MATRIZ && p.getFila()+limiteFila < TAMANO_MATRIZ){
                if(matriz[p.getFila()+limiteFila][p.getColumna()+limiteColumna].getTipoEntidad() != Entidad.TipoEntidad.VACIO){

                    listaTipoEntidades.add(matriz[p.getFila()+limiteFila][p.getColumna()+limiteColumna].getTipoEntidad());
                    if(matriz[p.getFila()+limiteFila][p.getColumna()+limiteColumna].getId().contains("fruta")){
                        idFrutaBorrar = matriz[p.getFila()+limiteFila][p.getColumna()+limiteColumna].getId();
                        Fruta fruta = frutaController.buscarFrutaById(idFrutaBorrar);
                        if(fruta != null){
                            donkeyKongJr.setPuntuacion((int) (donkeyKongJr.getPuntuacion()+fruta.getPuntos()));
                            frutaController.borrarFruta(fruta);
                        }
                    }
                }

            }
        }
        return listaTipoEntidades;
    }
/*
    public ArrayList<Entidad.TipoEntidad> obtenerColisionesEstatico(){
        ArrayList<Entidad.TipoEntidad> listaTipoEntidades = new ArrayList<>();
        for(int i = 0; i < donkeyKongJr.getArea().length; i++){
            PuntoMatriz p = donkeyKongJr.getArea()[i];
            if(p != null && p.getColumna() >= 0 && p.getFila() >= 0
                    &&  p.getColumna() < TAMANO_MATRIZ && p.getFila() < TAMANO_MATRIZ
                    &&  p.getColumna() >= 0 && p.getFila() >= 0){
                if(matriz[p.getFila()][p.getColumna()] != null){

                    listaTipoEntidades.add(matriz[p.getFila()][p.getColumna()].getTipoEntidad());

                }

            }
        }
        return listaTipoEntidades;
    }*/

    public void moverMono(EntidadMovible.Direccion direccion){
        /**
         * Antes de mover el mono se debe verificar si chocará con una pared, un mounstrou o una liana
         */
        limpiarAreaAnteriorMono();

        if(direccion == EntidadMovible.Direccion.DERECHA && reglasMoverDerecha(direccion)){
            donkeyKongJr.setDireccion(direccion);
            donkeyKongJr.moverConPosicion(new PuntoMatriz(donkeyKongJr.getPosicion().getFila(), (donkeyKongJr.getPosicion().getColumna()+1)));
        }
        if(direccion == EntidadMovible.Direccion.IZQUIERDA && reglasMoverIzquierda(direccion)){
            donkeyKongJr.setDireccion(direccion);
            donkeyKongJr.moverConPosicion(new PuntoMatriz(donkeyKongJr.getPosicion().getFila(), donkeyKongJr.getPosicion().getColumna()-1));
        }
        if(direccion == EntidadMovible.Direccion.ARRIBA && reglasMoverArriba(direccion)){
            donkeyKongJr.setDireccion(direccion);
            donkeyKongJr.moverConPosicion(new PuntoMatriz(donkeyKongJr.getPosicion().getFila()-donkeyKongJr.getLIMITE_ARRIBA(), donkeyKongJr.getPosicion().getColumna()));
        }
        if(direccion == EntidadMovible.Direccion.ABAJO && reglasMoverAbajo(direccion) ){
            donkeyKongJr.setDireccion(direccion);
            donkeyKongJr.moverConPosicion(new PuntoMatriz(donkeyKongJr.getPosicion().getFila()+donkeyKongJr.getLIMITE_ABAJO(), donkeyKongJr.getPosicion().getColumna()));
        }
        actualizarMono();
    }

    public void actualizarMono(){
        //System.out.println("Actualizando mono: ");

        limpiarAreaAnteriorMono();
        for(int i = 0; i < donkeyKongJr.getArea().length; i++){
            //System.out.println(donkeyKongJr.getArea()[i].toString());
            if(verificarLimitesPosicionMatriz(donkeyKongJr.getArea()[i]) && donkeyKongJr.getArea()[i] != null){
                matriz[donkeyKongJr.getArea()[i].getFila()][donkeyKongJr.getArea()[i].getColumna()] = donkeyKongJr;
            }
        }
    }

    /**
     * Elimina de la matriz los puntos de la matriz donde estaba el area del mono para asignarlo a otra direccion
     */
    public void limpiarAreaAnteriorMono(){
        for(int i = 0; i < donkeyKongJr.getArea().length; i++){

            if(verificarLimitesPosicionMatriz(donkeyKongJr.getArea()[i]) && donkeyKongJr.getArea()[i] != null){
                matriz[donkeyKongJr.getArea()[i].getFila()][donkeyKongJr.getArea()[i].getColumna()] = Entidad.crearEntidadVacia();
            }

        }
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

    public boolean estaEnSuelo(){

        PuntoMatriz posicionMono = donkeyKongJr.getPosicion();

        if(posicionMono.getFila()+2 < TAMANO_MATRIZ
                && matriz[posicionMono.getFila()+2][posicionMono.getColumna()].getTipoEntidad() != Entidad.TipoEntidad.VACIO
                && matriz[posicionMono.getFila()+2][posicionMono.getColumna()].getTipoEntidad() == Entidad.TipoEntidad.PLATAFORMA ){

            return true;

        }
        return false;

    }

    public void saltar(EntidadMovible.Direccion direccion) {

        new HiloSalto(direccion).start();

    }

    public class HiloSalto extends Thread{

        private EntidadMovible.Direccion direccion;

        public HiloSalto(EntidadMovible.Direccion direccion){
            this.direccion = direccion;
        }

        @Override
        public void run() {

            int contador = 0;

            while(!donkeyKongJr.isHaPerdido() && donkeyKongJr.isJumping() && contador < 10 && !donkeyKongJr.isOnLiana()){
                if(direccion == EntidadMovible.Direccion.DERECHA){
                    moverMono(EntidadMovible.Direccion.DERECHA);
                }
                if(direccion == EntidadMovible.Direccion.IZQUIERDA){
                    moverMono(EntidadMovible.Direccion.IZQUIERDA);
                }

                moverMono(EntidadMovible.Direccion.ARRIBA);
                contador++;

                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            donkeyKongJr.setJumping(false);
        }

    }

}
