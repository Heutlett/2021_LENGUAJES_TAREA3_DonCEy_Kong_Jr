package view;

import javax.swing.*;

/**
 * Encapsula un JBUTTON para que actue como casilla de la matriz en la interfaz del servidor
 */
public class CampoBoton extends JButton {
    /**
     * El id es "vacio" en caso de que no haya una entidad
     */
    private String id;
    private Integer fila;
    private Integer columna;

    public CampoBoton(Integer fila, Integer columna, String id) {
        this.fila = fila;
        this.columna = columna;
        this.id = id;
    }

    /**#################################################################################################
     * SETTERS AND GETTERS
     * #################################################################################################
     */

    public Integer getFila() {
        return fila;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getColumna() {
        return columna;
    }

}
