package org.example.lesson11;

import java.util.Random;

public interface Printable {

    String SOME_VALUE = "EXAMPLE";
    Random RANDOM = new Random();

    default void printWithRandom(){
        System.out.println(generateRandom());

        print();
    }

    void print();

    private int generateRandom(){
        return RANDOM.nextInt();
    }


}
// интерфейс называется как действие