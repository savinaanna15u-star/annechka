package org.example.zad6;

public class Lesson7Task3 {

    public static void main(String[] args) {
        int[][] x1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };
        int[][] x2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8}

        };
        //   boolean result = equals(x1, x2);
        System.out.println(equals(x1, x2));
    }

    public static boolean equals(int[][] x1, int[][] x2) {
        if (x1.length != x2.length) {
            return false;
        }
        for (int i = 0; i < x1.length; i++) {
            int[] row1 = x1[i];
            int[] row2 = x2[i];
            if (row1.length != row2.length) {
                return false;
            }
            for (int j = 0; j < row1.length; j++) {
                if (row1[j] != row2[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
