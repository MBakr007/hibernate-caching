package com.example.hibernatecaching.fakedata;


import com.example.hibernatecaching.model.City;
import com.example.hibernatecaching.repo.CityRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static java.util.stream.Stream.generate;

@Component
public class FakeData {

    @Autowired
    CityRepository employeeRepository;

    @PostConstruct
    private void initData() {
        Faker faker = Faker.instance();
        employeeRepository.saveAll(
                generate(() -> {
                    City city = new City();
                    city.setName(faker.address().cityName());
                    city.setCountry(faker.address().country());
                    return city;
                })
                    .limit(1000)
                    .collect(Collectors.toList())
        );
    }

}

