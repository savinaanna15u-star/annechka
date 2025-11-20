package org.example.cars;

public class Lada extends Car { // наследование от Car


    public Lada(String model, String version, double price, int speed, Engine engine) {
        super(model, version, price, speed, engine);
    }

    @Override // переопределение метода - полиморфизм
    public String getCountryOfOrigin() {
        return "России";
    }

}
