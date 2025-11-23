package org.example.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<Integer> sourceList = List.of(1,2,3,4,5,6); // неизменяемая коллекция
        List<Integer> list = new ArrayList<>(sourceList);

//        for (int i = 0; i < list.size(); i++){
//            Integer integer = list.get(i);
//        }
        for (Integer integer : list){
            System.out.println(integer);
        }
        for (Integer integer : list){
            System.out.println(integer);
        }
        list.forEach(System.out::println);
//        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) { //Если реализовать в своём классе интерфейс Iterable,
//            // то можно перебрать его элементы через for-each, а для этого внутри нужно реализовать итератор через интерфейс Iterator
//            Integer next = iterator.next();
//            System.out.println(next);
//            if (next == 3 || next ==4){
//                iterator.remove();
//            }
//        }
//        System.out.println(list);
// через цикл foreach нельзя удалить элемнеты
// foreach только на чтение

//вызывая метод hasNext() - смотрим, есть ли элемент
// вызывая метод next() - передвигаем курсор

//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
    }
}
