package org.example.lesson25;

import java.util.ArrayList;
import java.util.List;

public class Example {

    private List<Integer> list;

    public Example(List<Integer> list) {
//        this.list = list;
        this.list = List.copyOf(list);
    }

    public synchronized List<Integer> getList() {
        return list;
//        return new ArrayList<>(list);
    }
}
// если объект локальная переменная - безопасная в многопоточности
// если необходимо передать объект в другой поток, то:
// 1. не создавать полей (т.е. будет утилитный класс с множеством методов)
// 2. сделать класс immutаble (все поля private final)
// 3. сделать read only поля(не предоставляем методов, которые изменяют состояние объекта, а методы для чтения нельзя было изменить состояние извне через ссылку)
// 4. синхронизировать каждый метод
