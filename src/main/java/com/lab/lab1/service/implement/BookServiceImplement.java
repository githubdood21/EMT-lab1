package com.lab.lab1.service.implement;

import com.lab.lab1.model.Author;
import com.lab.lab1.model.Book;
import com.lab.lab1.model.enums.Category;
import com.lab.lab1.repository.AuthorRepository;
import com.lab.lab1.repository.BookRepository;
import com.lab.lab1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplement implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImplement(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> saveBook(String name, Category category, Long authorId, Integer availableCopies) {
        Author authorobj = authorRepository.findById(authorId).get();
        Book object = new Book(name, category, authorobj, availableCopies);
        bookRepository.save(object);
        Optional<Book> optionalBook = Optional.of(object);
        return optionalBook;
    }

    @Override
    public Optional<Book> editBook(String name, Category category, Long authorId, Integer availableCopies, Long bookId) {
        Author authorobj = authorRepository.findById(authorId).get();
        Optional<Book> object = bookRepository.findById(bookId);
        object.get().setName(name);
        object.get().setCategory(category);
        object.get().setAuthor(authorobj);
        object.get().setAvailableCopies(availableCopies);

        bookRepository.flush();
        return object;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
