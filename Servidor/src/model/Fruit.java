package model;

public class Fruit extends Entity {

    private EnumFruit type;
    private Integer value;

    // Constructor
    public Fruit(double posx, double posy){
        super(posx, posy);
        this.type = EnumFruit.getType();
        this.value = type.getValue();
        this.id = "3"; // Fruits id is 3.
        this.hide = false;
    }

    public EnumFruit getType() {
        return type;
    }

    public void setType(EnumFruit type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
