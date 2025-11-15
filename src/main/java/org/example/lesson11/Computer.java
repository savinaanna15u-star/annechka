package org.example.lesson11;

public abstract class Computer implements Printable {
    // abstract - запрещаем делать объект этого класса, те только для наследования

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
// abstract и final нельзя ставить вместе
    // abstract - метод должен быть переопределён в подклассах (у него нет реализации в объявляющем классе)
    // final - запрещает переопеделять этот метод в наследниках
    // static методы нельзя переопределять!! тк они относятся не к объекту, а к классу
    @Override  //  чтобы показать, что метод достался из других обстрактных классов, или классов, которые мы наследуем и интерфейсов
    public  void print(){ // если public final void print(), то метод нельзя будет переопределить в наследниках
        System.out.println("Ssd: " + ssd.getValue() + ", ram: " + ram.getValue());
    }

    public Ssd getSsd() { // чтобы иметь доступ к приватному полю извне класса
        return ssd;
    }

    public Ram getRam() {
        return ram;
    }
}
