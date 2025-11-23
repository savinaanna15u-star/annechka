package org.example.lesson19_person;

public class PersonExample {

    public static void main(String[] args) {
        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person petr = new Person(1, "Ivan", "Ivanov");
//        Person petr = new Person(2, "Petr", "Petrov");


        System.out.println(ivan.hashCode());
        System.out.println(petr.hashCode());
        System.out.println(ivan.equals(petr)); // переопределили метод equals(), и теперь проверяет не ссылки, а значения
    }
}

// контракт метода equals:
//1. рефлективность а = а
//2. симметричность
//3. транзитивность а = б, б = с, а = с
//4. повторяемость

// hashCode
// 1. у двух одинаковых объектов, должен быть одинаковый хеш код
// 2. у двух разных объектов, могут быть одинаковый хеш код
// нельзя возвращать константу или рандомное число
