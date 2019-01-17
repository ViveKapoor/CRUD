package com.API.coursereviewAPI.REST_API;

import com.API.coursereviewAPI.DTO.Course;
import com.API.coursereviewAPI.SERVICE.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@ComponentScan
public class RESTController {

    Logger logger = Logger.getLogger(RESTController.class.getName());
    @Autowired
    private CourseService courseService;

    public void setLogger(Logger logger) {
        this.logger = logger;
        logger.setLevel(Level.FINE);
    }

    @RequestMapping("/")
    public String helloGradle() {
        return "Welcome!";
    }

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping("/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses/add")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses/update/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id) {
        courseService.updateCourse(course, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/delete/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}