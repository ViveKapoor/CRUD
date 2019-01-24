package com.course;

import com.course.DAO.CourseDaoImpl;
import com.course.Model.Course;
import com.course.Web.CourseController;
import com.course.Service.CourseService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Autowired
    private static final CourseService courseService = mock(CourseService.class);
    @Autowired
    private static final CourseDaoImpl COURSE_DAO_IMPL = mock(CourseDaoImpl.class);

    private CourseController rc = new CourseController();
    private Optional<Course> response;
    private Course dummyCourse = new Course("Wikipedia", "https://wikipedia.org");
    private String TEST_COURSE_TITLE = "Wikipedia";

    @Before
    public void setup() {
        rc.setCourseService(courseService);
    }

    //Syntax : Assert.assertEquals(expected, actual);

    @Test
    public void testWelcome() {
        // To test "/" welcome
        Assert.assertEquals(rc.welcome(), String.valueOf("Welcome!"));
    }

    @Test
    public void testGETCourseById() {
        // Test for getting existing course
        when(courseService.getCourse(TEST_COURSE_TITLE)).thenReturn(Optional.ofNullable(dummyCourse));
        response = rc.getCourse(TEST_COURSE_TITLE);
        Assert.assertEquals(Optional.ofNullable(dummyCourse), response);
    }

    @Test
    public void testPOSTCourseById() {
        // Test for adding new course to DB
        doNothing().when(courseService).addCourse(dummyCourse);
        rc.addCourse(dummyCourse);
        Mockito.verify(courseService).addCourse(dummyCourse);
    }

    @Test
    public void testPUTCourseById() {
        doNothing().when(courseService).updateCourse(dummyCourse, TEST_COURSE_TITLE);
        rc.updateCourse(dummyCourse, TEST_COURSE_TITLE);
        Mockito.verify(courseService).updateCourse(dummyCourse, TEST_COURSE_TITLE);
    }

    @Test
    public void testDELETECourseById() {
        doNothing().when(courseService).deleteCourse(TEST_COURSE_TITLE);
        rc.deleteCourse(TEST_COURSE_TITLE);
        Mockito.verify(courseService).deleteCourse(TEST_COURSE_TITLE);
    }
}







/*
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CourseDaoImpl COURSE_DAO_IMPL;

    @Test
    public void contextLoads() throws Exception {

        Mockito.when(COURSE_DAO_IMPL.findAll()).thenReturn(
                Collections.EMPTY_LIST
        );
        MvcResult mvcResult;

            mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/courses")
                    .accept(MediaType.APPLICATION_JSON)
            ).andReturn();

        System.out.println(mvcResult.getResponse());

        Mockito.verify(COURSE_DAO_IMPL).findAll();
    }


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseService courseService;

    public com.course.ApplicationTest() {

    }

    Course mockCourse = new Course("udemy", "udemy.com");
    //String mockCourseJSON = "{\"title\":\"udemy\",\"url\":\"udemy.com\"}";

    @Test
    public void testing() throws Exception    {
        Mockito.when(
                courseService.getCourse(Mockito.anyString()))
                .thenReturn(java.util.Optional.of(mockCourse));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/courses/udemy")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();

        System.out.println(mvcResult.getResponse());

        String expected = "{\"title\":\"udemy\",\"url\":\"udemy.com\"}";

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(),false);
    }
}
*/

