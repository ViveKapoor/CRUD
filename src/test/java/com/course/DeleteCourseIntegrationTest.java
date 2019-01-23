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

public class DeleteCourseIntegrationTest {

    @Autowired
    private CourseDaoImpl courseDaoImpl;

    @LocalServerPort
    private int port;

    @Test
    public void testDeleteCourse()  {
        Course course = new Course("test","http://test.com");
        courseDaoImpl.save(course);
        Optional<Course> retreiveFromDB = courseDaoImpl.findById(course.getTitle());
        Assert.assertNotNull(retreiveFromDB);
        courseDaoImpl.deleteById(course.getTitle());
        Optional<Course> verifyRetreiveFromDB = courseDaoImpl.findById(course.getTitle());
        Assert.assertEquals(verifyRetreiveFromDB, Optional.empty());
    }
}
