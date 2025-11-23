package org.example.iterator;

import org.example.lesson18.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new List<>(10);
        list.add("String 1");
        list.add("String 2");
        list.add("String 3");
        list.add("String 4");

//        for (String value : list){
//            System.out.println(value);
//        }
        list.iterator().forEachRemaining(System.out::println); // то же, что на стр выше
    }
}
