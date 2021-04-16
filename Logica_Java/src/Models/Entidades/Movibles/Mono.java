package Models.Entidades.Movibles;

import Models.Entidades.Utils.PuntoMatriz;



public class Mono extends EntidadMovible{

    private boolean isOnLiana;
    private boolean isOnTwoLianas;
    public static int TAMANO_AREA = 16;

    public Mono(String id, PuntoMatriz posicion, Direccion direccion) {
        super(id, posicion, new PuntoMatriz[TAMANO_AREA], direccion);
        this.isOnLiana = false;
        this.isOnTwoLianas = false;
    }

    public void mover(Direccion direccion){

        if(direccion == Direccion.DERECHA){
            mover(new PuntoMatriz(this.posicion.getFila(), this.posicion.getColumna()+1));
        }
        if(direccion == Direccion.IZQUIERDA){
            mover(new PuntoMatriz(this.posicion.getFila(), this.posicion.getColumna()-1));
        }
        if(direccion == Direccion.ARRIBA){
            mover(new PuntoMatriz(this.posicion.getFila()-1, this.posicion.getColumna()));
        }
        if(direccion == Direccion.ABAJO){
            mover(new PuntoMatriz(this.posicion.getFila()+1, this.posicion.getColumna()));
        }

    }

    @Override
    void actualizarDireccion(PuntoMatriz nuevaPosicion) {
        //Izquierda o derecha
        if(this.posicion.getFila() == nuevaPosicion.getFila()){
            // Derecha
            if(this.posicion.getColumna() < nuevaPosicion.getColumna()){
                this.direccion = Direccion.DERECHA;
            }else{ // Izquierda
                this.direccion = Direccion.IZQUIERDA;
            }
        }
    }

    @Override
    public void actualizarArea() {

        // Centro del cuerpo
        this.area[5] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna());
        this.area[6] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()+1);
        this.area[9] = this.posicion;
        this.area[10] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()+1);
        // cabeza
        this.area[1] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna());
        this.area[2] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()+1);

        //Campos siempre vacios
        //this.area[0] = null;
        //this.area[3] = null;
        //this.area[8] = null;
        //this.area[11] = null;
        //this.area[13] = null;
        //this.area[14] = null;

        //Si el mono esta apunta hacia la derecha
        if(this.direccion == Direccion.DERECHA) {
            actualizarDireccionDerecha();
        }
        //Si el mono esta apunta hacia la izquierda
        if(this.direccion == Direccion.IZQUIERDA) {
            actualizarDireccionIzquierda();
        }
        if(isOnTwoLianas){
            actualizarDireccionIzquierda();
            actualizarDireccionDerecha();
        }
    }

    private void actualizarDireccionDerecha(){
        this.area[7] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()+2);
        this.area[15] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()+2);
        this.area[4] = null;
        this.area[12] = null;
    }

    private void actualizarDireccionIzquierda(){
        this.area[4] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()-1);
        this.area[12] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()-1);
        this.area[7] = null;
        this.area[15] = null;
    }

    /**#################################################################################################
     * SETTERS AND GETTERS
     * #################################################################################################
     */

    public boolean isOnLiana() {
        return isOnLiana;
    }

    public void setOnLiana(boolean onLiana) {
        isOnLiana = onLiana;
    }
}



// Cuerpo del mono
//
// Orden
//
// |0 |1 |2 |3 |
// |4 |5 |6 |7 |
// |8 |9 |10|11|
// |12|13|14|15|
//
// Direccion derecha  ->
//
// |⬜|⬛|⬛|⬜|
// |⬜|⬛|⬛|⬛|
// |⬜|⬛|⬛|⬜|
// |⬜|⬜|⬜|⬛|
//
//
// Direccion izquierda  ->
//
// |⬜|⬛|⬛|⬜|
// |⬛|⬛|⬛|⬜|
// |⬜|⬛|⬛|⬜|
// |⬛|⬜|⬜|⬜|
//
//
// Direccion subiendo lianas
//
// |⬜|⬛|⬛|⬜|
// |⬛|⬛|⬛|⬛|
// |⬜|⬛|⬛|⬜|
// |⬛|⬜|⬜|⬛|
//
//