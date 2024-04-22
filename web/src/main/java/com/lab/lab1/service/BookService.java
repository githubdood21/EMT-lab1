package com.lab.lab1.service;

import com.lab.lab1.model.Author;
import com.lab.lab1.model.Book;
import com.lab.lab1.model.enums.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> listBooks();
    public Optional<Book> findBookById(Long id);
    public Optional<Book> saveBook(String name, Category category, Long authorId, Integer availableCopies);
    public Optional<Book> editBook(String name, Category category, Long authorId, Integer availableCopies, Long bookId);
    public void deleteBook(Long bookId);
}
