package com.springboot.practice_jpa_and_hibernate.course.jdbc;

import com.springboot.practice_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// This is Spring JDBC Code

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_QUERY =
            """
                INSERT INTO course (id, name, author)
                VALUES (?, ?, ?);
            """;
    private static final String DELETE_QUERY =
            """
                    DELETE FROM course WHERE id = ?
            """;
    private static final String SELECT_QUERY =
            """
                    SELECT * FROM course WHERE id = ?
            """;
//    private static final String INSERT_QUERY =
//            """
//                INSERT INTO course (id, name, author)
//                VALUES (1, 'Learn Spring', 'Sahil Krishna');
//            """;

//    // basic implementation:
//    public void insert(){
//        springJdbcTemplate.update(INSERT_QUERY);
//    }

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }
    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
    public Course findById(long id){
        // ResultSet -> Bean => RowMapper =>
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class)
                , id);


//        Spring performs these steps:
//
//        Executes the SQL query.
//        Gets a ResultSet from the database.
//        For each row:
//            Creates an empty object of Course.
//            Reads column values.
//            Calls setters to fill the object.

    }
}
