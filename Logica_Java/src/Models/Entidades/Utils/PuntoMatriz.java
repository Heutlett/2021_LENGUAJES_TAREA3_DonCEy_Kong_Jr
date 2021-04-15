package Models.Entidades.Utils;

/**
 * Par ordenado de puntos que representa un espacio en la matriz, el cual podria servir de posicion actual, o para
 * definir el area de una entidad
 */
public class PuntoMatriz {

    private int fila;
    private int columna;

    public PuntoMatriz(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
