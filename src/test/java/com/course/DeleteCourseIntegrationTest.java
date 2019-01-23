package com.course;

import com.course.CourseReviewApiApplication;
import com.course.DTO.Course;
import com.course.REPOSITORY.CourseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CourseReviewApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class DeleteCourseIntegrationTest {

    @Autowired
    private CourseRepository courseRepository;

    @LocalServerPort
    private int port;

    @Test
    public void testDeleteCourse()  {
        Course course = new Course("test","http://test.com");
        courseRepository.save(course);
        Optional<Course> retreiveFromDB = courseRepository.findById(course.getTitle());
        Assert.assertNotNull(retreiveFromDB);
        courseRepository.deleteById(course.getTitle());
        Optional<Course> verifyRetreiveFromDB = courseRepository.findById(course.getTitle());
        Assert.assertEquals(verifyRetreiveFromDB, Optional.empty());
    }
}
