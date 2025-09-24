package org.example.zad6;

public class t2 {
    public static void main(String[] args) {
        int x = 12345;
        int result = sum(x);
        System.out.println(result);

        int result2 = sumF(x);
        System.out.println(result2);
    }

    public static int sum(int x) {
        int result = 0;
        int y = x;
        while (y != 0) {
            result += y % 10;
            y /= 10;
        }
        return result;
    }
    public static int sumF(int x) {
        int result = 0;
        for (int y=x; y!=0; y/=10) {
            result += y % 10;
        }
        return result;
    }
}
