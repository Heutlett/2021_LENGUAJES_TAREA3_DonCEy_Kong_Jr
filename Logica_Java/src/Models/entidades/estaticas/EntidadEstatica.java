package models.entidades.estaticas;

import models.entidades.Entidad;
import models.entidades.utils.PuntoMatriz;

/**
 * Tipo de entidad que no se mueve, es decir no tiene metodos para moverse ni actualizar su posicion, como las
 * plataformas, el trofeo, las lianas y el agua.
 */
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
