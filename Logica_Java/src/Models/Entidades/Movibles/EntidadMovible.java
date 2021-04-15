package Models.Entidades.Movibles;

import Models.Entidades.Entidad;
import Models.Entidades.Utils.PuntoMatriz;

public class EntidadMovible extends Entidad {

    public EntidadMovible(String id, PuntoMatriz posicion, PuntoMatriz[] area) {
        super(id, posicion, area);
    }

    public void mover(PuntoMatriz nuevaPosicion){

        this.posicion = nuevaPosicion;

    }

}
