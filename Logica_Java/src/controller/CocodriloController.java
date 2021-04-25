package controller;

import models.entidades.Entidad;
import models.entidades.estaticas.EntidadEstatica;
import models.entidades.movibles.Cocodrilo;
import models.entidades.movibles.EntidadMovible;
import models.entidades.movibles.Mono;
import models.entidades.utils.PuntoMatriz;
import java.util.ArrayList;

/**
 * Controlador de los cocodrilos, se encarga del funcionamiento de los cocodrilos, su creacion, movimiento y todas las
 * funciones necesarias.
 */
public class CocodriloController {

    private Entidad[][] matriz;
    private ArrayList<Cocodrilo> cocodrilos;
    private EntidadEstatica[] lianas;
    private Integer TAMANO_MATRIZ = 100;
    private MonoController monoController;
    private Mono donkeyKongJr;

    public CocodriloController(Entidad[][] matriz, ArrayList<Cocodrilo> cocodrilos, EntidadEstatica[] lianas,
                               MonoController monoController, Mono donkeyKongJr) {
        this.matriz = matriz;
        this.cocodrilos = cocodrilos;
        this.lianas = lianas;
        this.monoController = monoController;
        this.donkeyKongJr = donkeyKongJr;
    }

    /**
     * Funcion: compararPosicion
     * Compara dos puntos de la matriz
     * @param posicion1 punto1
     * @param posicion2 punto2
     * @return true si coinciden y false de lo contrario
     */
    private boolean compararPosicion(PuntoMatriz posicion1, PuntoMatriz posicion2){

        if(posicion1.getFila() == posicion2.getFila() && posicion1.getColumna() == posicion2.getColumna()){
            return true;
        }
        return false;
    }

    /**
     * Funcion: moverCocodrilosRojos
     * Mueve los cocodrilos rojos
     * @param cocodrilo cocodrilo que se movera
     */
    private void moverCocodrilosRojos(Cocodrilo cocodrilo){

        if(cocodrilo.getDireccion() == EntidadMovible.Direccion.ARRIBA
                && compararPosicion(cocodrilo.getPosicion(), buscarLianaById(cocodrilo.getIdLiana()).getPosicion())){

            cocodrilo.setDireccion(EntidadMovible.Direccion.ABAJO);

        }else if(cocodrilo.getDireccion() == EntidadMovible.Direccion.ABAJO
                && compararPosicion(cocodrilo.getPosicion(), buscarLianaById(cocodrilo.getIdLiana()).getUltimaPosicion())){

            cocodrilo.setDireccion(EntidadMovible.Direccion.ARRIBA);
        }
        else if(cocodrilo.getDireccion() == EntidadMovible.Direccion.ABAJO
                && !compararPosicion(cocodrilo.getPosicion(), buscarLianaById(cocodrilo.getIdLiana()).getUltimaPosicion())){

            PuntoMatriz nuevaPosicion = new PuntoMatriz(cocodrilo.getPosicion().getFila()+1,
                    cocodrilo.getPosicion().getColumna());
            cocodrilo.moverConPosicion(nuevaPosicion);

        }else if(cocodrilo.getDireccion() == EntidadMovible.Direccion.ARRIBA
                && !compararPosicion(cocodrilo.getPosicion(), buscarLianaById(cocodrilo.getIdLiana()).getPosicion())) {

            PuntoMatriz nuevaPosicion = new PuntoMatriz(cocodrilo.getPosicion().getFila() - 1,
                    cocodrilo.getPosicion().getColumna());
            cocodrilo.moverConPosicion(nuevaPosicion);
        }
    }

    /**
     * Funcion: moverCocodrilosAzules
     * Mueve los cocodrilos azules
     * @param cocodrilo cocodrilo que se movera
     */
    private void moverCocodrilosAzules(Cocodrilo cocodrilo){

        if(cocodrilo.getDireccion() == EntidadMovible.Direccion.ABAJO){

            PuntoMatriz nuevaPosicion = new PuntoMatriz(cocodrilo.getPosicion().getFila()+1,
                    cocodrilo.getPosicion().getColumna());

            cocodrilo.moverConPosicion(nuevaPosicion);
        }
        if(cocodrilo.getPosicion().getFila() > TAMANO_MATRIZ){
            cocodrilos.remove(cocodrilo);
        }
    }

    /**
     * Funcion: moverCocodrilos
     * Mueve todos los cocodrilos
     */
    public void moverCocodrilos(){

        limpiarAreaAnteriorCocodrilos();

        for(int e = 0; e < cocodrilos.size(); e++) {
            Cocodrilo cocodrilo = cocodrilos.get(e);

            try{
                Entidad.TipoEntidad colision = donkeyKongJr.getColisionMono(cocodrilo);
                if(colision == Entidad.TipoEntidad.COCODRILO_AZUL || colision == Entidad.TipoEntidad.COCODRILO_ROJO){
                    donkeyKongJr.setHaPerdido(true);
                    return;
                }
            }catch (Exception exception){

            }

            if(cocodrilo.getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_ROJO){
                moverCocodrilosRojos(cocodrilo);
            }else{
                moverCocodrilosAzules(cocodrilo);
            }
        }
        actualizarCocodrilos();
    }

    /**
     * Funcion: actualizarCocodrilos
     * Actualiza todos los cocodrilos en la matriz principal del juego
     */
    private void actualizarCocodrilos(){

        for(int e = 0; e < cocodrilos.size(); e++){
            for(int i = 0; i < cocodrilos.get(e).getArea().length; i++){
                if(cocodrilos.get(e) != null && cocodrilos.get(e).getArea() != null && verificarLimitesPosicionMatriz(cocodrilos.get(e).getArea()[i])
                        && cocodrilos.get(e).getArea()[i] != null){
                    matriz[cocodrilos.get(e).getArea()[i].getFila()][cocodrilos.get(e).getArea()[i].getColumna()] =
                            cocodrilos.get(e);
                }
            }
        }
    }

    /**
     * Funcion: verificarLimitesPosicionMatriz
     * Verifica si un punto se encuentra dentro de los limites la matriz principal del juego
     * @param posicion posicion que se verificara
     * @return true si se encuentra dentro de los limites permitidos y false de lo contrario
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
     * Funcion: limpiarAreaAnteriorCocodrilos
     * Limpia el area anterior de todos los cocodrilos en la matriz principal del juego
     */
    public void limpiarAreaAnteriorCocodrilos(){

        try{
            for(int e = 0; e < cocodrilos.size(); e++){
                for(int i = 0; i < cocodrilos.get(e).getArea().length; i++){
                    if(cocodrilos.get(e).getArea() != null){
                        if(verificarLimitesPosicionMatriz(cocodrilos.get(e).getArea()[i])){
                            matriz[cocodrilos.get(e).getArea()[i].getFila()][cocodrilos.get(e).getArea()[i].getColumna()]
                                    = Entidad.crearEntidadVacia();
                        }
                    }
                }
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getStackTrace());
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Funcion: buscarLianaById
     * Busca una liana por id en el arreglo de lianas
     * @param id id de la liana a buscar
     * @return la liana si la encuentra y null si no la encuentra
     */
    private EntidadEstatica buscarLianaById(String id){
        for(int i = 0; i < lianas.length; i++){
            if(lianas[i].getId().equals(id)){
                return lianas[i];
            }
        }
        return null;
    }
}
