package com.klu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

 @Autowired
 CourseService service;

 // Add Course
 @PostMapping
 public ResponseEntity<?> addCourse(@RequestBody Course course){

  if(course.getTitle()==null)
   return ResponseEntity.badRequest().body("Invalid course data");

  service.addCourse(course);

  return ResponseEntity.status(HttpStatus.CREATED)
          .body("Course added successfully");
 }

 // Get All Courses
 @GetMapping
 public ResponseEntity<List<Course>> getCourses(){

  return ResponseEntity.ok(service.getAllCourses());
 }

 // Get Course By ID
 @GetMapping("/{id}")
 public ResponseEntity<?> getCourse(@PathVariable int id){

  Optional<Course> course = service.getCourseById(id);

  if(course.isPresent())
   return ResponseEntity.ok(course.get());

  return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Course not found");
 }

 // Update Course
 @PutMapping("/{id}")
 public ResponseEntity<?> updateCourse(
   @PathVariable int id,
   @RequestBody Course course){

  boolean updated = service.updateCourse(id, course);

  if(updated)
   return ResponseEntity.ok("Course updated successfully");

  return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Course not found");
 }

 // Delete Course
 @DeleteMapping("/{id}")
 public ResponseEntity<?> deleteCourse(@PathVariable int id){

  boolean deleted = service.deleteCourse(id);

  if(deleted)
   return ResponseEntity.ok("Course deleted successfully");

  return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Course not found");
 }

 // Search by Title
 @GetMapping("/search/{title}")
 public ResponseEntity<List<Course>> searchCourse(
   @PathVariable String title){

  return ResponseEntity.ok(service.searchByTitle(title));
 }

}