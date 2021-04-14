package model;

public class SnapjawBlue extends Snapjaw{

    // Constructor
    public SnapjawBlue(Integer i, Integer j, Liana liana) {
        super(i, j, liana);
    }

    @Override
    public void glideDown(){
        // Es el Update posicion de bajada, lo mata cuando se sale del mapa.
        // Sigue bajando hasta salirse del mapa.
    }
}
