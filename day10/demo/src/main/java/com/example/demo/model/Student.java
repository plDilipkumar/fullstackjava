package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Student() {}

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public Course getCourse() { return course; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCourse(Course course) { this.course = course; }
}
