package Controller;

import Models.Entidades.Entidad;
import Models.Entidades.Estaticas.EntidadEstatica;
import Models.Entidades.Movibles.Cocodrilo;
import Models.Entidades.Movibles.EntidadMovible;
import Models.Entidades.Movibles.Mono;
import Models.Entidades.Utils.PuntoMatriz;

import java.util.ArrayList;

public class CocodriloController {

    private Entidad[][] matriz;
    private ArrayList<Cocodrilo> cocodrilos;
    private EntidadEstatica[] lianas;
    private int TAMANO_MATRIZ = 100;
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

    private boolean compararPosicion(PuntoMatriz posicion1, PuntoMatriz posicion2){

        if(posicion1.getFila() == posicion2.getFila() && posicion1.getColumna() == posicion2.getColumna()){
            return true;
        }

        return false;
    }

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

    public void moverCocodrilos(){

        /**
         * FALTA VALIDAR QUE TIPO DE COCODRILO SE MUEVEEE
         */

        limpiarAreaAnteriorCocodrilos();

        for(int e = 0; e < cocodrilos.size(); e++){
            Cocodrilo cocodrilo = cocodrilos.get(e);
            /*
            Entidad.TipoEntidad colision = donkeyKongJr.getColisionMono(cocodrilo);
            if(colision == Entidad.TipoEntidad.COCODRILO_AZUL || colision == Entidad.TipoEntidad.COCODRILO_ROJO){
                donkeyKongJr.setHaPerdido(true);
                return;
            }*/
            if(cocodrilo.getTipoEntidad() == Entidad.TipoEntidad.COCODRILO_ROJO){
                moverCocodrilosRojos(cocodrilo);
            }else{
                moverCocodrilosAzules(cocodrilo);
            }
        }

        actualizarCocodrilos();
/*
        ArrayList<Entidad.TipoEntidad> listaColisiones = monoController.obtenerColisionesEstatico();

        // Verifica si colisionó con el mono
        if(listaColisiones.contains(Entidad.TipoEntidad.COCODRILO_ROJO)
                || listaColisiones.contains(Entidad.TipoEntidad.COCODRILO_AZUL)){

            donkeyKongJr.setHaPerdido(true);
        }
        /
 */
    }


    private void actualizarCocodrilos(){
        for(int e = 0; e < cocodrilos.size(); e++){
            for(int i = 0; i < cocodrilos.get(e).getArea().length; i++){
                if(cocodrilos.get(e).getArea() != null && verificarLimitesPosicionMatriz(cocodrilos.get(e).getArea()[i])
                        && cocodrilos.get(e).getArea()[i] != null){
                    matriz[cocodrilos.get(e).getArea()[i].getFila()][cocodrilos.get(e).getArea()[i].getColumna()] =
                            cocodrilos.get(e);
                }
            }
        }
    }

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

    public void limpiarAreaAnteriorCocodrilos(){

        for(int e = 0; e < cocodrilos.size(); e++){
            for(int i = 0; i < cocodrilos.get(e).getArea().length; i++){
                if(cocodrilos.get(e).getArea() != null){
                    if(verificarLimitesPosicionMatriz(cocodrilos.get(e).getArea()[i])){
                        matriz[cocodrilos.get(e).getArea()[i].getFila()][cocodrilos.get(e).getArea()[i].getColumna()] = null;
                    }
                }
            }
        }
    }


    private EntidadEstatica buscarLianaById(String id){
        for(int i = 0; i < lianas.length; i++){
            if(lianas[i].getId().equals(id)){
                return lianas[i];
            }
        }
        return null;
    }
}
