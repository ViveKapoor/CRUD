import com.course.DTO.Course;
import com.course.REPOSITORY.CourseRepository;
import com.course.REST_API.RESTController;
import com.course.SERVICE.CourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.*;

// BUG - CourseRepository Constructor

public class AppTest {

    @Autowired
    private static final CourseService courseService = mock(CourseService.class);
    @Autowired
    private static final CourseRepository courseRepository = mock(CourseRepository.class);

    private RESTController rc = new RESTController();
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
    CourseRepository courseRepository;

    @Test
    public void contextLoads() throws Exception {

        Mockito.when(courseRepository.findAll()).thenReturn(
                Collections.EMPTY_LIST
        );
        MvcResult mvcResult;

            mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/courses")
                    .accept(MediaType.APPLICATION_JSON)
            ).andReturn();

        System.out.println(mvcResult.getResponse());

        Mockito.verify(courseRepository).findAll();
    }


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseService courseService;

    public AppTest() {

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

