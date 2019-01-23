package com.course;

import com.course.DAO.CourseDaoImpl;
import com.course.Model.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UpdateCourseIntegrationTest {
    @Autowired
    private CourseDaoImpl courseDaoImpl;

    @LocalServerPort
    private int port;

    @Test
    public void testUpdateCourse()  {
        Course course = new Course("test","test.com");
        courseDaoImpl.save(course);

        Optional<Course> retreiveFromDB = courseDaoImpl.findById(course.getTitle());
        Assert.assertEquals(course.getTitle(), retreiveFromDB);

        Course updatedCourse = new Course("test", "http://test.com");
        courseDaoImpl.save(updatedCourse);

        Optional<Course> verifyRetreiveFromDB = courseDaoImpl.findById(updatedCourse.getTitle());
        Assert.assertEquals(updatedCourse, verifyRetreiveFromDB);
    }
}
