package com.example.hibernatecaching;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
@EnableCaching
public class HibernateCachingApplication {
    public static void main(String[] args) {
        SpringApplication.run(HibernateCachingApplication.class, args);
    }

}
