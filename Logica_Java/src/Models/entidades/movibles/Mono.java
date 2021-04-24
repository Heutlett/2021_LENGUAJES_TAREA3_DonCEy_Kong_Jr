package models.entidades.movibles;

import models.entidades.Entidad;
import models.entidades.utils.PuntoMatriz;



public class Mono extends EntidadMovible{

    private volatile boolean isOnLiana;
    private boolean isOnTwoLianas;
    private volatile boolean isJumping;
    public static Integer TAMANO_AREA = 16;
    private PuntoMatriz manoIzquierda;
    private PuntoMatriz manoDerecha;
    private volatile boolean isFalling;
    private Integer puntuacion;
    private volatile boolean haPerdido;
    private volatile boolean haGanado;

    public boolean isHaPerdido() {
        return haPerdido;
    }

    public void setHaPerdido(boolean haPerdido) {
        this.haPerdido = haPerdido;
    }

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
        isFalling = false;
        puntuacion = 0;
        haPerdido = false;
        haGanado = false;
    }

    public TipoEntidad getColisionMono(Entidad entidad){


        if(entidad != null && entidad.getArea() != null){
            PuntoMatriz[] area2 = entidad.getArea();

            for(int i = 0; i < area2.length; i++) {
                for(int e = 0; e < getArea().length; e++){
                    if(area2[i] != null && getArea()[e] != null
                            && area2[i].getFila() >= 0 && area2[i].getFila() < 100
                            && area2[i].getColumna() >= 0 && area2[i].getColumna() < 100

                            && getArea()[e] != null && getArea()[e].getFila() >= 0 && getArea()[e] != null
                            && getArea()[e].getFila() < 100
                            && getArea()[e] != null && getArea()[e].getColumna() >= 0 && getArea()[e] != null
                            && getArea()[e].getColumna() < 100){


                        if(area2[i].getFila() == getArea()[e].getFila()
                                && area2[i].getColumna() == getArea()[e].getColumna()){
                            return entidad.getTipoEntidad();
                        }
                    }
                }
            }
        }

        return null;
    }

    public boolean isHaGanado() {
        return haGanado;
    }

    public void setHaGanado(boolean haGanado) {
        this.haGanado = haGanado;
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
        actualizarDireccionIzquierda();
    }

    public void direccionAreaIzquierda(){
        this.area = new PuntoMatriz[TAMANO_AREA];
        actualizarDireccionCuerpo();
        actualizarDireccionDerecha();
        actualizarDireccionIzquierda();
    }

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
        manoDerecha = this.area[7];
        this.area[15] = new PuntoMatriz(this.posicion.getFila()+1,this.posicion.getColumna()+2);
    }

    private void actualizarDireccionIzquierda(){
        //Brazo y pie izquierdo
        this.area[4] = new PuntoMatriz(this.posicion.getFila()-1,this.posicion.getColumna()-1);
        manoIzquierda = this.area[4];
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

    public PuntoMatriz getManoIzquierda() {
        return manoIzquierda;
    }

    public void setManoIzquierda(PuntoMatriz manoIzquierda) {
        this.manoIzquierda = manoIzquierda;
    }

    public PuntoMatriz getManoDerecha() {
        return manoDerecha;
    }

    public void setManoDerecha(PuntoMatriz manoDerecha) {
        this.manoDerecha = manoDerecha;
    }

    public boolean isFalling() {
        return isFalling;
    }

    public void setFalling(boolean falling) {
        isFalling = falling;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
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