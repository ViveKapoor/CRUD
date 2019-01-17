package com.API.coursereviewAPI.Repositories;

import com.API.coursereviewAPI.Modules.Course;
import org.hibernate.annotations.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;

@Repository
@Table(appliesTo = "course")
public interface CourseRepository extends CrudRepository<Course, String> {

}
