package model;

public abstract class Snapjaw extends Entity {

    // Constructor
    public Snapjaw(Integer i, Integer j, Liana liana) {
        super(i, j);
        this.id = ++counter;
        this.liana = liana;
    }

    // Attributes
    private static int counter = 0;
    private final int id;
    private Liana liana;

    // Methods
    public void glideDown(){
    }

    public void setLiana(Liana liana) {
        this.liana = liana;
    }
}
