package org.example.lesson11;

public class oopLessonRunner3 {
    public static void main(String[] args) {
        Computer laptop = new Laptop(new Ssd(250), new Ram(1024), 2); // Laptop является Computer
//        laptop.load();
//
//        System.out.println();

        Computer mobile = new Mobile(new Ssd(125), new Ram(512)); // Mobile является Computer
//        mobile.load();
        loadComputers(laptop, mobile);
        printInformation(new Computer[] {laptop, mobile});
    }

    public static void printInformation(Computer[] computers){
        for (Computer computer : computers) {
            computer.print();

        }
    }

    public static void loadComputers (Computer ... computers){
        for (Computer computer : computers){
            computer.load();
            System.out.println();
        }
    }

}
// Mobile (тип ссылки) mobile = new Mobile (тип объекта)
// полиморфизм - один интерфейс и множество реализаций
