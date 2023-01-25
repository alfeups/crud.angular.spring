package com.alfeu.crud.angular.spring.repository;

import com.alfeu.crud.angular.spring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
