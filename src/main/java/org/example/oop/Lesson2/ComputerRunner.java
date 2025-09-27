package org.example.oop.Lesson2;

public class ComputerRunner {
    public static void main(String[] args) {
        int x = 5;
        Computer computer = new Computer(); // new создание нового объекта
        computer.load();
        System.out.println("Ram: " + computer.ram);
        System.out.println("SSD: " + computer.ssd);
    }
}
