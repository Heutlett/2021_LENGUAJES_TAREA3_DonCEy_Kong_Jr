package Models.Entidades.Estaticas;

import Models.Entidades.Entidad;
import Models.Entidades.Utils.PuntoMatriz;

public class EntidadEstatica extends Entidad {

    public EntidadEstatica(String id, PuntoMatriz posicion, PuntoMatriz[] area, TipoEntidad tipoEntidad) {
        super(id, posicion, area, tipoEntidad);
    }
}
