package org.example.zad6;

public class t4 {
    public static void main(String[] args) {
        int x = 7;
        boolean result = isSimple(x);
        System.out.println(result);
    }

    public static boolean isSimple(int x) {
        boolean result = true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
               return false;
            }
        }

        return  true;
    }
}
