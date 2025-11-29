package org.example.lesson19.set_example;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        new HashSet<>();
        new LinkedHashSet<>();
        Set<String> set = new TreeSet<>();
        System.out.println(set.add("ddd"));
        System.out.println(set.add("aaa"));
        System.out.println(set.add("bbb"));
        System.out.println(set.add("ccc"));
        System.out.println(set.add("bbb"));

        System.out.println(set);
    }
}
// в set нет дубликатов
// HashSet - порядок элементов не сохраняется, реализует HashMap
// LinkedHashSet - сохраняет порядок добавления элементов, реализован на основе LinkedHashMap
// TreeSet - хранит элементы в отсортированном порядке согласно их естественному порядку или переданному Comparator
// TreeSet - реализован на основе TreeMap.
// сет нельзя отсортировать сам по себе, нельзя получить значение по индексу(нет метода  get(int index))
//обычные реализации Set (HashSet, LinkedHashSet) не сортируют элементы.
// для автоматически отсортированного множества используют TreeSe
