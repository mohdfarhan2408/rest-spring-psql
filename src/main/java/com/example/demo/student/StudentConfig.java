package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.APRIL;
import static java.util.Calendar.MAY;

@Configuration
public class StudentConfig {

    //Bean
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student mariam = new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(1998, APRIL, 6)
            );

            Student alex= new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, MAY, 4)
            );

            repository.saveAll( //save into db
                    List.of(mariam, alex)
            );

        };
    }
}
