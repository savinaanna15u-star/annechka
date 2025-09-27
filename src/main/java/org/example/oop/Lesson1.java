package org.example.oop;

public class Lesson1 {

    public static void main(String[] args) {
     int x = 10;
     int [] x1 = {x, 100, 199, 25};
     printArray(x1);
    }

    private static void printArray(int[] x1) {
        for (int x : x1) {
            System.out.println(x);
        }
    }
}
