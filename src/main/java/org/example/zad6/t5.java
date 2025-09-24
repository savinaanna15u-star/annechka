package org.example.zad6;

public class t5 {

    public static void main(String[] args) {
        printLetters();
        char x = 'd';
        System.out.println((int)x);
    }

    public static void printLetters() {
        for (char l = 'b'; !isVowel(l); l++) {
            System.out.println(l);
        }
    }

    public static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' || x == 'y';
    }
}
