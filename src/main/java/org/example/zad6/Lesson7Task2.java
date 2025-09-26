package org.example.zad6;

public class Lesson7Task2 {
    public static void main(String[] args) {
        int[] x = new int[100];
        fillArray(x);
        Lesson7Task1.printArray(x);
    }

    public static void fillArray(int[] x) {
        int z = 0;
        for (int x1 = 1; z < x.length; x1++)
            if (x1 % 13 == 0 || x1 % 17 == 0) {
                x[z] = x1;
                z++;
            }
    }
}
