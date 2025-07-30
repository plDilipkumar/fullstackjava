package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public Student getStudent() { return student; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setStudent(Student student) { this.student = student; }
}
