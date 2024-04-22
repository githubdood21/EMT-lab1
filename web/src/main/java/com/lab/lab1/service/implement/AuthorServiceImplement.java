package com.lab.lab1.service.implement;

import com.lab.lab1.model.Author;
import com.lab.lab1.model.Book;
import com.lab.lab1.model.Country;
import com.lab.lab1.repository.AuthorRepository;
import com.lab.lab1.repository.CountryRepository;
import com.lab.lab1.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImplement implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImplement(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> saveAuthor(String name, String surname, Long countryId) {
        Country countryobj = countryRepository.findById(countryId).get();
        Author object = new Author(name, surname, countryobj);
        authorRepository.save(object);
        Optional<Author> optionalAuthor = Optional.of(object);
        return optionalAuthor;
    }
}
