package com.lab.lab1.service.implement;

import com.lab.lab1.model.Author;
import com.lab.lab1.model.Country;
import com.lab.lab1.repository.CountryRepository;
import com.lab.lab1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImplement implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImplement(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> saveCountry(String name, String continent) {
        Country object = new Country(name, continent);
        countryRepository.save(object);
        Optional<Country> optionalCountry = Optional.of(object);
        return optionalCountry;
    }
}
