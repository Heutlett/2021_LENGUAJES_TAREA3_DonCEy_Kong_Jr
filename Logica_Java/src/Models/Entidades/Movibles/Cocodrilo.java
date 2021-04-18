package Models.Entidades.Movibles;
import Models.Entidades.Utils.PuntoMatriz;



public class Cocodrilo extends EntidadMovible {


    protected double velocidad;

    public Cocodrilo(String id, PuntoMatriz posicion, PuntoMatriz[] area, TipoEntidad tipoEntidad, Direccion direccion, double velocidad) {
        super(id, posicion, area, tipoEntidad, direccion);
        this.velocidad = velocidad;
    }

    public Cocodrilo(String id, PuntoMatriz posicion, PuntoMatriz[] area, TipoEntidad tipoEntidad, Direccion direccion) {
        super(id, posicion, area, tipoEntidad, direccion);

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


}
