package models.entidades.movibles;

import models.entidades.Entidad;
import models.entidades.utils.PuntoMatriz;

/**
 * Clase para las entidades que se pueden mover como el mono, los cocodrilos y las frutas.
 */
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
     * Funcion: moverConPosicion
     * Mueve la entidad a una nueva posicion y actualiza su area
     * @param nuevaPosicion posicion hacia donde se movera la entidad
     */
    public void moverConPosicion(PuntoMatriz nuevaPosicion){
        this.posicion = nuevaPosicion;
        actualizarArea();
    }

    /**
     * Funcion: actualizarArea
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

    public Integer getLIMITE_DERECHA() {
        return LIMITE_DERECHA;
    }

    public Integer getLIMITE_IZQUIERDA() {
        return LIMITE_IZQUIERDA;
    }

    public Integer getLIMITE_ARRIBA() {
        return LIMITE_ARRIBA;
    }

    public Integer getLIMITE_ABAJO() {
        return LIMITE_ABAJO;
    }

}
