package Models.Entidades.Utils;

/**
 * Par ordenado de puntos que representa un espacio en la matriz, el cual podria servir de posicion actual, o para
 * definir el area de una entidad
 */
public class PuntoMatriz {

    private Integer fila;
    private Integer columna;

    public PuntoMatriz(Integer fila, Integer columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public Integer getFila() {
        return fila;
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

    @Override
    public String toString() {
        return "PuntoMatriz{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
