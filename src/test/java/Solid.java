import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solid {
    @Test
    public void test() {
        assertEquals(1, 2);
    }

    // SRP (Single Responsibility Principle) - одна ответственность
    static class User1 {
        private String name;

        public void saveToDatabase() {
        }

        public void sendEmail() {
        }
    }

    @Test
    public void test2() {
        User1 user = new User1();
        user.saveToDatabase();
        user.sendEmail();
    }


    static class User2 {
        private String name; /* только данные */
    }

    class UserRepository {
        public void save(User2 user) { /* только сохранение */ }
    }

    class EmailService {
        public void sendEmail(User2 user) { /* только email */ }
    }

    @Test
    public void test3() {
        User2 user = new User2(); // Создаем данные
        UserRepository userRepository = new UserRepository(); // Сохраняем (только БД)
        userRepository.save(user);
        EmailService emailService = new EmailService(); // Отправляем (только Email)
        emailService.sendEmail(user);
    }

    // OCP (Open/Closed Principle) - Принцип открытости/закрытости
    static class PaymentProcessor {
        public void process(String type) {
            if (type.equals("card")) { /* карта */ } else if (type.equals("paypal")) { /* paypal */ } else if (type.equals("crypto")) { /* крипта */ }
        }
    }

    @Test
    public void test4() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.process("card");
        paymentProcessor.process("paypal");
        paymentProcessor.process("crypto");
    }


    interface PaymentMethod {
        void process();
    }

    static class CardPayment implements PaymentMethod {
        public void process() { /* карта */ }
    }

    class PayPalPayment implements PaymentMethod {
        public void process() { /* paypal */ }
    }

    class PaymentProcessor1 {
        public void process(PaymentMethod method) {
            method.process(); // Новый метод → просто implements!
        }
    }

    @Test
    public void test5() {
        PaymentProcessor1 processor = new PaymentProcessor1();
        processor.process(new CardPayment());
        processor.process(new PayPalPayment());
    }

    // LSP = наследник должен работать ТАК ЖЕ, как родитель
//    static class Bird {
//        void fly() {
//        }
//    }// Penguin НЕ может летать (нарушает LSP!)
//
//    static class Penguin extends Bird {
//        void fly() {
//            throw new Exception("Penguin can't fly");
//        }
//    }
//
//    @Test
//    public void test6() {
//        List<Bird> birds = Arrays.asList(new Bird(), new Penguin());
//        for (Bird bird : birds) {
//            bird.fly();
//        }
//    }

    interface Flyable {
        void fly();
    }                    //  ТОЛЬКО летающие

    static class Sparrow implements Flyable {
        public void fly() {
        }
    }   //  Летает

    static class Penguin1 { /* не implements Flyable */
    }        //  НЕ летает = другой интерфейс

    void makeFlyersFly(List<Flyable> flyers) {
        for (Flyable flyer : flyers) {
            flyer.fly();  //  Все летают!
        }
    }

    @Test
    public void test7() {
        List<Flyable> flyers = Arrays.asList(new Sparrow());
        for (Flyable flyer : flyers) {
            flyer.fly();
        }
        Penguin1 penguin = new Penguin1();
    }

    // ISP (Interface Segregation) — разделение интерфейсов
    interface Worker {
        void work();

        void eat();

        void sleep();
    }

    static class Human implements Worker {
        @Override
        public void work() {
            System.out.println("Human works");
        }
        @Override
        public void eat() {
            System.out.println("Human eats");
        }

        @Override
        public void sleep() {
            System.out.println("Human sleeps");
        }
    }
    static class Robot implements Worker {
        @Override
        public void work() {
            System.out.println("Robot works");
        }
        @Override
        public void eat() {
            System.out.println();
        }

        @Override
        public void sleep() {
            System.out.println();
        }
    }

    @Test
    public void test8() {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Human());
        workers.add(new Robot ());
        assertEquals(2, workers.size());
        workers.forEach(Worker::work);
    }


    interface Workable {
        void work();
    }
    interface Eatable {
        void eat();
    }
    interface Sleppable {
        void sleep();
    }

    static class Human1 implements Workable, Eatable, Sleppable{
        @Override
        public void work() {
            System.out.println("Human works");
        }
        @Override
        public void eat() {
            System.out.println("Human eats");
        }

        @Override
        public void sleep() {
            System.out.println("Human sleeps");
        }
    }
    static class Robot1 implements Workable {
        @Override
        public void work() {
            System.out.println("Robot works");
        }
    }
    @Test
    public void test9() {
        List<Workable> workers = new ArrayList<>();
        workers.add(new Human1());
        workers.add(new Robot1 ());
        assertEquals(2, workers.size());
        workers.forEach(Workable::work);
    }


    //  DIP (Dependency Inversion) — инверсия зависимостей
    interface Bulb {
        void turnOn();
    }

    static class IncandescentBulb implements Bulb {
        public void turnOn() {
            System.out.println("светит");
        }
    }

    // плохой
    static class Lamp {
        Bulb bulb = new IncandescentBulb(); // жесткая зависимость
        void turnOn() {
            bulb.turnOn();
        }
    }
    @Test
    public void test10(){
        Lamp lamp = new Lamp();
        lamp.turnOn();
    }

    // хороший
    static class Lamp1 implements Bulb {
        Bulb bulb; // любой тип лампочки
        Lamp1(Bulb bulb) {
            this.bulb = bulb;
        }

        @Override
        public void turnOn() {
            bulb.turnOn();
        }
    }
    @Test
    public void test11(){
        Lamp1 lamp = new Lamp1(new IncandescentBulb());
        lamp.turnOn();
    }
}

