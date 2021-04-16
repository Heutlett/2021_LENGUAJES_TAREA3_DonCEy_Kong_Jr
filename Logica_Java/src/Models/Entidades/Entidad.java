package Models.Entidades;

import Models.Entidades.Utils.PuntoMatriz;

public class Entidad {

    protected String id;
    protected PuntoMatriz posicion; // posicion actual en la matriz
    protected PuntoMatriz[] area;  // puntos en la matriz que representan el espacio de la entidad

    public Entidad(String id, PuntoMatriz posicion, PuntoMatriz[] area) {
        this.id = id;
        this.posicion = posicion;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PuntoMatriz getPosicion() {
        return posicion;
    }

    public void setPosicion(PuntoMatriz posicion) {
        this.posicion = posicion;
    }

    public PuntoMatriz[] getArea() {
        return area;
    }

    public void setArea(PuntoMatriz[] area) {
        this.area = area;
    }
}
