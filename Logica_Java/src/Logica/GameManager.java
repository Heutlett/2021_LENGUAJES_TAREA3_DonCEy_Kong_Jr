package Logica;

import Models.Entidades.Entidad;
import Models.Entidades.Estaticas.EntidadEstatica;
import Models.Entidades.Movibles.Cocodrilo;
import Models.Entidades.Movibles.EntidadMovible;
import Models.Entidades.Movibles.Fruta;
import Models.Entidades.Movibles.Mono;
import Models.Entidades.Utils.PuntoMatriz;

import java.util.ArrayList;

public class GameManager {

    private static GameManager single_instance = null;
    public static GameManager getInstance()
    {
        if (single_instance == null)
            single_instance = new GameManager();

        return single_instance;
    }

    private Mono donkeyKongJr;
    private EntidadEstatica donkeyKong;
    private ArrayList<Cocodrilo> cocodrilos;
    private ArrayList<Fruta> frutas;
    private EntidadEstatica[] lianas;
    private EntidadEstatica[] plataformas;

    private Entidad[][] matriz;
    public static int TAMANO_MATRIZ = 100;
    public static PuntoMatriz POSICION_INICIAL = new PuntoMatriz(93,1);

    private GameManager(){
        setCondicionesIniciales();
    }

    private void setCondicionesIniciales(){

        donkeyKongJr = new Mono("dkjr", POSICION_INICIAL, EntidadMovible.Direccion.DERECHA);
        //donkeyKongJr.actualizarArea();
        donkeyKong = new EntidadEstatica("dk", null, null, EntidadEstatica.TipoSuperficie.DONKEYKONG );
        cocodrilos =  new ArrayList<>();
        frutas = new ArrayList<>();
        lianas = new EntidadEstatica[10];
        plataformas = new EntidadEstatica[6];

        actualizarMatriz();
    }

    private void actualizarMatriz(){
        matriz = new Entidad[TAMANO_MATRIZ][TAMANO_MATRIZ];
        actualizarMono();

    }

    private void actualizarMono(){
        for(int i = 0; i < Mono.TAMANO_AREA; i++){
            if(donkeyKongJr.getArea()[i] != null){
                matriz[donkeyKongJr.getArea()[i].getFila()][donkeyKongJr.getArea()[i].getColumna()] = donkeyKongJr;
            }
        }
    }

    public void moverMono(EntidadMovible.Direccion direccion){
        /**
         * Antes de mover el mono se debe verificar si chocará con una pared, un mounstrou o una liana
         */

        donkeyKongJr.moverConDireccion(direccion);
        actualizarMatriz();
    }


    public void imprimirMatriz(){

        for(int i = 0; i < TAMANO_MATRIZ; i++){
            for(int e = 0; e < TAMANO_MATRIZ; e++){
                if(matriz[i][e] == null){
                    System.out.print(" ⬜ ");
                }else{
                    System.out.print(" ⬛ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public Entidad[][] getMatriz() {
        return matriz;
    }

    public static void main(String[] args) {

        GameManager gameManager = GameManager.getInstance();
        gameManager.imprimirMatriz();

        System.out.println("DERECHA");
        for(int i = 0; i < 10; i++){
            gameManager.moverMono(EntidadMovible.Direccion.DERECHA);
            gameManager.imprimirMatriz();
        }
        System.out.println("ARRIBA");
        for(int i = 0; i < 10; i++){
            gameManager.moverMono(EntidadMovible.Direccion.ARRIBA);
            gameManager.imprimirMatriz();
        }
        System.out.println("IZQUIERDA");
        for(int i = 0; i < 10; i++){
            gameManager.moverMono(EntidadMovible.Direccion.IZQUIERDA);
            gameManager.imprimirMatriz();
        }
        System.out.println("ABAJO");
        for(int i = 0; i < 10; i++){
            gameManager.moverMono(EntidadMovible.Direccion.ABAJO);
            gameManager.imprimirMatriz();
        }


    }

}
