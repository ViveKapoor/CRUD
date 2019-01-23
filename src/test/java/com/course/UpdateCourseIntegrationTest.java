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
public class UpdateCourseIntegrationTest {
    @Autowired
    private CourseRepository courseRepository;

    @LocalServerPort
    private int port;

    @Test
    public void testUpdateCourse()  {
        Course course = new Course("test","test.com");
        courseRepository.save(course);

        Optional<Course> retreiveFromDB = courseRepository.findById(course.getTitle());
        Assert.assertEquals(course, retreiveFromDB);

        Course updatedCourse = new Course("test", "http://test.com");
        courseRepository.save(updatedCourse);

        Optional<Course> verifyRetreiveFromDB = courseRepository.findById(updatedCourse.getTitle());
        Assert.assertEquals(updatedCourse, verifyRetreiveFromDB);
    }
}
