package org.example.zad6;

public class Rec {

    public static void main(String[] args) {
        int fact = fact(5);
        System.out.println(fact);
    }

    public static int fact(int xax) {
        if (xax == 1) {
            return 1;
        }
        return xax * fact(xax - 1);
    }
}
