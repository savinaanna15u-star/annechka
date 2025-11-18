package org.example.exceptions_in_java.library.exceptions;

// непроверяемый -> Error, RuntimeException
public class InvalidBookException extends RuntimeException{
    public InvalidBookException (String massage){
        super(massage);
    }
}
