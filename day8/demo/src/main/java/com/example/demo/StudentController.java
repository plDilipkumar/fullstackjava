package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s) {
        return repo.save(s);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student s, @PathVariable int id) {
        s.setId(id);
        return repo.save(s);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        repo.deleteById(id);
        return "Deleted";
    }
}
