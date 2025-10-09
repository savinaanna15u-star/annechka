package org.example.lesson10;
// заменить все грустные :( в строке на веселые :)
public class Task1 {
    public static void main(String[] args) {
        String value = " asdyt :( yfghf :( gfghfk :) jhtrrf :) kyutrffg :(";
        String result = replace(value);
        System.out.println(result);
    }

    public static String replace(String value) {
        return value.replace(":(", ":)");
    }
}
