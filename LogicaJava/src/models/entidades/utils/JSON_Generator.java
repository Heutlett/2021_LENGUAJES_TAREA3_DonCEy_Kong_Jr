package models.entidades.utils;

import controller.GameManager;
import models.entidades.Entidad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Generador de json para comunicarse con el cliente, se enviara json que contiene los estados necesarios que debe
 * mostrar el cliente como la puntuacion, el nivel y las vidas y se envia la matriz principal del juego
 */
public class JSON_Generator {


    public static String generateJSON(int[][] matriz, int nivel, int puntuacion,
                                      int vidas, boolean haGanado, boolean haPerdido){

        JSONObject obj = new JSONObject();

        obj.put("nivel", nivel);
        obj.put("puntuacion", puntuacion);
        obj.put("vidas", vidas);
        obj.put("haGanado", haGanado);
        obj.put("haPerdido", haPerdido);

        JSONArray matrizJSON = new JSONArray();

        for(int i = 0; i < GameManager.TAMANO_MATRIZ; i++){
            for(int e = 0; e < GameManager.TAMANO_MATRIZ; e++){

                if(matriz[i][e] != 0){
                    JSONArray nuevaEntidad = new JSONArray();
                    nuevaEntidad.add(matriz[i][e]);
                    nuevaEntidad.add(i);
                    nuevaEntidad.add(e);
                    matrizJSON.add(nuevaEntidad);
                }
            }
        }
        obj.put("entidades ",matrizJSON);
        return obj.toString();
    }

    public static String generateJSON2(int[][] matriz, int nivel, int puntuacion,
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

                fila.add(matriz[i][e]);

            }
            matrizJSON.add(fila);
        }
        obj.put("matriz ",matrizJSON);
        return obj.toString();
    }
}
