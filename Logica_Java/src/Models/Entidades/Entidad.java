package Models.Entidades;

import Models.Entidades.Utils.PuntoMatriz;

public class Entidad {

    public enum TipoEntidad{
        MONO,
        PLATAFORMA,
        LIANA,
        COCODRILO_ROJO,
        COCODRILO_AZUL,
        FRUTA,
        AGUA
    }
    protected TipoEntidad tipoEntidad;
    protected String id;
    protected PuntoMatriz posicion; // posicion actual en la matriz
    protected PuntoMatriz[] area;  // puntos en la matriz que representan el espacio de la entidad

    public Entidad(String id, PuntoMatriz posicion, PuntoMatriz[] area, TipoEntidad tipoEntidad) {
        this.id = id;
        this.posicion = posicion;
        this.area = area;
        this.tipoEntidad = tipoEntidad;
    }

    public TipoEntidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(TipoEntidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
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