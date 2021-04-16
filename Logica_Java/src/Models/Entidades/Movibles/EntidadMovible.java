package Models.Entidades.Movibles;

import Logica.GameManager;
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
        IZQUIERDA
    }
    protected Direccion direccion;

    // Es el limite al cual puede llegar una entidad sin chocar
    protected int LIMITE_DERECHA = 0;
    protected int LIMITE_IZQUIERDA = 0;
    protected int LIMITE_ARRIBA = 0;
    protected int LIMITE_ABAJO = 0;

    public EntidadMovible(String id, PuntoMatriz posicion, PuntoMatriz[] area, Direccion direccion) {
        super(id, posicion, area);
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
     */
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
    }

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
