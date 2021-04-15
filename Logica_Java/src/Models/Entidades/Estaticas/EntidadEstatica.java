package Models.Entidades.Estaticas;

import Models.Entidades.Entidad;
import Models.Entidades.Utils.PuntoMatriz;

public class EntidadEstatica extends Entidad {
    public enum TipoSuperficie {
        LIANA,
        PLATAFORMA,
        DONKEYKONG
    }
    private TipoSuperficie tipoSuperficie;

    public EntidadEstatica(String id, PuntoMatriz posicion, PuntoMatriz[] area, TipoSuperficie tipoSuperficie) {
        super(id, posicion, area);
        this.tipoSuperficie = tipoSuperficie;
    }

    public TipoSuperficie getTipoSuperficie() {
        return tipoSuperficie;
    }

    public void setTipoSuperficie(TipoSuperficie tipoSuperficie) {
        this.tipoSuperficie = tipoSuperficie;
    }
}
