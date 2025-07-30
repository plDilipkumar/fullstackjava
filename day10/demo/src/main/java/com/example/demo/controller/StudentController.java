package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return service.addStudent(s);
    }

    @GetMapping
    public List<StudentDTO> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student s, @PathVariable int id) {
        return service.updateStudent(id, s);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student with id " + id + " deleted successfully.";
    }
}
