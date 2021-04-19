package Models.Entidades.Movibles;

import Models.Entidades.Utils.PuntoMatriz;

public class Fruta extends EntidadMovible{

    private double puntos;
    static int count = 0;
    private int TAMANO_AREA = 30;


    public Fruta(PuntoMatriz posicion, PuntoMatriz[] area, TipoEntidad tipoEntidad, Direccion direccion, double puntos) {
        super("", posicion, area, tipoEntidad, direccion);
        if(tipoEntidad == TipoEntidad.BANANO){
            id = "fruta_banano" + count;
        }
        if(tipoEntidad == TipoEntidad.MANZANA){
            id = "fruta_banano" + count;
        }
        if(tipoEntidad == TipoEntidad.MELOCOTON){
            id = "fruta_banano" + count;
        }

        this.puntos = puntos;
        this.area = new PuntoMatriz[30];
        actualizarArea();
        count++;
    }


    public void actualizarArea(){
        //Fila 0
        this.area[0] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()-2);
        this.area[1] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()-1);
        this.area[2] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna());
        this.area[3] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()+1);
        this.area[4] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()+2);
        //Fila 1
        this.area[5] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()-2);
        this.area[6] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()-1);
        this.area[7] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna());
        this.area[8] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()+1);
        this.area[9] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()+2);
        //Fila 2
        this.area[10] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()-2);
        this.area[11] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()-1);
        this.area[12] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna());
        this.area[13] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()+1);
        this.area[14] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()+2);
        //Fila 3
        this.area[15] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()-2);
        this.area[16] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()-1);
        this.area[17] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna());
        this.area[18] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()+1);
        this.area[19] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()+2);
        //Fila 4
        this.area[20] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna()-2);
        this.area[21] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna()-1);
        this.area[22] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna());
        this.area[23] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna()+1);
        this.area[24] = new PuntoMatriz(this.posicion.getFila()+2,this.posicion.getColumna()+2);
        //Fila 5
        this.area[25] = new PuntoMatriz(this.posicion.getFila()+3,this.posicion.getColumna()-2);
        this.area[26] = new PuntoMatriz(this.posicion.getFila()+3,this.posicion.getColumna()-1);
        this.area[27] = new PuntoMatriz(this.posicion.getFila()+3,this.posicion.getColumna());
        this.area[28] = new PuntoMatriz(this.posicion.getFila()+3,this.posicion.getColumna()+1);
        this.area[29] = new PuntoMatriz(this.posicion.getFila()+3,this.posicion.getColumna()+2);
    }


    @Override
    protected void direccionAreaAbajo() {

    }

    @Override
    protected void direccionAreaArriba() {

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

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

}
