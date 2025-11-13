package org.example.lesson11;

public abstract class Computer { // abstract - запрещаем делать объект этого класса, те только для наследования

    private Ssd ssd; // инкапсуляция - скрытие данных и сложности от пользователя(чел, который работает с классом и методами этого класса)
    private Ram ram;

    {
        System.out.println("init block computer");
    }

    static {
        System.out.println("static block computer");
    }

    public Computer(Ssd ssd, Ram ram) {
        super();
        this.ssd = ssd;
        this.ram = ram;
    }

    public Computer() {
        System.out.println("Constructor computer");
    }

    public abstract void load(); // абстрактный метод - не имеет реализации

//    public void load() {
//        System.out.println("Я загрузился");
//    }

    public void print(){
        System.out.println("Ssd: " + ssd.getValue() + ", ram: " + ram.getValue());
    }

    public Ssd getSsd() { // чтобы иметь доступ к приватному полю извне класса
        return ssd;
    }

    public Ram getRam() {
        return ram;
    }
}
