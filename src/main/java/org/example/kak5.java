package org.example;

public class kak5 {
    public static void main(String[] args) {
        int x1 = 50;
        int x2 = 10;
        int result = getMax(x1,x2);
        System.out.println(result);
    }

    public static int getMax(int xx1, int xx2) {
        if (xx1 > xx2) {
            return xx1;
        } else {
            return xx2;
        }
    }
}
