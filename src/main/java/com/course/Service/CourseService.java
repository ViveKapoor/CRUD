package com.course.Service;

import com.course.DAO.CourseDaoImpl;
import com.course.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseDaoImpl courseDaoImpl;

    @Transactional(readOnly = true)
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseDaoImpl.findAll().forEach(courses::add);
        return courses;
    }

    public void CourseService() {
    }

    @Transactional(readOnly = true)
    public Optional<Course> getCourse(String id) {
        return courseDaoImpl.findById(id);
    }

    public void addCourse(Course course) {
        courseDaoImpl.save(course);
    }

    public void updateCourse(Course course, String id) {
        /*for (Course c : courses) {
            if (c.getTitle().equals(id)) {
                c.setTitle(course.getTitle());
                c.setUrl(course.getUrl());
                return;
            }
        }*/
        courseDaoImpl.save(course);
    }

    @Transactional
    public void deleteCourse(String id) {
        //courses.removeIf(t -> t.getTitle().equals(id));
        courseDaoImpl.deleteById(id);
    }
}
