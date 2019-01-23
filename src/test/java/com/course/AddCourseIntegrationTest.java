package com.course;

import com.course.Model.Course;
import com.course.DAO.CourseDaoImpl;
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
public class AddCourseIntegrationTest {
    @Autowired
    private CourseDaoImpl courseDaoImpl;

    @LocalServerPort
    private int port;

    @Test
    public void testAddCourse() {
        Course course = new Course("test","test.com");
        Assert.assertEquals(courseDaoImpl.findById(course.getTitle()), Optional.empty());

        courseDaoImpl.save(course);

        Assert.assertEquals(course, courseDaoImpl.findById(course.getTitle()));

        courseDaoImpl.deleteById(course.getTitle());

        //Assert.assertEquals(Optional.empty(), courseDaoImpl.findById(course.getTitle()));
    }
}
