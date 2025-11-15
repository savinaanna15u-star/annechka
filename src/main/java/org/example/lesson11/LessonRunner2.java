package org.example.lesson11;

public class LessonRunner2 {
    public static void main(String[] args) {
        Printable laptop = new Laptop(new Ssd(250), new Ram(1024), 2);
        Printable mobile = new Mobile(new Ssd(125), new Ram(512));
        print(laptop, mobile);

    }
    public static void print(Printable ... objects) { // Varargs ([тип] ... имя) — это стандартный способ в Java создавать методы, которые принимают произвольное количество аргументов одного типа.
        for (Printable object : objects) {
            object.print();
            System.out.println();
        }
    }
}
// интерфейсы мы используем, когда хотим превнести какой то функционал в наш класс
// один класс может реализовать много интерфейсов
// нет возможности создавать какие то поля, кроме как констант ((public static final поля)
// и абстрактные методы (public abstract, но модификаторы можно не писать — они добавляются по умолчанию))