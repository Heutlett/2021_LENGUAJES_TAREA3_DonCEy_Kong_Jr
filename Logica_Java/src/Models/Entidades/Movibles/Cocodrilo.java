package Models.Entidades.Movibles;
import Models.Entidades.Utils.PuntoMatriz;



public class Cocodrilo extends EntidadMovible {
    public enum TipoCocodrilo {
        ROJO,
        AZUL
    }
    protected double velocidad;
    protected TipoCocodrilo tipoCocodrilo;

    public Cocodrilo(String id, PuntoMatriz posicion, PuntoMatriz[] area, double velocidad, TipoCocodrilo tipoCocodrilo) {
        super(id, posicion, area);
        this.velocidad = velocidad;
        this.tipoCocodrilo = tipoCocodrilo;
    }

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
