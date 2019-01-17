package com.API.coursereviewAPI.Servies;

import com.API.coursereviewAPI.Modules.Course;
import com.API.coursereviewAPI.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /*
    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("spring", "spring.io"),
            new Course("facebook", "facebook.com"),
            new Course("ML", "coursera.com")
    ));
    */

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        //return courses.stream().filter(t -> t.getTitle().equals(id)).findFirst().get();
        //return courseRepository.findById(id);
        //problem here
        return null;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id) {
        /*for (Course c : courses) {
            if (c.getTitle().equals(id)) {
                c.setTitle(course.getTitle());
                c.setUrl(course.getUrl());
                return;
            }
        }*/
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //courses.removeIf(t -> t.getTitle().equals(id));
        courseRepository.deleteById(id);
    }
}
