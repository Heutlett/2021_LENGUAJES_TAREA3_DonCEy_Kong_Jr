package models.entidades.movibles;
import models.entidades.utils.PuntoMatriz;

import java.util.Arrays;


public class Cocodrilo extends EntidadMovible {

    protected double velocidad;
    private String idLiana;
    public static Integer TAMANO_AREA = 32;

    public Cocodrilo(String id, PuntoMatriz posicion, PuntoMatriz[] area, TipoEntidad tipoEntidad, Direccion direccion, double velocidad, String idLiana) {
        super(id, posicion, area, tipoEntidad, direccion);
        this.velocidad = velocidad;
        this.idLiana = idLiana;
    }

    private void actualizarDireccionCuerpo(){



        //Fila 0
        this.area[0] = new PuntoMatriz(this.posicion.getFila()-4,this.posicion.getColumna()-1);
        //Fila 1
        this.area[1] = new PuntoMatriz(this.posicion.getFila()-3,this.posicion.getColumna()-1);
        this.area[2] = new PuntoMatriz(this.posicion.getFila()-3,this.posicion.getColumna());
        this.area[3] = new PuntoMatriz(this.posicion.getFila()-3,this.posicion.getColumna()+1);
        //Fila 2
        this.area[4] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna());
        //Fila 3
        this.area[5] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna());
        this.area[6] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()-1);
        this.area[7] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()-2);
        //Fila 4
        this.area[8] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()-1);
        this.area[9] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna());
        this.area[10] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()+1);
        //Fila 5
        this.area[11] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()-1);
        this.area[12] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna());
        //Fila 6
        this.area[13] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna()-2);
        this.area[14] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna()-1);
        this.area[15] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna());
        //Fila 7
        this.area[16] = new PuntoMatriz(this.posicion.getFila()+3,this.posicion.getColumna());
    }

    private void actualizarDireccionArriba(){
        //Fila 1
        this.area[23] = new PuntoMatriz(this.posicion.getFila()-3,this.posicion.getColumna()-2);
        //Fila 2
        this.area[24] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()-2);
        this.area[25] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()-1);
        this.area[26] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()+1);
        //Fila 4
        this.area[27] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()-1);
        //Fila 7
        this.area[28] = new PuntoMatriz(this.posicion.getFila()+3,this.posicion.getColumna()-2);
        this.area[29] = new PuntoMatriz(this.posicion.getFila()+3,this.posicion.getColumna()-1);
    }

    private void actualizarDireccionAbajo(){
        //Fila 0
        this.area[17] = new PuntoMatriz(this.posicion.getFila()-4,this.posicion.getColumna());
        this.area[18] = new PuntoMatriz(this.posicion.getFila()-4,this.posicion.getColumna()+1);
        //Fila 3
        this.area[19] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()+1);
        //Fila 5
        this.area[20] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()-2);
        this.area[21] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()+1);
        //Fila 6
        this.area[22] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna()+1);
    }

    @Override
    public void direccionAreaAbajo() {
        this.area = new PuntoMatriz[TAMANO_AREA];
        actualizarDireccionCuerpo();
        actualizarDireccionAbajo();
    }

    @Override
    protected void direccionAreaArriba() {
        this.area = new PuntoMatriz[TAMANO_AREA];
        actualizarDireccionCuerpo();
        actualizarDireccionArriba();
    }

    @Override
    protected void direccionAreaIzquierda() {
    }

    @Override
    protected void direccionAreaDerecha() {
    }

    /**#################################################################################################
     * SETTERS AND GETTERS
     * #################################################################################################
     */

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public String getIdLiana() {
        return idLiana;
    }

    public void setIdLiana(String idLiana) {
        this.idLiana = idLiana;
    }

    public String toStringCreado(){
        return "Cocodrilo{" +
                "tipoEntidad=" + tipoEntidad +
                ", id='" + id + '\'' +
                ", idLiana='" + idLiana + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Cocodrilo{" +
                "tipoEntidad=" + tipoEntidad +
                ", id='" + id + '\'' +
                ", posicion=" + posicion +
                ", area=" + Arrays.toString(area) +
                ", idLiana='" + idLiana + '\'' +
                '}';
    }
}
