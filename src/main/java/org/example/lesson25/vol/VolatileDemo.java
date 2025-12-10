package org.example.lesson25.vol;

public class VolatileDemo {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("still false");
            }

        });
        thread1.start();

        Thread.sleep(5L);

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("flag is set");
        });
        thread2.start();
    }
}

// volatile - только для примитивных типов и ссылок, содержимое не определить, только изменялось поле или нет
// Volatile обеспечивает видимость изменений между потоками, но не атомарность и не взаимное исключение
// без volatile первый поток может бесконечно крутиться в while(!flag), видя устаревшее значение из своего кэша.
