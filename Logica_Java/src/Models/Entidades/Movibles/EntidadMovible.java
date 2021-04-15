package Models.Entidades.Movibles;

import Models.Entidades.Entidad;
import Models.Entidades.Utils.PuntoMatriz;

public abstract class EntidadMovible extends Entidad {

    public enum Direccion{
        ARRIBA,
        ABAJO,
        DERECHA,
        IZQUIERDA
    }

    protected Direccion direccion;

    public EntidadMovible(String id, PuntoMatriz posicion, PuntoMatriz[] area, Direccion direccion) {
        super(id, posicion, area);
        this.direccion = direccion;
    }

    public void mover(PuntoMatriz nuevaPosicion){
        actualizarDireccion(nuevaPosicion);
        this.posicion = nuevaPosicion;
        actualizarArea();
    }

    private void actualizarDireccion(PuntoMatriz nuevaPosicion){

        //Izquierda o derecha
        if(this.posicion.getFila() == nuevaPosicion.getFila()){
            // Derecha
            if(this.posicion.getColumna() < nuevaPosicion.getColumna()){
                this.direccion = Direccion.DERECHA;
            }else{ // Izquierda
                this.direccion = Direccion.IZQUIERDA;
            }
        }else{ //Arriba o abajo
            // Abajo
            if(this.posicion.getFila() < nuevaPosicion.getFila()){
                this.direccion = Direccion.ABAJO;
            }else{ // Arriba
                this.direccion = Direccion.ARRIBA;
            }
        }
    }

    public abstract void actualizarArea();

    /**#################################################################################################
     * SETTERS AND GETTERS
     * #################################################################################################
     */

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
