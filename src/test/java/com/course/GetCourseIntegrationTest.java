package com.course;

import com.course.CourseReviewApiApplication;
import com.course.REPOSITORY.CourseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CourseReviewApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetCourseIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetCourse() {
        String expected = "{\"title\":\"Wikipedia\",\"url\":\"https://wikipedia.org\"}";
        String uri = ("/courses/{id}");
        ResponseEntity<String> responseEntity = this.restTemplate
                .getForEntity(createURLWithPort(uri), String.class, "Wikipedia");
        Assert.assertEquals(expected, responseEntity.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}



//public class com.course.GetCourseIntegrationTest {
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Autowired
//    private Course course;
//
//    @Autowired
//    private CourseService courseService;
//
//    private final String TEST_TITLE = "dummy";
//    private final String TEST_URL = "dummy.com";
//
//    @After
//    public void tearDown() throws Exception {
//        courseService.deleteCourse(TEST_TITLE);
//    }
//
//    @Test
//    public void shouldSaveAndFetchPerson() {
//        Course dummyCourse = new Course(TEST_TITLE, TEST_URL);
//        courseService.addCourse(dummyCourse);
//
//        Optional<Course> response = courseRepository.findById(TEST_TITLE);
//
//        Assert.assertEquals(dummyCourse, response);
//    }
//}