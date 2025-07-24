package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student s) {
        if(s.getCourses() != null) {
            for(Course c : s.getCourses()) {
            c.setStudent(s);
        }}
        return repo.save(s);
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> students = repo.findAll();
        return students.stream()
                .map(s -> new StudentDTO(s.getId(), s.getName()))
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(int id) {
        Student s = repo.findById(id).orElse(null);
        if (s != null) {
            return new StudentDTO(s.getId(), s.getName());
        } else {
            return null;
        }
    }

    public Student updateStudent(int id, Student updated) {
        updated.setId(id);
        return repo.save(updated);
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
