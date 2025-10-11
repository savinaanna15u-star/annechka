package org.example.lesson11;


// Laptop <- Computer <- Object
public class Laptop extends Computer {
    private int weight;

    {
        System.out.println("init block laptop");
    }

    static {
        System.out.println("static block laptop");
    }

    public Laptop(Ssd ssd, Ram ram, int weight) {
        super(); // super - ссылка на все, что унаследовалость от базового класса
        this.weight = weight; // this - ссылка на экземпяр текущего класса
    }

    public Laptop() {
        System.out.println("Constructor laptop");
    }

    public void open() {
        System.out.println("открыл крышку");
    }

    public int getWeight() {
        return weight;
    }
}
