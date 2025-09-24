package org.example;

public class kak6for {
    public static void main(String[] args) {
        for (int x = 10; x > 0; x--) {

            if (x == 5) {
                //continue;
                 break;
            }
            System.out.println(x);
        }

    }

    private static void forEx() {
        int i = 0;
        for (; ; ) {
            System.out.println(i);
        }
        //       for (int x = 10; x > 0; x--) {
        //         System.out.println(x);
        //}
    }
}
