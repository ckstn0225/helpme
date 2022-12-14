package com.example.last;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LastApplication {

    public static void main(String[] args) {
        SpringApplication.run(LastApplication.class, args);
    }

}
