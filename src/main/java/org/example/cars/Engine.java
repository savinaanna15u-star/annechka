package org.example.cars;

public abstract class Engine {

    private final String name;
    private final int power;

    protected Engine(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }
}
