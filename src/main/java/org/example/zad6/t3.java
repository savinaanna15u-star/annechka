package org.example.zad6;

public class t3 {
    public static void main(String[] args) {
        double x = 24;
        double result = sum(x);
        System.out.println(result);
    }

    // x - исходная сумма
    // i - год
    public static double sum(double x) {
        double result = x;
        for (int i = 1626 + 1; i < 2025; i++) {
            double per = result * 0.05;
            result += result;
            System.out.println(i + " :" + result);
        }
        return result;
    }
}
