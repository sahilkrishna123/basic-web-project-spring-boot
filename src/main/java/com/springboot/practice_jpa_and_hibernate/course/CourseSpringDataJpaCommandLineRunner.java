package com.springboot.practice_jpa_and_hibernate.course;

import com.springboot.practice_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.springboot.practice_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {

//        Spring Data JPA Methods

        // Insert Data
        repository.save(new Course(1, "Learn Spring Boot Spring Data JPA" , "Sahil"));
        repository.save(new Course(2, "Learn NEST JS Spring Data JPA" , "Sahil"));
        repository.save(new Course(3, "Learn Spring Framework Spring Data JPA" , "Sahil"));

        // Delete Data
        repository.deleteById(1l);

        // Find by ID
        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(" ");

        // Play with Spring Data JPA methods
        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(" ");

        System.out.println(repository.findByAuthor("Sahil"));
        System.out.println(repository.findByAuthor("Moin"));

        System.out.println(" ");

        System.out.println(repository.findByName("Learn NEST JS Spring Data JPA"));

    }
}
