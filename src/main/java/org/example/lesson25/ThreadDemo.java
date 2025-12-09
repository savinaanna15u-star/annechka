package org.example.lesson25;

public class ThreadDemo {

    public static void main(String[] args) {
        var simpleThread = new SimpleThread(); // создаём новый поток, но пока не запускаем его
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState()); // getState() – показывает текущее состояние потока (NEW, RUNNABLE, TERMINATED и тд)
        var runnableThread = new Thread(new SimpleRunnable(), "My name");
        var lambdaThread = new Thread(() -> System.out.println("hello from lambda: " + Thread.currentThread().getName()));

        simpleThread.start(); // создастся новый поток и в нем вызовет новый метод run()
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());

        runnableThread.start();
        lambdaThread.start();
        try {
            simpleThread.join(100L); // join() используется, чтобы один поток дождался завершения другого
            System.out.println(simpleThread.getName() + ": " + simpleThread.getState());

            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}


// с помощью .join() - текущий поток (main) ждёт завершения других потоков
// var - удобно, когда тип длинный, но тип всё равно выводится компилятором и фиксирован
// если используются интерфейсы, а не классы - больше гипкости
// getState() – показывает текущее состояние потока (NEW, RUNNABLE, TERMINATED и тд)