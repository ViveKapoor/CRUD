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
        Course course = new Course();
        course.setTitle("test");
        course.setUrl("test.com");
        Assert.assertNotEquals(courseDaoImpl.findById(course.getTitle()), Optional.empty());

        courseDaoImpl.save(course);

        Optional<Course> courseFromDB = courseDaoImpl.findById(course.getTitle());
        Assert.assertEquals(course.getTitle(), courseFromDB.get().getTitle());
        Assert.assertEquals(course.getUrl(), courseFromDB.get().getUrl());
    }
}
