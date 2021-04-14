package model;

//Factory.
public abstract class Entity {

    // Constructor
    public Entity(Integer i, Integer j){
        this.i = i;
        this.i = j;
        this.speed = 1; //  default speed
        this.onScreen = true;
    }

    // Attributes
    protected String id;
    protected int i;
    protected int j;
    protected Integer speed;
    protected boolean onScreen;

    // Methods
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public boolean isOnScreen() {
        return onScreen;
    }

    public void setOnScreen(boolean onScreen) {
        this.onScreen = onScreen;
    }


}
