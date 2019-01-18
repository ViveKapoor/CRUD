import com.API.coursereviewAPI.REPOSITORY.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest //for unit test only NOT FOR INTEGRATION
public class AppTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CourseRepository courseRepository;

    @Test
    public void contextLoads() throws Exception {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nENTER\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nEXIT\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
}
