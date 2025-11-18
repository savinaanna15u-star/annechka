package org.example.exceptions_in_java.generics;

public class Main {
    public static void main(String[] args) {
        Box <String> boxString = new Box<>();
        boxString.setElement("Элемент");
        System.out.println(boxString.getElement());
        Box <Integer> boxInteger = new Box<>();
        boxInteger.setElement(10);
        System.out.println(boxInteger.getElement());

        Box<Book> boxWithBooks = new Box<>();
        boxWithBooks.setElement((new Book("Книга")));
    }
}
