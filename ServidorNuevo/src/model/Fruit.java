package model;

public class Fruit extends Entity {

    // Constructor
    public Fruit(Integer i, Integer j){
        super(i, j);
        this.id = ++counter;
        this.type = EnumFruit.getType();
        this.value = type.getValue();
    }

    // Attributes
    private static int counter = 0;
    private final int id;
    private final EnumFruit type;
    private final Integer value;

    // Methods
    public EnumFruit getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }

}
