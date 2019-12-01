package com.example.springbootgraphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.springbootgraphql.entity.Location;
import com.example.springbootgraphql.repository.LocationRepository;
import com.example.springbootgraphql.exception.LocationNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocationMutation implements GraphQLMutationResolver {

    private LocationRepository locationRepository;

    public LocationMutation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location newLocation(String name, String address) {
        Location newLocation = new Location(name, address);
        locationRepository.save(newLocation);
        return newLocation;
    }

    public boolean deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return true;
    }

    public Location updateLocationName(String name, Long id) {

        Optional<Location> optionalLocation = locationRepository.findById(id);

        if(optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setName(name);
            locationRepository.save(location);
            return location;
        }
        else {
            throw new LocationNotFoundException("Location Not Found", id);
        }
    }
}
