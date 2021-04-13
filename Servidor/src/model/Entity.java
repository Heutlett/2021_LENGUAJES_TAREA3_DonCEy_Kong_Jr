package model;

//Factory.
public abstract class Entity {

    protected Integer velocity;
    protected Double posx;
    protected Double posy;
    protected String id;
    protected boolean hide;

    // Constructor
    public Entity(Double x, Double y){
        this.posx = x;
        this.posy = y;
        this.velocity = 1;
    }

    public Integer getVelocity() {
        return velocity;
    }

    public void setVelocity(Integer velocity) {
        this.velocity = velocity;
    }

    public Double getPosx() {
        return posx;
    }

    public void setPosx(Double posx) {
        this.posx = posx;
    }

    public Double getPosy() {
        return posy;
    }

    public void setPosy(Double posy) {
        this.posy = posy;
    }

}
