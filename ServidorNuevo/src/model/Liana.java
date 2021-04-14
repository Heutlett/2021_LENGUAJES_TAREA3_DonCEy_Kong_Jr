package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Liana extends Entity {

    // Constructor
    public Liana(Integer i, Integer j, int length) {
        super(i, j);
        this.id = ++counter;
        this.length = length;
        this.speed=0;
    }

    // Attributes
    private static int counter = 0;
    private final int id;
    private final int length;

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }
}
