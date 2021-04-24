package models.entidades.utils;

import controller.GameManager;
import models.entidades.Entidad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JSON_Generator {

    public static String generateMatrizJSON(Entidad[][] matriz, int nivel, int puntuacion,
                                            int vidas, boolean haGanado, boolean haPerdido){

        JSONObject obj = new JSONObject();

        obj.put("nivel", nivel);
        obj.put("puntuacion", puntuacion);
        obj.put("vidas", vidas);
        obj.put("haGanado", haGanado);
        obj.put("haPerdido", haPerdido);

        JSONArray matrizJSON = new JSONArray();

        for(int i = 0; i < GameManager.TAMANO_MATRIZ; i++){
            JSONArray fila = new JSONArray();
            for(int e = 0; e < GameManager.TAMANO_MATRIZ; e++){

                switch (matriz[i][e].getTipoEntidad()) {
                    case VACIO,PLATAFORMA,AGUA,LIANA,TROFEO -> fila.add(0);
                    case MONO -> fila.add(1);
                    case COCODRILO_ROJO -> fila.add(2);
                    case COCODRILO_AZUL -> fila.add(3);
                    case BANANO -> fila.add(4);
                    case MANZANA -> fila.add(5);
                    case MELOCOTON -> fila.add(6);
                }
            }
            matrizJSON.add(fila);
        }

        obj.put("matriz ",matrizJSON);


        return obj.toString();
    }

    public static void main(String[] args) {

        //generateMatrizJSON(null, 0,0,0,false, false);

        //generateMatrizJSON();

    }

}
