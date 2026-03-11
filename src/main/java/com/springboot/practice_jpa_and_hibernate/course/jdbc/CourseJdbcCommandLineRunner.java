package com.springboot.practice_jpa_and_hibernate.course.jdbc;

import com.springboot.practice_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {

        // Insert Data
        repository.insert(new Course(1, "Learn Spring Boot" , "Sahil"));
        repository.insert(new Course(2, "Learn NEST JS" , "Sahil"));
        repository.insert(new Course(3, "Learn Spring Framework" , "Sahil"));

        // Delete Data
        repository.deleteById(1);

        // Find by ID
        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));

    }
}
