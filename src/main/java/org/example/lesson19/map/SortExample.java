package org.example.lesson19.map;

import org.example.lesson19.person.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {

    public static void main(String[] args) {
        // List.of() возвращает неизменяемую коллекцию
//        List<String> strings = Arrays.asList("123", "345", "14", "678");
//
//        Collections.sort(strings);
//        System.out.println(strings);

        List<Person> personList = Arrays.asList(
                new Person(1, "Ivan", "Ivanov"),
                new Person(29, "Petr", "Petrov"),
                new Person(3, "Sveta", "Svetikova")
        );
        Collections.sort(personList);
        System.out.println(personList);

//        Collections.sort(personList, new FirstNameComparator());
//        personList.sort(new FirstNameComparator());
        personList.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
        System.out.println(personList);
    }

    public static class FirstNameComparator implements Comparator<Person> {

        @Override // сортировака FirstName в алфовитном порядке
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    };
}
// сортировка - упорядочивание элементов коллекции по заданным нами критериями
// сортировка элементов 2 варианта:
// 1. реализовав интерфейс Comparable ( только в одном единств порядке. этот порядок будет по умолчанию,
// который будет использоваться без передачи Comparator соответсвующего )
// 2. создать свой Comparator, реализовав необходимый интерфейс Comparator ( при сортировке коллекции можно
// передавать дополнительный Comparator, по которому будем сортировать либо возспользоваться статическими методами
// из интерфейса Comparator)