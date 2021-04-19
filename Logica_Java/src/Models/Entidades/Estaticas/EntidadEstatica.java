package Models.Entidades.Estaticas;

import Models.Entidades.Entidad;
import Models.Entidades.Utils.PuntoMatriz;

public class EntidadEstatica extends Entidad {

    protected PuntoMatriz ultimaPosicion;

    public EntidadEstatica(String id, PuntoMatriz posicion, PuntoMatriz[] area, TipoEntidad tipoEntidad) {
        super(id, posicion, area, tipoEntidad);
    }

    public PuntoMatriz getUltimaPosicion() {
        return ultimaPosicion;
    }

    public void setUltimaPosicion(PuntoMatriz ultimaPosicion) {
        this.ultimaPosicion = ultimaPosicion;
    }
}
