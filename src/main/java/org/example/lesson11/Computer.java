package org.example.lesson11;

public class Computer {

    private Ssd ssd; // инкапсуляция - скрытие данных и сложности от пользователя(чел, который работает с классом)
    private Ram ram;


    public Computer(Ssd ssd, Ram ram) {
        this.ssd = ssd;
        this.ram = ram;
    }

    public void load(){
        System.out.println("Я загрузился");
    }
}
