package com.alfeu.crud.angular.spring.controller;

import com.alfeu.crud.angular.spring.model.Course;
import com.alfeu.crud.angular.spring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> listAll(){
        return courseRepository.findAll();
    }
}
