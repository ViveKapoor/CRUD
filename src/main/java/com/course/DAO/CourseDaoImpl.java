package com.course.DAO;

import com.course.Model.Course;
import org.hibernate.annotations.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(appliesTo = "course")
public interface CourseDaoImpl extends CrudRepository<Course, String> {
}