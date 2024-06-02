package com.example.hibernatecaching.controller;


import com.example.hibernatecaching.model.City;
import com.example.hibernatecaching.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/cities")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCities() {
        return cityService.getCities();
    }

    @GetMapping("/{id}")
    public Optional<City> getCity(@PathVariable("id") Integer id) {
        return cityService.getCity(id);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.create(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }
}
