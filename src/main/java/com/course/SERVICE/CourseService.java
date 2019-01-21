package com.course.SERVICE;

import com.course.DTO.Course;
import com.course.REPOSITORY.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public void CourseService() {
    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    @Transactional
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

    @Transactional
    public void deleteCourse(String id) {
        //courses.removeIf(t -> t.getTitle().equals(id));
        courseRepository.deleteById(id);
    }
}
