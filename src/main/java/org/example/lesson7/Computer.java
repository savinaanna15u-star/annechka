package org.example.lesson7;

public class Computer { // класс это чертеж

    private Ram ram;
    private Ssd ssd;
    private static int counter = 0; // static относится не к объектам, а к классам

    public Computer(Ram ram, Ssd ssd) { // деталь - это конкретный экземляр класса, который создан на основании этого черте жа
        this.ram = ram;
        this.ssd = ssd;
        counter ++;

    }

    public static int getCouter() {
        return counter;
    }

    public void printState(){
        System.out.println("Computer: ram " + ram.getX() + ", ssd " + ssd.getX());
    }
}



