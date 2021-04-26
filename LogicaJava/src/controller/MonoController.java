package controller;

import models.entidades.Entidad;
import models.entidades.movibles.EntidadMovible;
import models.entidades.movibles.Fruta;
import models.entidades.movibles.Mono;
import models.entidades.utils.PuntoMatriz;
import java.util.ArrayList;

/**
 * Controlador del mono, en esta clase se manejan todas las funciones del mono, como las colisiones y el movimiento.
 */
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

    /**
     * Funcion: reglasMoverDerecha
     * Se verifica si es posible moverse hacia la derecha.
     * @param direccion direccion hacia la que se va mover.
     * @return retorna true si es posible moverse y false de lo contrario.
     */
    private boolean reglasMoverDerecha(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getColumna()+donkeyKongJr.getLIMITE_DERECHA() < GameManager.TAMANO_MATRIZ)){
            if(manejarColisiones(obtenerColisionAlMoverse(direccion))) {
                return true;
            }
        }
        return false;

    }

    /**
     * Funcion: reglasMoverIzquierda
     * Se verifica si es posible moverse hacia la izquierda.
     * @param direccion direccion hacia la que se va mover.
     * @return retorna true si es posible moverse y false de lo contrario.
     */
    private boolean reglasMoverIzquierda(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getColumna()-donkeyKongJr.getLIMITE_IZQUIERDA() > 0)){
            if(manejarColisiones(obtenerColisionAlMoverse(direccion))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Funcion: reglasMoverArriba
     * Se verifica si es posible moverse hacia la arriba.
     * @param direccion direccion hacia la que se va mover.
     * @return retorna true si es posible moverse y false de lo contrario.
     */
    private boolean reglasMoverArriba(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getFila()-3 > 0)){
            if(manejarColisiones(obtenerColisionAlMoverse(direccion))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Funcion: reglasMoverAbajo
     * Se verifica si es posible moverse hacia la abajo.
     * @param direccion direccion hacia la que se va mover.
     * @return retorna true si es posible moverse y false de lo contrario.
     */
    private boolean reglasMoverAbajo(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getFila()+2 < GameManager.TAMANO_MATRIZ)){
            if(manejarColisiones(obtenerColisionAlMoverse(direccion))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Funcion: manejarColisiones
     * Maneja las colisiones del mono con otra entidad, recibe una lista de entidades con las que esta colisionando
     * y decide que hacer.
     * @param listaEntidad lista de entidades con las que colisiono
     * @return true si se puede mover hacia esa entidad y false de lo contrario
     */
    private boolean manejarColisiones(ArrayList<Entidad.TipoEntidad> listaEntidad){
        if(listaEntidad.isEmpty()){
            donkeyKongJr.setOnLiana(false);
            return true;
        }
        for(int i = 0; i < listaEntidad.size(); i++){
            Entidad.TipoEntidad tipoEntidad = listaEntidad.get(i);

            switch (tipoEntidad){
                case COCODRILO_AZUL:
                case COCODRILO_ROJO:
                case AGUA:
                    /**
                     * AGREGAR CODIGO SI COLISIONA COCODRILOS
                     */
                    donkeyKongJr.setHaPerdido(true);
                    return false;
                case LIANA:
                    donkeyKongJr.setOnLiana(true);
                    donkeyKongJr.setJumping(false);
                    return true;
                case PLATAFORMA:
                    return false;
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
     * Funcion: obtenerColisionAlMoverse
     * Devuelve una lista con las entidades con las que esta colisionando el mono al moverse
     * @param direccion direccion hacia la que se movera el mono
     * @return una lista de entidades con las que colisionara al moverse
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

    /**
     * Funcion: moverMono
     * Mueve el mono hacia la direccion pasada por parametro
     * @param direccion direccion hacia la que se movera el mono
     */
    public void moverMono(EntidadMovible.Direccion direccion){
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

    /**
     * Funcion: actualizarMono
     * Actualiza la posicion del mono en la matriz principal del juego
     */
    public void actualizarMono(){

        limpiarAreaAnteriorMono();
        for(int i = 0; i < donkeyKongJr.getArea().length; i++){
            if(verificarLimitesPosicionMatriz(donkeyKongJr.getArea()[i]) && donkeyKongJr.getArea()[i] != null){
                matriz[donkeyKongJr.getArea()[i].getFila()][donkeyKongJr.getArea()[i].getColumna()] = donkeyKongJr;
            }
        }
    }

    /**
     * Funcion: limpiarAreaAnteriorMono
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
     * Funcion: verificarLimitesPosicionMatriz
     * Verifica si un punto esta fuera de la matriz principal del juego
     * @param posicion posicion que se verificara
     * @return true si la posicion esta dentro de los limites y false de lo contrario
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

    /**
     * Funcion: estaEnSuelo
     * Verifica si el mono esta en el suelo, es decir esta sobre una plataforma y no brincando
     * @return true si esta en el suelo y false de lo contrario
     */
    public boolean estaEnSuelo(){

        PuntoMatriz posicionMono = donkeyKongJr.getPosicion();

        if(posicionMono.getFila()+2 < TAMANO_MATRIZ
                && matriz[posicionMono.getFila()+2][posicionMono.getColumna()].getTipoEntidad() != Entidad.TipoEntidad.VACIO
                && matriz[posicionMono.getFila()+2][posicionMono.getColumna()].getTipoEntidad() == Entidad.TipoEntidad.PLATAFORMA ){

            return true;
        }
        return false;
    }

    /**
     * Funcion: saltar
     * Inicia el hilo encargado de hacer saltar al mono
     * @param direccion direccion hacia donde saltara
     */
    public void saltar(EntidadMovible.Direccion direccion) {

        new HiloSalto(direccion).start();

    }

    /**
     * ################################################################################################################
     * THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS THREADS HILOS
     * ################################################################################################################
     */

    /**
     * Hilo encargado de controlar el salto del mono
     */
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
