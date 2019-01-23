package com.course.Web;

import com.course.Model.Course;
import com.course.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class CourseController {

    private CourseService courseService;

    public CourseController() {
        courseService = new CourseService();
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/")
    public String welcome() {
        return "Welcome!";
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/courses/add")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @PutMapping("/courses/update/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id) {
        courseService.updateCourse(course, id);
    }

    @DeleteMapping("/courses/delete/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}