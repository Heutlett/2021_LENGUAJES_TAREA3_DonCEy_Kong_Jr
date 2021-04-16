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
    }

    @Override
    public void mover(PuntoMatriz nuevaPosicion) {

    }

    @Override
    void actualizarDireccion(PuntoMatriz nuevaPosicion) {
        //Izquierda o derecha
        if(this.posicion.getFila() == nuevaPosicion.getFila()){
            // Derecha
            if(this.posicion.getColumna() < nuevaPosicion.getColumna()){
                this.direccion = Direccion.DERECHA;
            }else{ // Izquierda
                this.direccion = Direccion.IZQUIERDA;
            }
        }else{ //Arriba o abajo
            // Abajo
            if(this.posicion.getFila() < nuevaPosicion.getFila()){
                this.direccion = Direccion.ABAJO;
            }else{ // Arriba
                this.direccion = Direccion.ARRIBA;
            }
        }
    }

    @Override
    public void actualizarArea() {

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
