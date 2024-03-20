package com.lab.lab1.service;

import com.lab.lab1.model.Author;
import com.lab.lab1.model.Country;

import java.util.Optional;

public interface AuthorService {
    public Optional<Author> saveAuthor(String name, String surname, Long countryId);
}
