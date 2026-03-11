package com.springboot.practice_jpa_and_hibernate.course;

import com.springboot.practice_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// Stop it by commenting @Component Annotation
//@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {

        // Insert Data
        repository.insert(new Course(1, "Learn Spring Boot JPA" , "Sahil"));
        repository.insert(new Course(2, "Learn NEST JS JPA" , "Sahil"));
        repository.insert(new Course(3, "Learn Spring Framework JPA" , "Sahil"));

        // Delete Data
        repository.deleteById(1);

        // Find by ID
        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));

    }
}
