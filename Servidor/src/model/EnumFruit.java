package model;

import java.util.Random;

public enum EnumFruit {
    cherry(1), banana(2), apple(3), orange(4);

    private int value;
    private static final Random RANDOM = new Random();

    private EnumFruit(int value) {
        this.value = value;
    }

    public static EnumFruit getType()  {
        EnumFruit type = values()[RANDOM.nextInt(values().length)];
        return type;
    }

    public int getValue() {
        return value;
    }
}