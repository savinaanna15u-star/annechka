package org.example.lesson27;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
        String phoneNumber = "+375 (33) 898-33-13 fduglfjhvb kgdfluig +375 (44) 777-12-13" +
                "fygtzfsd +375 (29) 657-13-29 kfjgf +375 (25) 111-11-11 gfh";
        String regex = "(?:\\+375)? ?\\((?<code>\\d{2})\\) ?(\\d{3})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            String gr1 = matcher.group(2);
            String gr2 = matcher.group(3);
            String gr3 = matcher.group(4);
            matcher.appendReplacement(stringBuilder,"$2 $3 $4"); // $ ссылается на группу
            //appendReplacement заменяет найденное совпадение на шаблон с $n и дописывает в StringBuilder
//            matcher.appendReplacement(stringBuilder,gr1 + " " + gr2 + " " + gr3);
        }
        matcher.appendTail(stringBuilder); // appendTail дописывает остаток исходной строки после всех замен

        System.out.println(stringBuilder);
        System.out.println(phoneNumber.replaceAll(regex,"$2 - $3 - $4 |"));


//        while (matcher.find()) { //  find() ищет следующее совпадение с шаблоном в строке
//            System.out.println(matcher.group()); // вся найденная подстрока (то же, что group(0))
//            System.out.println(matcher.group(0)); // полное совпадение целиком
//            System.out.println(matcher.group("code")); // значение  группы "code"
//        }
    }
}
// ?:(\+375) - результат не сохраняется как группа


//чтобы гибко заменять найденную подстроку, её разбивают на группы,
// а в строке замены с помощью $1, $2, $3 ссылаются на эти группы
// и вставляют их в нужном порядке и формате