package org.example.cars;

import org.example.lesson11.Printable;

public abstract class Car implements Drivable { // абстракция

    private final String model; // инкапсуляция
    private final String version; // инкапсуляция
    private final double price; // инкапсуляция
    private final int speed; // инкапсуляция
    private final Engine engine; // инкапсуляция

    public Car(String model, String version, double price, int speed, Engine engine) {
        this.model = model;
        this.version = version;
        this.price = price;
        this.speed = speed;
        this.engine = engine;
    }

    public void start(){
        System.out.println("Машина завелась");
    }

    public abstract String getCountryOfOrigin (); // абстракция

    public void printCountryOfOrigin(){
        System.out.println( "Машина " + this.getClass().getSimpleName() + " из " + getCountryOfOrigin());
    }
    public void drive(){
        System.out.println("Машина " + this.getClass().getSimpleName() + " поехала на ТО");
    }
    public void information(){
        System.out.println("Марка:" + this.getClass().getSimpleName() + ", цена: " + price + ", макс скорость: " + speed);
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getVersion() {
        return version;
    }
}
