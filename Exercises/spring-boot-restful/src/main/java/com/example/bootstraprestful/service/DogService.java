package com.example.bootstraprestful.service;

import com.example.bootstraprestful.entity.Dog;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();

    List<String> retrieveDogBreeds();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();
}
