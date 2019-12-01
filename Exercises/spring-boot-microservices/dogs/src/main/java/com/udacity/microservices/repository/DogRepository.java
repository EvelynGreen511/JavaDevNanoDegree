package com.udacity.microservices.repository;

import com.udacity.microservices.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}


