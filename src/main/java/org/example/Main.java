package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int year = 2004;
        isLeapYear(year);
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        //       if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
        //         return true;
        //   } else {
        //     return false;
    }
}
