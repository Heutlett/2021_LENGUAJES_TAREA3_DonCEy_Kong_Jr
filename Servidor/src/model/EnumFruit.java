package model;

import java.util.Random;

public enum EnumFruit {
    APPLE(200), MANGO(300), BANANA(400);

    // Constructor
    private EnumFruit(int value) {
        this.value = value;
    }

    // Attributes
    private final int value;
    private static final Random RANDOM = new Random();

    // Methods
    public static EnumFruit getType()  {
        return values()[RANDOM.nextInt(values().length)];
    }

    public int getValue() {
        return value;
    }
}