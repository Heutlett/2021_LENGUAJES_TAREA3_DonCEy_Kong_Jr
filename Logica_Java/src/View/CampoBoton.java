package View;

import javax.swing.*;

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

    public Integer getFila() {
        return fila;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }
}
