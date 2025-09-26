package org.example.zad6;

public class Lesson7Task1 {
    public static void main(String[] args) {
        int[] x = {1, 5, 7, 9, 11};
        printArray(x);
        printArrayForeach(x);
        printArrayRevers(x);
    }

    public static void printArrayRevers(int[] x) {
        for (int i = x.length - 1; i >= 0; i--) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }


    public static void printArrayForeach(int[] x) {
        for (int x1 : x) {
            System.out.print(x1 + " ");
        }

        System.out.println();
    }
}
