package org.example.lesson11;


// Laptop <- Computer <- Object (если конструктор без параметров, то super можно пропустить)
public final class Laptop extends Computer { //класс Laptop наследует (extends)  Computer (extends)
    // при наследовании мы обязаны использовать какой то конструктор, который имеется в базовом(родительский) классе!
    // в конструкторе наследнике обяз. вызвать конструктор базового класса, через super, первой строчкой вызвать базовый класс
    // можно наследовать только 1 класс
    // final - запрет наследования от Laptop
    private int weight;

    {
        System.out.println("init block laptop"); // доинициализировать этот объект
    }

    static {
        System.out.println("static block laptop");
    }

    public Laptop(Ssd ssd, Ram ram, int weight) {
        super(ssd, ram); // super - ссылка на все, что унаследовалость от базового класса
        this.weight = weight; // this - ссылка на экземпяр текущего класса
    }

    public Laptop() {
        System.out.println("Constructor laptop");
    }

    @Override  // переопределение метода из базового класса
    public void load() {
        open();
        System.out.println("Я загрузился");
    }

    @Override
    public void print() {
        super.print();
        System.out.println("weight = " + weight);
    }

    public void open() {
        System.out.println("Я открыл крышку");
    }

    public int getWeight() {
        return weight;
    }
}

// alt + enter - вызвать меню для исправления ошибки компиляции