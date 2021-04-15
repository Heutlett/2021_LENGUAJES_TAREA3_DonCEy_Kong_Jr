package Models.Entidades.Movibles;

import Models.Entidades.Utils.PuntoMatriz;

public class Fruta extends EntidadMovible{

    public enum TipoFruta{
        BANANO,
        MANZANA,
        LIMON
    }
    private double puntos;
    private TipoFruta tipoFruta;

    public Fruta(String id, PuntoMatriz posicion, PuntoMatriz[] area, Direccion direccion, double puntos, TipoFruta tipoFruta) {
        super(id, posicion, area, direccion);
        this.puntos = puntos;
        this.tipoFruta = tipoFruta;
    }

    @Override
    public void actualizarArea() {

    }

    /**#################################################################################################
     * SETTERS AND GETTERS
     * #################################################################################################
     */

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public TipoFruta getTipoFruta() {
        return tipoFruta;
    }

    public void setTipoFruta(TipoFruta tipoFruta) {
        this.tipoFruta = tipoFruta;
    }
}
