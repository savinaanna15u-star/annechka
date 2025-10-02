package org.example.zad6;

public class Lesson7and1 {
    public static void main(String[] args) {
        int[][] x = new int[3][];
        x[0] = new int[5];
        x[1] = new int[2];
        x[2] = new int[1];
        printArray(x);
    }

    private static void test() {
        int[] x = {1, 2, 3, 4, 5};
        int[][] x1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printArray(x1);
    }

    private static void printArray(int[][] x1) {
        for (int i = 0; i < x1.length; i++) {
            int[] ints = x1[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
