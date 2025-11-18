package org.example.exceptions_in_java.library;

import org.example.exceptions_in_java.library.exceptions.BookNotFoundException;
import org.example.exceptions_in_java.library.exceptions.InvalidBookException;
import java.util.concurrent.atomic.AtomicReference;



import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book > books;

    public Library() {
        this.books = new ArrayList<>();
    }
    // добавлять книгу
    // обработка исключения: если мы добавляем сущ книгу,
    // то мы получаем непроверяемое исключ InvalidBookException
    public void addBook(Book book) throws InvalidBookException {
        if (books.contains(book)){
            throw new InvalidBookException ("Такая книга уже существует в библиотеке!");
        } else {
            books.add(book);
        }
    }

    // искать книгу
    // обработка исключения: если мы не может найти книгу,
    // то случится проверяемое искл BookNotFoundException
    public Book findBook(String name) throws BookNotFoundException{
        AtomicReference<Book> foundBook = new AtomicReference<>();
        books.forEach(book -> {
            if (book.getName().equals(name)) {
                foundBook.set(book);
            }
        });
        if (foundBook.get() == null) {
            throw new BookNotFoundException("Не нашли книгу по имени " + name);
        }
        return foundBook.get();
    }
}
