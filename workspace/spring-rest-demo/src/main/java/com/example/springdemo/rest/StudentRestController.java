package com.example.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
    return students.get(studentId);
  }
}
