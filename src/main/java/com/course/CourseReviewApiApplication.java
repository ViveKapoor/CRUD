package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseReviewApiApplication {
    public static void main(String[] args)  {
        try {
            SpringApplication.run(CourseReviewApiApplication.class, args);
        }catch(Exception e) {
            System.out.println("\n\nException occured...\n" + e.getClass().getSimpleName());
        }
    }

}
