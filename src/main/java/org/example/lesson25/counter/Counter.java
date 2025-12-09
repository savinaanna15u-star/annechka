package org.example.lesson25.counter;

/**
 * 1. Создать класс Counter с одним полем:
 * private int count;
 * <p>
 * Добавить методы:
 * - getCount() - для получение поля count
 * - increment() - для увеличения значения поля на единицу
 * - decrement() - для уменьшения значения поля на единицу
 */

public class Counter {

    private static String description;
    private int count;

    public static void init() {
        Class<Counter> counterClass = Counter.class;
        synchronized (counterClass) {
            if (description == null) {
                description = "Test description";
            }
        }
    }


    public void increment() {   // вариант 1: синхронизация блока
        synchronized (this) { // захватываем монитор КОНКРЕТНОГО объекта Counter
            count++;  // пока монитор захвачен, другие потоки не могут войти в synchronized блок для этого объекта
        }
    }

    public synchronized void decrement() { // вариант 2: синхронизация всего метода
        count--;
    }

    public int getCount() {
        return count;
    }
}

// synchronized захватывает монитор одного конкретного объекта, а не всех сразу
// synchronized помогает сделать операции над разделяемым состоянием атомарными:
// весь synchronized-блок/метод выполняется только в одном потоке в один момент времени

// необходимо захватить монитор того объекта, состояние которого мы изменяем
// в многопоточной среде при отсутствии synchronized чтение может увидеть не самое новое значение