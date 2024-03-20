package com.lab.lab1.web.rest;


import com.lab.lab1.model.Author;
import com.lab.lab1.model.Book;
import com.lab.lab1.model.Country;
import com.lab.lab1.model.enums.Category;
import com.lab.lab1.service.implement.AuthorServiceImplement;
import com.lab.lab1.service.implement.BookServiceImplement;
import com.lab.lab1.service.implement.CountryServiceImplement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookServiceImplement bookServiceImplement;
    private final AuthorServiceImplement authorServiceImplement;
    private final CountryServiceImplement countryServiceImplement;

    public BookController(BookServiceImplement bookServiceImplement, AuthorServiceImplement authorServiceImplement, CountryServiceImplement countryServiceImplement) {
        this.bookServiceImplement = bookServiceImplement;
        this.authorServiceImplement = authorServiceImplement;
        this.countryServiceImplement = countryServiceImplement;
    }

    @GetMapping
    public List<Book> findAll()
    {
        return bookServiceImplement.listBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id)
    {
        return bookServiceImplement.findBookById(id).map(book -> ResponseEntity.ok().body(book)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestParam String name,@RequestParam Category category,@RequestParam Long authorId,@RequestParam Integer availableCopies)
    {
        return bookServiceImplement.saveBook(name, category, authorId, availableCopies).map(book -> ResponseEntity.ok().body(book)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@RequestParam String name,@RequestParam Category category,@RequestParam Long authorId,@RequestParam Integer availableCopies, @RequestParam Long id)
    {
        return bookServiceImplement.editBook(name, category, authorId, availableCopies, id).map(book -> ResponseEntity.ok().body(book)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {
        bookServiceImplement.deleteBook(id);
        if(bookServiceImplement.findBookById(id).isEmpty())
        {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/author/add")
    public ResponseEntity<Author> saveAuthor(@RequestParam String name,@RequestParam String surname,@RequestParam Long countryId)
    {
        return authorServiceImplement.saveAuthor(name, surname, countryId).map(author -> ResponseEntity.ok().body(author)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/country/add")
    public ResponseEntity<Country> saveCountry(@RequestParam String name, @RequestParam String continent)
    {
        return countryServiceImplement.saveCountry(name, continent).map(country -> ResponseEntity.ok().body(country)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
