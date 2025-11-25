package org.example.lesson19.map;

import org.example.lesson19.person.Person;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person petr = new Person(29, "Petr", "Petrov");
        Person sveta = new Person(3, "Sveta", "Svetikova");

        Map<Integer,Person> map = new LinkedHashMap<>();

        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.putIfAbsent(sveta.getId(), sveta);

        for (Map.Entry<Integer, Person> enrty : map.entrySet()) {
            System.out.println(enrty.getKey() + " " + enrty.getValue());
        }
    }
}

// с LinkedHashMap элементы в том порядке, в котором мы их добавили в Map