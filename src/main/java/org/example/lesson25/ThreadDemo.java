package org.example.lesson25;

public class ThreadDemo {

    public static void main(String[] args) {
        SimpleThread simpleThread = new SimpleThread(); // создаём новый поток, но пока не запускаем его
        simpleThread.start(); // создастся новый поток и в нем вызовет новый метод run()
        try {
            simpleThread.join(); // поток, вызвавший это метод, будет ждать до тех пор,пока объект, у которого был вызван этот метод,
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // не закончит свое выполнение


        System.out.println(Thread.currentThread().getName());
    }
}


// с помощью .join() - регулируем очередность вызова потоков