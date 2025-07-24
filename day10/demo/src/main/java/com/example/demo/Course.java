package com.example.demo;

import java.lang.annotation.Inherited;

import javax.persistence.Entity;

@Entity
public class Course {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Course name cannot be blank")
    private String courseName;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }


	
}
