package org.example.cars;

public class Lexus extends Car { // насоедование от Car


    public Lexus(String model, String version, double price, int speed, Engine engine) {
        super(model, version, price, speed, engine);
    }

    @Override // переопределение метода - полиморфизм
    public String getCountryOfOrigin() {
        return "Японии";

    }
}
