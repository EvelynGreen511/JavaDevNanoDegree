package com.example.bootstraprestful.web;

import com.example.bootstraprestful.entity.Dog;
import com.example.bootstraprestful.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService=dogService;
    }

    @GetMapping("/list/dog/all")
    public ResponseEntity<List<Dog>> getListOfDogs() {
        List<Dog> dogs = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }

    @GetMapping("/list/dog/all/breed")
    public ResponseEntity<List<String>> getListOfDogBreeds() {
        List<String> breeds = dogService.retrieveDogBreeds();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }

    @GetMapping("/list/dog/all/name")
    public ResponseEntity<List<String>> getListOfDogNames() {
        List<String> breeds = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }

@GetMapping("/list/dog/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable("id") Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }
}
