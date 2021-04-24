package Controller;

import Models.Entidades.Entidad;
import Models.Entidades.Movibles.Fruta;
import Models.Entidades.Utils.PuntoMatriz;

import java.util.ArrayList;

public class FrutaController {

    private Entidad[][] matriz;
    private int TAMANO_MATRIZ = 100;
    private ArrayList<Fruta> frutas;

    public FrutaController(Entidad[][] matriz, ArrayList<Fruta> frutas) {
        this.matriz = matriz;
        this.frutas = frutas;
    }

    public void borrarFruta(Fruta fruta){
        for(int i = 0; i < fruta.getArea().length; i++){
            if(fruta.getArea()[i] != null){
                matriz[fruta.getArea()[i].getFila()][fruta.getArea()[i].getColumna()] = Entidad.crearEntidadVacia();

            }
        }
        System.out.println("Se ha borrado una fruta: " + fruta.toString());
        frutas.remove(fruta);
    }

    public void moverFruta(Fruta fruta, PuntoMatriz nuevaPosicion){

        /**
         * FALTA VALIDAR QUE TIPO DE COCODRILO SE MUEVEEE
         */

        limpiarAreaAnteriorFruta(fruta);
        fruta.moverConPosicion(nuevaPosicion);

        actualizarFruta(fruta);
    }

    public void actualizarFruta(Fruta fruta){
        for(int i = 0; i < fruta.getArea().length; i++){
            if(verificarLimitesPosicionMatriz(fruta.getArea()[i])
                    && fruta.getArea()[i] != null){
                matriz[fruta.getArea()[i].getFila()][fruta.getArea()[i].getColumna()] =
                        fruta;
            }
        }

    }

    public void actualizarFrutas(){
        limpiarAreaAnteriorFrutas();
        for(int i = 0; i < frutas.size(); i++){
            actualizarFruta(frutas.get(i));
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


    private void limpiarAreaAnteriorFruta(Fruta fruta){

        for(int i = 0; i < fruta.getArea().length; i++){

            if(verificarLimitesPosicionMatriz(fruta.getArea()[i])){
                matriz[fruta.getArea()[i].getFila()][fruta.getArea()[i].getColumna()] = Entidad.crearEntidadVacia();
            }
        }

    }

    public void limpiarAreaAnteriorFrutas(){
        for(int e = 0; e < frutas.size(); e++){
            for(int i = 0; i < frutas.get(e).getArea().length; i++){

                if(verificarLimitesPosicionMatriz(frutas.get(e).getArea()[i])){
                    matriz[frutas.get(e).getArea()[i].getFila()][frutas.get(e).getArea()[i].getColumna()] = Entidad.crearEntidadVacia();
                }
            }
        }


    }


    public Fruta buscarFrutaById(String idFruta){
        for(int i = 0; i < frutas.size(); i++){
            if(idFruta.contains(frutas.get(i).getId())){
                return frutas.get(i);
            }
        }
        return null;
    }

}
