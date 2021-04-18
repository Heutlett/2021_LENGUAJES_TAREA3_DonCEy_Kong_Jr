package Controller;

import Models.Entidades.Entidad;
import Models.Entidades.Movibles.EntidadMovible;
import Models.Entidades.Movibles.Mono;
import Models.Entidades.Utils.PuntoMatriz;

public class MonoController {

    private Mono donkeyKongJr;
    private Entidad[][] matriz;
    public static Integer TAMANO_MATRIZ = 100;


    public MonoController(Mono donkeyKongJr, Entidad[][] matriz){
        this.donkeyKongJr = donkeyKongJr;
        this.matriz = matriz;
    }

    private boolean reglasMoverDerecha(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getColumna()+donkeyKongJr.getLIMITE_DERECHA() < GameManager.TAMANO_MATRIZ)){
            if(!verificarColisiones(direccion)) {
                return true;
            }
        }
        return false;

    }
    private boolean reglasMoverIzquierda(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getColumna()-donkeyKongJr.getLIMITE_IZQUIERDA() > 0)){
            if(!verificarColisiones(direccion)) {
                return true;
            }
        }
        return false;
    }


    private boolean reglasMoverArriba(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getFila()-3 > 0)){
            if(!verificarColisiones(direccion)) {
                return true;
            }
        }
        return false;
    }
    private boolean reglasMoverAbajo(EntidadMovible.Direccion direccion){

        if((donkeyKongJr.getPosicion().getFila()+2 < GameManager.TAMANO_MATRIZ)){
            if(!verificarColisiones(direccion)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve true si hay colisiones con plataformas al moverse a la izquierda
     * @return
     */

    private boolean verificarColisiones(EntidadMovible.Direccion direccion){

        int limiteFila = 0;
        int limiteColumna = 0;

        switch (direccion){
            case DERECHA:
                limiteFila = 0;
                limiteColumna = donkeyKongJr.getLIMITE_DERECHA();
                break;
            case IZQUIERDA:
                limiteFila = 0;
                limiteColumna = -1*donkeyKongJr.getLIMITE_DERECHA();
                break;
            case ARRIBA:
                limiteFila = -1*donkeyKongJr.getLIMITE_ARRIBA();
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
                if(matriz[p.getFila()+limiteFila][p.getColumna()+limiteColumna] != null &&
                        (matriz[p.getFila()+limiteFila][p.getColumna()+limiteColumna].getTipoEntidad() ==
                                Entidad.TipoEntidad.PLATAFORMA)){
                    System.out.println("HAY COLISION");
                    return true;
                }
            }
        }
        return false;
    }

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

    private void actualizarMono(){
        for(int i = 0; i < donkeyKongJr.getArea().length; i++){
            if(verificarLimitesPosicionMatriz(donkeyKongJr.getArea()[i])){
                matriz[donkeyKongJr.getArea()[i].getFila()][donkeyKongJr.getArea()[i].getColumna()] = donkeyKongJr;
            }
        }
    }

    /**
     * Elimina de la matriz los puntos de la matriz donde estaba el area del mono para asignarlo a otra direccion
     */
    private void limpiarAreaAnteriorMono(){
        for(int i = 0; i < donkeyKongJr.getArea().length; i++){

            if(verificarLimitesPosicionMatriz(donkeyKongJr.getArea()[i])){
                System.out.println(donkeyKongJr.getArea()[i].toString());
                matriz[donkeyKongJr.getArea()[i].getFila()][donkeyKongJr.getArea()[i].getColumna()] = null;
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

        if(matriz[posicionMono.getFila()+1][posicionMono.getColumna()] != null
                && matriz[posicionMono.getFila()+1][posicionMono.getColumna()].getTipoEntidad() == Entidad.TipoEntidad.PLATAFORMA ){

            return true;

        }
        return false;

    }

    public void saltar() {

        if(donkeyKongJr.isJumping()){

        }
    }
}
