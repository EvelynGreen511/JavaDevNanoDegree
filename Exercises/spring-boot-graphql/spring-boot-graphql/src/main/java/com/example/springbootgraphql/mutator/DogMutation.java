package com.example.springbootgraphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.springbootgraphql.entity.Dog;
import com.example.springbootgraphql.exception.BreedNotFoundException;
import com.example.springbootgraphql.exception.DogNotFoundException;
import com.example.springbootgraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DogMutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public DogMutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog newDog(String name, String breed, String origin) {
        Dog newDog = new Dog(name, breed, origin);
        dogRepository.save(newDog);
        return newDog;
    }

    public boolean deleteDogsByBreed(String breed) {

        boolean deleted = false;

        Iterable<Dog> allDogs = dogRepository.findAll();

        for(Dog d : allDogs) {
            if(d.getBreed().equals(breed)) {
                dogRepository.delete(d);
                deleted = true;
            }
        }

        if(!deleted) {
            throw new BreedNotFoundException("Breed Not found", breed);
        }

        return deleted;
    }

    public Dog updateDogName(String name, Long id) {

        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {

            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        }
        else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
