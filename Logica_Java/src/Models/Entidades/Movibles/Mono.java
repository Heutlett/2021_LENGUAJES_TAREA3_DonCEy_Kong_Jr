package Models.Entidades.Movibles;

import Models.Entidades.Utils.PuntoMatriz;

public class Mono extends EntidadMovible{

    public Mono(String id, PuntoMatriz posicion, PuntoMatriz[] area, Direccion direccion) {
        super(id, posicion, area, direccion);
    }
    @Override
    public void actualizarArea() {

    }
}
