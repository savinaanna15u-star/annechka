package org.example.lesson23;

import java.io.Serializable;

public class Person implements Serializable {
    // Serializable - интерфейс, который говорит, что мы можем сериализовать наш объект этого класса
    private static final long serialVersionUID = 1L;
;
    private int age;
    private transient String firstName; // transient - что бы поле не сериализовалось

    public Person(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
