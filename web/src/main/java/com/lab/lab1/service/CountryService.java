package com.lab.lab1.service;

import com.lab.lab1.model.Country;

import java.util.Optional;

public interface CountryService {
    public Optional<Country> saveCountry(String name, String continent);
}
