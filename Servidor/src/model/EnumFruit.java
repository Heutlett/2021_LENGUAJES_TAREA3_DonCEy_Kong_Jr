package model;

import java.util.Random;

public enum EnumFruit {
    cherry(100), apple(200), orange(300), banana(400);

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