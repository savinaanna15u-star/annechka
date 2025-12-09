package org.example.lesson25;

public class SimpleRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hello from runnable: " + Thread.currentThread().getName());
    }
}
