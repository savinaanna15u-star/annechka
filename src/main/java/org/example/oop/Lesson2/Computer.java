package org.example.oop.Lesson2;

public class Computer {

    private int ssd = 500;
    private int ram;

    Computer() { // объявлен констр
        System.out.println("Я был создан");
    }

    Computer(int newSsd) { //аргрумент метода в ()
        ssd = newSsd;
    }

    Computer(int newRam, int newSSD) {
        ram = newRam;
        ssd = newSSD;
    }

    /* Computer(String a) {
    //}
    //  Computer(boolean b) {
    //  }
       21 и 25 перегруз методов с одинак названием,
  */
    public void load() {
        System.out.println("Я загрузился");
    }

    public void printState() {
        System.out.println("Ssd: " + ssd);
        System.out.println("Ram: " + ram);
    }
}
