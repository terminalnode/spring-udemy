package com.example.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
  private List<Student> students;
  
  @PostConstruct
  public void loadData() {
    students = new ArrayList<>();
    students.add(new Student("Jonas", "Hansson"));
    students.add(new Student("Sara", "Åhling"));
    students.add(new Student("Niklas", "Fredberg"));
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return students;
  }
  
  @GetMapping("/students/{studentId}")
  public Student getStudentById(@PathVariable int studentId) {
    if (studentId >= students.size()) {
      throw new StudentNotFoundException("Student ID not found: " + studentId);
    }

    return students.get(studentId);
  }

  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
    StudentErrorResponse error = new StudentErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}



