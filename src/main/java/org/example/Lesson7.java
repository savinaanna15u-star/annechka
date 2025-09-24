package org.example;

public class Lesson7 {
    public static void main(String[] args) {
        int[] x = new int[10];
     //   System.out.println(x[5]);
            x[4] = 7;
            x[7] = 4;
        for (int i = 0; i < x.length; i++) {
            System.out.println(i + ": " + x[i]);
        }
    }

    private static void test() {
        //          0  1  2  3  4
        int[] x = {1, 5, 6, 8, 9};
        System.out.println(x[2]);

        x[3] = 81;
        System.out.println(x[3]);
    }
}
