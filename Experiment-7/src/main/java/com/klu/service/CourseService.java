package com.klu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.klu.model.Course;

@Service
public class CourseService {

 List<Course> courseList = new ArrayList<>();

 // Add Course
 public Course addCourse(Course course) {
  courseList.add(course);
  return course;
 }

 // Get All Courses
 public List<Course> getAllCourses() {
  return courseList;
 }

 // Get Course By ID
 public Optional<Course> getCourseById(int id) {

  return courseList.stream()
          .filter(c -> c.getCourseId() == id)
          .findFirst();
 }

 // Update Course
 public boolean updateCourse(int id, Course newCourse) {

  Optional<Course> course = getCourseById(id);

  if(course.isPresent()) {

   Course c = course.get();

   c.setTitle(newCourse.getTitle());
   c.setDuration(newCourse.getDuration());
   c.setFee(newCourse.getFee());

   return true;
  }

  return false;
 }

 // Delete Course
 public boolean deleteCourse(int id) {

  return courseList.removeIf(c -> c.getCourseId() == id);
 }

 // Search by Title
 public List<Course> searchByTitle(String title) {

  List<Course> result = new ArrayList<>();

  for(Course c : courseList) {

   if(c.getTitle().toLowerCase().contains(title.toLowerCase())) {
    result.add(c);
   }

  }

  return result;
 }

}