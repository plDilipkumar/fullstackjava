package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        if (student.getCourse() != null) {
            Course c = student.getCourse();
            c.setStudent(student);
        }
        return studentRepository.save(student);
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(s -> new StudentDTO(s.getId(), s.getName()))
                .collect(Collectors.toList());
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(int id, Student updated) {
        updated.setId(id);
        return studentRepository.save(updated);
    }

    public void deleteStudent(int id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }
}
