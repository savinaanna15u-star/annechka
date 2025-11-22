package org.example.lesson_19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListRunner {

    //  [1,2,3,4,5]
    //  [1,2,3,4,5, null, null]
    //  [1,2,3,4,5, 6, null]
    public static void main(String[] args) {
       // List<Integer> integers = new ArrayList<>(5); // в качестве ссылок используем интерфейсы (не ArrayList, а List)
        List<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);

        System.out.println(integers);
        System.out.println(integers.get(5)); // по индексу вывели элемент
        System.out.println(integers.contains(4));

    }
}

// LinkedList насследует очередь (через интерфейсы Queue и Deque)
//
//Node<E>:
//E item (значение, которое хранится)
// Node<E> next (ссылка на следующий элемент)
// Node<E> prev (ссылка на предыдущий элемент)
