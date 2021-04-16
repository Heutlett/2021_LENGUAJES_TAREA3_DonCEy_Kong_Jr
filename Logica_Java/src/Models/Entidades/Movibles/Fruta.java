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

    public Fruta(String id, PuntoMatriz posicion, Direccion direccion, double puntos, TipoFruta tipoFruta) {
        super(id, posicion, new PuntoMatriz[4], direccion);
        this.puntos = puntos;
        this.tipoFruta = tipoFruta;
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
