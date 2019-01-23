package com.course;

import com.course.DTO.Course;
import com.course.REPOSITORY.CourseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CourseReviewApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddCourseIntegrationTest {
    @Autowired
    private CourseRepository courseRepository;

    @LocalServerPort
    private int port;

    @Test
    public void testAddCourse() {
        Course course = new Course("test","test.com");
        Assert.assertEquals(courseRepository.findById(course.getTitle()), Optional.empty());

        courseRepository.save(course);

        Assert.assertEquals(course, courseRepository.findById(course.getTitle()));

        courseRepository.deleteById(course.getTitle());

        //Assert.assertEquals(Optional.empty(), courseRepository.findById(course.getTitle()));
    }
}
