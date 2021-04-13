package model;

public class SnapjawBlue extends Snapjaw{

    // Constructor
    public SnapjawBlue(double x, double y) {
        super(x, y);
    }

    @Override
    public void glideDown(){
        // Es el Update posicion de bajada, lo mata cuando se sale del mapa.
        // Sigue bajando hasta salirse del mapa.
    }
}
