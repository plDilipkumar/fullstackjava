package com.example.demo.dto;

public class StudentDTO {
    private int id;
    private String name;

    public StudentDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
