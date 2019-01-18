package com.course.REPOSITORY;

import com.course.DTO.Course;
import org.hibernate.annotations.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(appliesTo = "course")
public interface CourseRepository extends CrudRepository<Course, String> {

}
