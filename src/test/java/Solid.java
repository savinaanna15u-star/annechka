import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Solid {
    @Test
    public void test() {
        assertEquals(1, 2);
    }

    // SRP (Single Responsibility Principle) - одна ответственность
    // плохой
    static class User1 {
        private String name;

        public boolean  saveToDatabase() {
            return true;
        }

        public boolean sendEmail() {
            return true;
        }
    }

    @Test
    public void test2() {
        User1 user = new User1();
        assertTrue(user.saveToDatabase());
        assertTrue(user.sendEmail());
    }

    //хороший
    static class User2 {
        private Long id;
        private String name;
        private String  email;

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public User2(String email) {
            this.email = email;
        }
    }

    class UserRepository {
        private final List<User2> users = new ArrayList<>();
        public void save(User2 user) {
            if (user.getId() == 2) {
                throw new RuntimeException("user not found");
            }
            users.add(user);
        }
        public List<User2> getAllUsers() {
            return new ArrayList<>(users);
        }

        public boolean deleteUserById(Long id) {
            return users.removeIf(user -> user.getId().equals(id));
        }
    }

    class EmailService {
        private final List<String> emails = new ArrayList<>();
        public boolean sendEmail (User2 user) {
            if ("kroshka.kartoshka@.com".equals(user.getEmail())) {
                throw new RuntimeException("email not sent");
            }
            emails.add(user.getEmail());
            return true;
        }
        public List<String> getAllSentEmails() {
            return new ArrayList<>(emails);
        }
    }

    @Test
    void test3() {
        UserRepository userRepo = new UserRepository();
        EmailService emailService = new EmailService();
        User2 user2 = new User2("kroshka.kartoshka@.com");
        user2.setId(2L);

        try {
            userRepo.save(user2);
            Assertions.fail("User shouldn't be created");
        } catch (RuntimeException e) {
            Assertions.assertEquals("user not found", e.getMessage());
        }

        try {
            emailService.sendEmail(user2);
            Assertions.fail("Email shouldn't be sent");
        } catch (RuntimeException e) {
            Assertions.assertEquals("email not sent", e.getMessage());
        }
    }


    // OCP (Open/Closed Principle) - Принцип открытости/закрытости
    //плохой
    static class PaymentProcessor {
        private List<String> processed = new ArrayList<>();

        public String process(String type) {
            if (type.equals("card")) {
                processed.add("card");
                return "card payment";
            }
            else if (type.equals("paypal")) {
                processed.add("paypal");
                return "paypal payment";
            }
            else if (type.equals("crypto")) {
                processed.add("crypto");
                return "crypto payment";
            }
            return null;
        }
        public List<String> getAllProcessed() {
            return new ArrayList<>(processed);
        }
    }

    @Test
    public void test4() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        assertEquals("card payment", paymentProcessor.process("card"));
        assertEquals("paypal payment", paymentProcessor.process("paypal"));
        assertEquals("crypto payment", paymentProcessor.process("crypto"));

        List<String> processed = paymentProcessor.getAllProcessed();
        assertEquals(3, processed.size());
        assertTrue(processed.contains("card"));
        assertTrue(processed.contains("paypal"));
        assertTrue(processed.contains("crypto"));
    }

//хороший
    interface PaymentMethod {
        String process();// чтобы возвращал какой то стринг
    }

    static class CardPayment implements PaymentMethod {
        @Override
        public String process() {
            return "card";
        }
    }

    class PayPalPayment implements PaymentMethod {
        @Override
        public String process() {
            return "paypal";
        }
    }
    class CryptoPayment implements PaymentMethod {
        @Override
        public String process() {
            return "crypto";
        }
    }

    class PaymentProcessor1 {
        private List<String> processed = new ArrayList<>();
        public void process(PaymentMethod method) {
            String result = method.process();
            processed.add(result);
        }
        public List<String> getAllProcessed() {
            return new ArrayList<>(processed);
        }
    }

    @Test
    public void test5() {
        PaymentProcessor1 processor = new PaymentProcessor1();
        processor.process(new CardPayment());
        processor.process(new PayPalPayment());
        processor.process(new CryptoPayment());

        List <String> processed = processor.getAllProcessed();
        assertEquals(3, processed.size());
        assertTrue(processed.contains("card"));
        assertTrue(processed.contains("paypal"));
        assertTrue(processed.contains("crypto"));
    }

    // LSP = наследник должен работать ТАК ЖЕ, как родитель
    //плохой
    static class Bird {
        void fly() {
            System.out.println("birds fly");
        }
    }// Penguin НЕ может летать (нарушает LSP)

    static class Penguin extends Bird {
        void fly() {
            throw new RuntimeException("Penguin can't fly");
        }
    }

    @Test
    public void test6() {
        List<Bird> birds = Arrays.asList(new Bird(), new Penguin());
        birds.get(0).fly();
        assertThrows(RuntimeException.class, () -> birds.get(1).fly());
        assertTrue(birds.get(1) instanceof Bird);
        assertTrue(birds.get(1) instanceof Penguin);
    }

// хороший
    interface Flyable {
        void fly();
    }                    //  ТОЛЬКО летающие

    static class Sparrow implements Flyable {
        @Override
        public void fly() {
            System.out.println("sparrow fly");
        }
    }

    static class Penguin1 { /* не implements Flyable */
    }        //  НЕ летает = другой интерфейс

    static class FlyServise{
        private final List<Flyable> flyers = new ArrayList<>();
        public void AddFlyers(Flyable flyer){
            flyers.add(flyer);
        }
        public void makeFlyersFly() {
            for (Flyable flyer : flyers) {
                flyer.fly();
            }
        }
        public int getFlyersCount() {
            return flyers.size();
        }
    }

    @Test
    public void test7() { // проасертить что все летающие полетели
        FlyServise flyServise = new FlyServise();
        flyServise.AddFlyers(new Sparrow());
        flyServise.makeFlyersFly();

        assertEquals(1, flyServise.getFlyersCount());
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
    interface Sleepable {
        void sleep();
    }

    static class Human1 implements Workable, Eatable, Sleepable{
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
    public void test9() { // здесь нужно протеcтить код
        List<Workable> workers = new ArrayList<>();
        workers.add(new Human1());
        workers.add(new Robot1 ());
        assertEquals(2, workers.size());
        workers.forEach(Workable::work);

        List<Eatable> eatables = new ArrayList<>();
        eatables.add(new Human1());
        assertEquals(1, eatables.size());
        eatables.forEach(Eatable::eat);
        List<Sleepable> sleppables = new ArrayList<>();
        sleppables.add(new Human1());
        assertEquals(1, sleppables.size());
        sleppables.forEach(Sleepable::sleep);
    }


    //  DIP (Dependency Inversion) — инверсия зависимостей
    interface Bulb {
        String  turnOn();
    }

    static class IncandescentBulb implements Bulb {
        @Override
        public String turnOn() {
            return  "IncandescentBulb светит";
        }
    }
    // плохой
    static class Lamp {
        private Bulb bulb = new IncandescentBulb(); // жесткая зависимость
        String turnOn() {
            return bulb.turnOn();
        }
    }
    @Test
    public void test10(){
        Lamp lamp = new Lamp();
        String result = lamp.turnOn();
        assertEquals("IncandescentBulb светит", result);
        assertTrue(result.contains("IncandescentBulb"));
    }

    // хороший
    static class Lamp1 {
        private Bulb bulb;// любой тип лампочки

        public Lamp1(Bulb bulb) {
            this.bulb = bulb;
        }
        public String turnOn(){
            return bulb.turnOn();
        }
    }
    @Test
    public void test11(){
        Lamp1 lamp1 = new Lamp1(new IncandescentBulb());
        assertEquals("IncandescentBulb светит",  lamp1.turnOn());
        class LEDBulb implements Bulb{
            public String turnOn() {
                return "LEDBulb светит";
            }
        }
        Lamp1 lamp2 = new Lamp1(new LEDBulb());
        assertEquals("LEDBulb светит",  lamp2.turnOn());
    }
}

