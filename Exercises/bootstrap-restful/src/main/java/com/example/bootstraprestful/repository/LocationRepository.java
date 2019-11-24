package com.example.bootstraprestful.repository;

import com.example.bootstraprestful.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
