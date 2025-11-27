package org.example.cars;

import org.example.lesson11.Printable;

public class Main {
    public static void main(String[] args) {

        Car lexus = new Lexus("LX", "500", 50d, 40, new MegaEngine()); // полиморфизм
        Car lada = new Lada("Granta", "sport", 10d, 20, new SuperEngine()); // полиморфизм
        lexus.start();
        lexus.drive();
        Service service = new Service("У Митяя");
        service.apply(lexus);
        service.apply(lada);
        lexus.printCountryOfOrigin();
        lexus.information();
        lada.information();
    }
    public static void drive(Drivable ... objects){
        for (Drivable object : objects) {
            object.drive();
            System.out.println();
        }
    }

//почему мы передаем переменную лада в кач аргум в метод apply?
        //В метод apply(Car car) передаётся объект машины (Car или его потомок, например, Lada).
        //Мы передаём переменную lada в метод apply, чтобы сервис мог работать с данным экземпляром машины,
        // получить о ней всю информацию, рассчитать стоимость и вывести результат.
    }
