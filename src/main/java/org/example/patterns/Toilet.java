package org.example.patterns;
// SINGLETON (Одиночка)
// Гарантирует, что у класса будет только один экземпляр, и предоставляет к нему глобальную точку доступа
public class Toilet {
    private static Toilet toilet;
    private boolean isOccupied = false;
    private String lastUser;

    private Toilet() {
        System.out.println("Купили новый унитаз!");
    }

    public static Toilet getInstance() { //getInstance() всегда возвращает один и тот же объект
        if (toilet == null) {
            toilet = new Toilet();
        }
        return toilet;
    }

    public void use(String person){
        if(isOccupied){
            System.out.println("Занято!");
            return;
        }
        isOccupied = true;
        lastUser = person;
        System.out.println(person + " занял туалет");
    }
    public void flush() {
        isOccupied = false;
        System.out.println("смывается!");
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public String getLastUser() {
        return lastUser;
    }

    public static void main(String[] args) {
        Toilet toilet1 = Toilet.getInstance();
        Toilet toilet2 = Toilet.getInstance();
        Toilet toilet3 = Toilet.getInstance();
        System.out.println("один унитаз на всех? " + (toilet1 == toilet2 && toilet2 == toilet3));

        toilet1.use("папаня");
        toilet2.use("мама");
        System.out.println("последний чел в туалете: " + toilet1.getLastUser());
        System.out.println("Занят? " + toilet1.isOccupied());
        toilet1.flush();
        System.out.println("все еще занят?! " + toilet1.isOccupied());

        toilet2.use("мама");
        System.out.println("последний чел в туалете: " + toilet2.getLastUser());
        System.out.println("Занят? " + toilet2.isOccupied());
        toilet1.flush();
        System.out.println("все еще занят?! " + toilet2.isOccupied());

        toilet3.use("микро челик");
        System.out.println("последний чел в туалете: " + toilet3.getLastUser());
        System.out.println("Занят? " + toilet3.isOccupied());
        toilet1.flush();
        System.out.println("все еще занят?! " + toilet3.isOccupied());
    }
}
