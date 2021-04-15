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

    public Fruta(String id, PuntoMatriz posicion, PuntoMatriz[] area, double puntos, TipoFruta tipoFruta) {
        super(id, posicion, area);
        this.puntos = puntos;
        this.tipoFruta = tipoFruta;
    }

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
