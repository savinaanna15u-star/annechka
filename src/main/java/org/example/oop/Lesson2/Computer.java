package org.example.oop.Lesson2;

public class Computer { // для классов только public или

    private int ssd = 500; // private доступ только внутри класса
    private int ram;

    Computer(int newSsd) { //аргрумент метода в ()
        ssd = newSsd;
    }

    protected Computer(int newRam, int newSSD) { // protected есть доступ внутри пакета и у наследников
        ram = newRam;
        ssd = newSSD;
    }

    public Computer() { // объявлен конструктор
        System.out.println("Я был создан");
    }


    // [модификаторы] returnX name ([params])
    void load() {
        System.out.println("Я загрузился");
    }

    void printState() {
        System.out.println("Ssd: " + ssd);
        System.out.println("Ram: " + ram);
    }
}
