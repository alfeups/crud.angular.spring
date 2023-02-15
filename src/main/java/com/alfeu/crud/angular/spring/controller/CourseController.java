package com.alfeu.crud.angular.spring.controller;

import com.alfeu.crud.angular.spring.model.Course;
import com.alfeu.crud.angular.spring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @PutMapping("/{id_course}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Course updateCourse(
            @PathVariable("id_course") Long idCourse,
            @RequestBody @Validated Course course) {
        Course courseSaved = this.courseRepository.findById(idCourse)
                .orElseThrow(NoSuchElementException::new);
        courseSaved.setCategory(course.getCategory());
        courseSaved.setName(course.getName());
        return this.courseRepository.save(courseSaved);
    }
}
