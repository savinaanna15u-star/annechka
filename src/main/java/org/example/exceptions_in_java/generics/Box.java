package org.example.exceptions_in_java.generics;

public class Box <T> {
    private T element;

    public void setElement(T element) {
        this.element = element;
    }
    public T getElement() {
        return this.element;
    }

}
