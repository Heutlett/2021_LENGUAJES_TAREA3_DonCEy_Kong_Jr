package models.entidades.utils;

/**
 * Par ordenado de puntos que representa un espacio en la matriz, el cual podria servir de posicion actual, o para
 * definir el area de una entidad
 */
public class PuntoMatriz {

    private int fila;
    private int columna;

    public PuntoMatriz(Integer fila, Integer columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**#################################################################################################
     * SETTERS AND GETTERS
     * #################################################################################################
     */

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return "PuntoMatriz{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
