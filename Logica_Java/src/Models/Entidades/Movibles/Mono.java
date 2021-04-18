package Models.Entidades.Movibles;

import Models.Entidades.Utils.PuntoMatriz;



public class Mono extends EntidadMovible{

    private boolean isOnLiana;
    private boolean isOnTwoLianas;
    private boolean isJumping;
    public static Integer TAMANO_AREA = 16;

    public Mono(String id, PuntoMatriz posicion, Direccion direccion, TipoEntidad tipoEntidad) {
        super(id, posicion, new PuntoMatriz[TAMANO_AREA],tipoEntidad, direccion);
        this.isOnLiana = false;
        this.isOnTwoLianas = false;
        direccionAreaDerecha();
        LIMITE_DERECHA = 1;
        LIMITE_IZQUIERDA = 1;
        LIMITE_ARRIBA = 1;
        LIMITE_ABAJO = 1;
        isJumping = false;
    }

    public boolean isOnTwoLianas() {
        return isOnTwoLianas;
    }

    public void setOnTwoLianas(boolean onTwoLianas) {
        isOnTwoLianas = onTwoLianas;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public void direccionAreaDerecha(){
        this.area = new PuntoMatriz[TAMANO_AREA];
        actualizarDireccionCuerpo();
        actualizarDireccionDerecha();
    }

    public void direccionAreaIzquierda(){
        this.area = new PuntoMatriz[TAMANO_AREA];
        actualizarDireccionCuerpo();
        actualizarDireccionIzquierda();
    }

    /**
     * En este caso solo funciona cuando esta subido en una liana este caso se debe tratar con el atributo
     * isOnLiana, el cual será asignado a true por el gameManager si despues de moverse el algun brazo del mono
     * toca una liana (estas validaciones se deben hacer en el gamemanager cada vez que se mueve el mono)
     */
    public void direccionAreaAbajo() {
        this.area = new PuntoMatriz[TAMANO_AREA];
        actualizarDireccionCuerpo();
        actualizarDireccionDerecha();
        actualizarDireccionIzquierda();
    }

    public void direccionAreaArriba() {
        this.area = new PuntoMatriz[TAMANO_AREA];
        actualizarDireccionCuerpo();
        actualizarDireccionDerecha();
        actualizarDireccionIzquierda();
    }

    private void actualizarDireccionCuerpo(){
        //Cuerpo
        this.area[5] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna());
        this.area[6] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()+1);
        this.area[9] = this.posicion;
        this.area[10] = new PuntoMatriz(this.posicion.getFila(),this.posicion.getColumna()+1);
        //Cabeza
        this.area[1] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna());
        this.area[2] = new PuntoMatriz(this.posicion.getFila()-2,this.posicion.getColumna()+1);

        this.area[15] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()+2);
        this.area[12] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()-1);

    }

    private void actualizarDireccionDerecha(){
        //Brazo y pie derecho
        this.area[7] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()+2);
        this.area[15] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()+2);
    }

    private void actualizarDireccionIzquierda(){
        //Brazo y pie izquierdo
        this.area[4] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()-1);
        this.area[12] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()-1);
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