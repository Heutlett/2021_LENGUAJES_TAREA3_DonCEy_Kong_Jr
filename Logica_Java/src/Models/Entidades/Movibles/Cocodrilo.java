package Models.Entidades.Movibles;
import Models.Entidades.Utils.PuntoMatriz;



public class Cocodrilo extends EntidadMovible {


    public enum TipoCocodrilo {
        ROJO,
        AZUL
    }
    protected double velocidad;
    protected TipoCocodrilo tipoCocodrilo;

    public Cocodrilo(String id, PuntoMatriz posicion, Direccion direccion, double velocidad) {
        super(id, posicion, new PuntoMatriz[4], direccion);
        this.velocidad = velocidad;
        /**
         * sE DEBEN ESTABLECER ESTOS LIMITES
         */
        LIMITE_ARRIBA = 0;
        LIMITE_ABAJO = 0;
        LIMITE_IZQUIERDA = 0;
        LIMITE_DERECHA = 0;
    }

    @Override
    protected void direccionAreaAbajo() {

    }

    @Override
    protected void direccionAreaArriba() {

    }

    @Override
    protected void direccionAreaIzquierda() {

    }

    @Override
    protected void direccionAreaDerecha() {

    }

    /**#################################################################################################
     * SETTERS AND GETTERS
     * #################################################################################################
     */

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public TipoCocodrilo getTipo() {
        return tipoCocodrilo;
    }

    public void setTipo(TipoCocodrilo tipoCocodrilo) {
        this.tipoCocodrilo = tipoCocodrilo;
    }

}
