package com.example.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.springbootgraphql.entity.Dog;
import com.example.springbootgraphql.exception.DogNotFoundException;
import com.example.springbootgraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DogQuery implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public DogQuery(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public  Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            return optionalDog.get();
        }
        else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
