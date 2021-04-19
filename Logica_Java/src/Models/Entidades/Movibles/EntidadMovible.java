package Models.Entidades.Movibles;

import Controller.GameManager;
import Models.Entidades.Entidad;
import Models.Entidades.Utils.PuntoMatriz;

public abstract class EntidadMovible extends Entidad {
    /**
     * Direccion hacia la que está apuntando el area
     */
    public enum Direccion{
        ARRIBA,
        ABAJO,
        DERECHA,
        IZQUIERDA,
        NINGUNA
    }
    protected Direccion direccion;

    // Es el limite al cual puede llegar una entidad sin chocar
    protected Integer LIMITE_DERECHA = 0;
    protected Integer LIMITE_IZQUIERDA = 0;
    protected Integer LIMITE_ARRIBA = 0;
    protected Integer LIMITE_ABAJO = 0;

    public EntidadMovible(String id, PuntoMatriz posicion, PuntoMatriz[] area, TipoEntidad tipoEntidad, Direccion direccion) {
        super(id, posicion, area, tipoEntidad);
        this.direccion = direccion;
    }

    /**
     * Mueve la entidad a una nueva posicion y actualiza su area
     * @param nuevaPosicion
     */
    public void moverConPosicion(PuntoMatriz nuevaPosicion){
        this.posicion = nuevaPosicion;
        actualizarArea();
    }

    /**
     * Mueve la entidad hacia una direccion y actualiza el area
     * @param direccion
     *//*
    public void moverConDireccion(Direccion direccion){

        if(direccion == Direccion.DERECHA && (this.posicion.getColumna()+LIMITE_DERECHA < GameManager.TAMANO_MATRIZ) ){
            this.direccion = direccion;
            moverConPosicion(new PuntoMatriz(this.posicion.getFila(), this.posicion.getColumna()+1));
        }
        if(direccion == Direccion.IZQUIERDA && (this.posicion.getColumna()-LIMITE_IZQUIERDA > 0) ){
            this.direccion = direccion;
            moverConPosicion(new PuntoMatriz(this.posicion.getFila(), this.posicion.getColumna()-1));
        }
        if(direccion == Direccion.ARRIBA && (this.posicion.getFila()-2 > 0) ){
            this.direccion = direccion;
            moverConPosicion(new PuntoMatriz(this.posicion.getFila()-LIMITE_ARRIBA, this.posicion.getColumna()));
        }
        if(direccion == Direccion.ABAJO && (this.posicion.getFila()+2 < GameManager.TAMANO_MATRIZ) ){
            this.direccion = direccion;
            moverConPosicion(new PuntoMatriz(this.posicion.getFila()+LIMITE_ABAJO, this.posicion.getColumna()));
        }
    }*/

    /**
     * Actualiza el area de la entidad dependiendo de la direccion hacia la que debe apuntar
     */
    public void actualizarArea(){

        if(direccion == Direccion.DERECHA){
            direccionAreaDerecha();
        }
        else if(direccion == Direccion.IZQUIERDA) {
            direccionAreaIzquierda();
        }
        else if(direccion == Direccion.ARRIBA) {
            direccionAreaArriba();
        }
        else if(direccion == Direccion.ABAJO) {
            direccionAreaAbajo();
        }
    }

    /**
     * Cada equivalente al area dependiendo de la direccion, se establece abstract ya que cada cuerpo tiene diferente
     * area y diferentes condiciones.
     *
     * Por ejemplo: la direccion arriba del jugador depende de si esta subido en una liana o en dos o en ninguna
     * Tambien los puntos de area que tiene un cocodrillo son distintos que los del mono
     */
    protected abstract void direccionAreaAbajo();

    protected abstract void direccionAreaArriba();

    protected abstract void direccionAreaIzquierda();

    protected abstract void direccionAreaDerecha();

    public Integer getLIMITE_DERECHA() {
        return LIMITE_DERECHA;
    }

    public void setLIMITE_DERECHA(Integer LIMITE_DERECHA) {
        this.LIMITE_DERECHA = LIMITE_DERECHA;
    }

    public Integer getLIMITE_IZQUIERDA() {
        return LIMITE_IZQUIERDA;
    }

    public void setLIMITE_IZQUIERDA(Integer LIMITE_IZQUIERDA) {
        this.LIMITE_IZQUIERDA = LIMITE_IZQUIERDA;
    }

    public Integer getLIMITE_ARRIBA() {
        return LIMITE_ARRIBA;
    }

    public void setLIMITE_ARRIBA(Integer LIMITE_ARRIBA) {
        this.LIMITE_ARRIBA = LIMITE_ARRIBA;
    }

    public Integer getLIMITE_ABAJO() {
        return LIMITE_ABAJO;
    }

    public void setLIMITE_ABAJO(Integer LIMITE_ABAJO) {
        this.LIMITE_ABAJO = LIMITE_ABAJO;
    }

    /**#################################################################################################
     * SETTERS AND GETTERS
     * #################################################################################################
     */

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
