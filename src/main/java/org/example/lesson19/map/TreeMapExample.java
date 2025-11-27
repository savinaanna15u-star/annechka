package org.example.lesson19.map;

import org.example.lesson19.person.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person petr = new Person(29, "Petr", "Petrov");
        Person sveta = new Person(3, "Sveta", "Svetikova");
        Person sveta1 = new Person(30, "Sveta1", "Svetikova1");
        Person sveta2 = new Person(45, "Sveta2", "Svetikova2");
        Person sveta3 = new Person(10, "Sveta3", "Svetikova3");

        Map<Integer, Person> map = new TreeMap<>(); // TreeMap автоматически сортирует объекты по ключу, так же принимает comparator
        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.putIfAbsent(sveta.getId(), sveta);
        map.putIfAbsent(sveta1.getId(), sveta1);
        map.putIfAbsent(sveta2.getId(), sveta2);
        map.putIfAbsent(sveta3.getId(), sveta3);

        for (Map.Entry<Integer, Person> entry : map.entrySet())  { // map.entrySet() возвращает набор элементов типа Map.Entry<K,V>.
            //Каждый Map.Entry — это одна пара "ключ–значение" из  TreeMap.
            // Это означает: "для каждой пары (entry) в наборе пар карты map".
            // Map.Entry — это “внутренний” интерфейс, который представляет одну пару ключ–значение внутри Map.
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
// бинарные деревья - каждыц узел может иметь макс содержит 2 потомка
// TreeMap использует Red-black tree, есть корень (root)
// 15 <- 20 -> 30
// балансировка дерева - его перестроение, выбирается root

// У Map.Entry есть методы:
//
//- getKey() — получить ключ.
//
//- getValue() — получить значение.
//
//- setValue(...) — поменять значение (если Map изменяемая).