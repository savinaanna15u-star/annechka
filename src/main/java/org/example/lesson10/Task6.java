package org.example.lesson10;

public class Task6 {

    public static void main(String[] args) {
//        [0, 1, 2, 3, 4]
//       [0, 1, 2, 3, 4, 5, 6, 7, 0, 0] динамический массив символов, который может расти по мере необходимости


        long startTime = System.currentTimeMillis();
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            value.append(i);
//            value += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time:" + (endTime - startTime));
    }
}
