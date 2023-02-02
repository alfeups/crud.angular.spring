package com.alfeu.crud.angular.spring.controller;

import com.alfeu.crud.angular.spring.model.Course;
import com.alfeu.crud.angular.spring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id_course}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id_course") Long idCourse){
        return courseRepository.findById(idCourse)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCurse(@RequestBody Course course){
        return courseRepository.save(course);
    }
}
