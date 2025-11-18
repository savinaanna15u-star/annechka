package org.example.exceptions_in_java.library.exceptions;
// проверяемое -> Exception (наследников)
public class BookNotFoundException extends Exception{
    public BookNotFoundException (String massage){
        super(massage);
    }
}
