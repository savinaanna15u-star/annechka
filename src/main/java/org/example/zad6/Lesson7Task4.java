package org.example.zad6;

public class Lesson7Task4 {
    public static void main(String[] args) {
//                 0  1  2  3  4  5  6   7
        int[] x = {1, 2, 10, 5, 7, 4, 0, 3};
        System.out.println("min index: " + findMinIndex(x));
        System.out.println("max index: " + findMaxIndex(x));

        System.out.println(calculateSumBetween(x));
    }

public static int calculateSumBetween(int[] x){
       int minIndex = findMinIndex(x);
       int maxIndex = findMaxIndex(x);
       if (minIndex > maxIndex){
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
       }
       int result = 0;
       for (int i = minIndex +1; i < maxIndex; i++) {
           result += x[i];
       }
       return result;
}

    public static int findMinIndex(int[] x) {
        int minIndex = 0;
        int minX = x[minIndex];
        for (int i = 0; i < x.length; i++) {
            if (minX > x[i]) {
                minX = x[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findMaxIndex(int[] x) {
        int maxIndex = 0;
        int maxX = x[maxIndex];
        for (int i = 0; i < x.length; i++) {
            if (maxX < x[i]) {
                maxX = x[i];
                maxIndex = i;

            }
        }
        return maxIndex;
    }
}
