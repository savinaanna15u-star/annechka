package org.example.lesson9;

import org.example.lesson7.Computer;

public class StaticRunner {

    public static void main(String[] args) {
        new Computer( null, null);
        new Computer( null, null);
        new Computer( null, null);
        Computer computer2 = new Computer( null, null);
        Computer computer = new Computer( null, null);
        System.out.println(Computer.getCouter());

        Class<? extends Computer> clazz = computer.getClass(); // метод возвращает класс, которому принадлежит
        Class<? extends Computer> clazz2 = computer2.getClass();
        System.out.println(clazz == clazz2); // результат сравнения двух ссылок
        System.out.println(computer == computer2);

    }
}
