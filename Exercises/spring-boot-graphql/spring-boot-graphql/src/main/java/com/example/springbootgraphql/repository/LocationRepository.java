package com.example.springbootgraphql.repository;

import com.example.springbootgraphql.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}

