package com.udacity.boogle.maps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class MapsController {

    //e.g. http://localhost:9191/maps/?lat=7.23456&lon=3.12345
    @GetMapping
    public Address get(@RequestParam Double lat, @RequestParam Double lon) {
        return MockAddressRepository.getRandom();
    }
}
