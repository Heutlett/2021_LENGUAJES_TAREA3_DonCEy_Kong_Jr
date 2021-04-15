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

    private EntidadMovible donkeyKongJr;
    private EntidadEstatica donkeyKong;
    private ArrayList<Cocodrilo> cocodrilos;
    private ArrayList<Fruta> frutas;
    private EntidadEstatica[] lianas;
    private EntidadEstatica[] plataformas;

    private Entidad[][] matriz;

    private GameManager(){
        donkeyKongJr = new Mono("donkeyKongJr", null, null, null);
        donkeyKong = new EntidadEstatica("donkeyKong", null, null, EntidadEstatica.TipoSuperficie.DONKEYKONG );
        cocodrilos =  new ArrayList<>();
        frutas = new ArrayList<>();
        lianas = new EntidadEstatica[10];
        plataformas = new EntidadEstatica[6];
        matriz = new Entidad[50][50];
    }

    private void setCondicionesIniciales(){
        donkeyKongJr.setPosicion(new PuntoMatriz(43,1));
        //PuntoMatriz[] areaDonkeyKongJr = {new PuntoMatriz(44,0)}
        //donkeyKongJr.setArea();
    }





}
