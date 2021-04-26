package controller;

import models.entidades.Entidad;
import models.entidades.movibles.Fruta;
import models.entidades.utils.PuntoMatriz;
import java.util.ArrayList;

/**
 * Controlador de las frutas, encargado de todas las funciones de las frutas
 */
public class FrutaController {

    private Entidad[][] matriz;
    private int TAMANO_MATRIZ = 100;
    private ArrayList<Fruta> frutas;

    public FrutaController(Entidad[][] matriz, ArrayList<Fruta> frutas) {
        this.matriz = matriz;
        this.frutas = frutas;
    }

    /**
     * Funcion: borrarFruta
     * Borra una fruta del juego
     * @param fruta fruta que se desea borrar
     */
    public void borrarFruta(Fruta fruta){
        for(int i = 0; i < fruta.getArea().length; i++){
            if(fruta.getArea()[i] != null){
                matriz[fruta.getArea()[i].getFila()][fruta.getArea()[i].getColumna()] = Entidad.crearEntidadVacia();

            }
        }
        System.out.println("Se ha borrado una fruta: " + fruta.toString());
        frutas.remove(fruta);
    }

    /**
     * Funcion: moverFruta
     * Mueve una fruta a una nueva posicion en la matriz principal del juego
     * @param idFruta id de la fruta que se desea mover
     * @param nuevaPosicion posicion donde se desea mover
     */
    public void moverFruta(String idFruta, PuntoMatriz nuevaPosicion){

        Fruta fruta = buscarFrutaById(idFruta);
        if(fruta != null){
            limpiarAreaAnteriorFruta(fruta);
            fruta.moverConPosicion(nuevaPosicion);
            actualizarFruta(fruta);
        }
    }

    /**
     * Funcion: actualizarFruta
     * Actualiza una fruta en la matriz principal del juego
     * @param fruta fruta a actualizar
     */
    public void actualizarFruta(Fruta fruta){
        for(int i = 0; i < fruta.getArea().length; i++){
            if(verificarLimitesPosicionMatriz(fruta.getArea()[i])
                    && fruta.getArea()[i] != null){
                matriz[fruta.getArea()[i].getFila()][fruta.getArea()[i].getColumna()] =
                        fruta;
            }
        }
    }

    /**
     * Funcion: actualizarFrutas
     * Actualiza todas las frutas en la matriz principal del juego
     */
    public void actualizarFrutas(){
        limpiarAreaAnteriorFrutas();
        for(int i = 0; i < frutas.size(); i++){
            actualizarFruta(frutas.get(i));
        }
    }

    /**
     * Funcion: verificarLimitesPosicionMatriz
     * Verifica si un punto se encuentra dentro de los limites de la matriz principal del juego
     * @param posicion posicion a verificar
     * @return true si esta dentro de los limites y false de lo contrario
     */
    private boolean verificarLimitesPosicionMatriz(PuntoMatriz posicion){

        if(posicion != null
                && posicion.getFila() < TAMANO_MATRIZ
                && posicion.getColumna() < TAMANO_MATRIZ
                && posicion.getFila()  >= 0
                && posicion.getColumna() >= 0){
            return true;
        }
        return false;
    }

    /**
     * Funcion: limpiarAreaAnteriorFruta
     * Limpia el area de una fruta borrando sus puntos de la matriz principal del juego
     * @param fruta fruta que se limpiara
     */
    private void limpiarAreaAnteriorFruta(Fruta fruta){

        for(int i = 0; i < fruta.getArea().length; i++){

            if(verificarLimitesPosicionMatriz(fruta.getArea()[i])){
                matriz[fruta.getArea()[i].getFila()][fruta.getArea()[i].getColumna()] = Entidad.crearEntidadVacia();
            }
        }
    }

    /**
     * Funcion: limpiarAreaAnteriorFruta
     * Limpia el area de todas las frutas borrando sus puntos de la matriz principal del juego
     */
    public void limpiarAreaAnteriorFrutas(){
        for(int e = 0; e < frutas.size(); e++){
            for(int i = 0; i < frutas.get(e).getArea().length; i++){

                if(verificarLimitesPosicionMatriz(frutas.get(e).getArea()[i])){
                    matriz[frutas.get(e).getArea()[i].getFila()][frutas.get(e).getArea()[i].getColumna()] = Entidad.crearEntidadVacia();
                }
            }
        }
    }

    /**
     * Funcion: buscarFrutaById
     * Busca una fruta por id en el arreglo de fruta
     * @param idFruta id de la fruta a buscar
     * @return la fruta si la encuentra y null de lo contrario
     */
    public Fruta buscarFrutaById(String idFruta){
        for(int i = 0; i < frutas.size(); i++){
            if(idFruta.contains(frutas.get(i).getId())){
                return frutas.get(i);
            }
        }
        return null;
    }
}
