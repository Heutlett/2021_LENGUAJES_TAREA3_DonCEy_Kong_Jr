package model;

public class SnapjawRed extends Snapjaw{

    // Constructor
    public SnapjawRed(Integer i, Integer j, Liana liana) {
        super(i, j, liana);
    }

    @Override
    public void glideDown(){
        // Es el Update posicion de bajada.
        // Baja hasta el final de la linea.
    }

    public void glideUp(){
        // Es el Update posicion de subida.
        // Sube hasta el inicio de la linea.
    }

}
