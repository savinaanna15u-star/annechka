package org.example.lesson27.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 2. Написать программу, выполняющую поиск в строке
 * шестнадцатеричных чисел, записанных по правилам Java,
 * с помощью регулярных выражений и выводящую их на страницу.
 */
public class Task2 {

    public static void main(String[] args) {
//        int value = 0xf; // 16теричное число
        String regex = "0[xX][0-9a-fA-F]+";
        String input = "gfguy 0xff ygtyut 0X12 jfgv 0XAB hglf yth 1xAA";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
