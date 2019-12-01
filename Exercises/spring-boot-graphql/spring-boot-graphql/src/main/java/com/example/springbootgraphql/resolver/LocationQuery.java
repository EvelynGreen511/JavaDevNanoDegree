package com.example.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.springbootgraphql.entity.Location;
import com.example.springbootgraphql.repository.LocationRepository;
import org.springframework.stereotype.Component;

@Component
public class LocationQuery implements GraphQLQueryResolver {

    private LocationRepository locationRepository;

    public LocationQuery(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public  Iterable<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}
