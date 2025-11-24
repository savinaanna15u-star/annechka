package org.example.lesson19.person.map;

import org.example.lesson19.person.Person;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person petr = new Person(2, "Petr", "Petrov");
        Person sveta = new Person(1, "Sveta", "Svetikova");

        Map<Integer,Person> map = new HashMap<>();
        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.putIfAbsent(sveta.getId(), sveta); // если есть такой ключ, то старое значение остается

        System.out.println(map.get(2));

        System.out.println(map.keySet()); // все ключи
        System.out.println(map.values()); // все значения
        System.out.println(map.entrySet()); // объект типа Node, у к-рого есть и ключ и значение

        for (Person person : map.values()){
            System.out.println(person.getFirstName());
        }
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        System.out.println(map.containsKey(4));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.getOrDefault(6, sveta));
    }
}
// уникальность ключа - главное требование Map!
// map не является коллекцией, но содержит другие коллекции: множество ключей и коллекцию значений
// Node <K,V>  реализует интерфейс Entry<K,V>