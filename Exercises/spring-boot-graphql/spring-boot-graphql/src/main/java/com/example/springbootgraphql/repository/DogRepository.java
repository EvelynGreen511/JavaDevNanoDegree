package com.example.springbootgraphql.repository;

import com.example.springbootgraphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
