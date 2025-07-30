package com.example.fileupload.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UploadLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fileName;
    private String fileType;
    private LocalDateTime uploadedAt;
    private int recordCount;
    
    public UploadLog( String fileName, String fileType, LocalDateTime uploadedAt, int recordCount) {
     
        this.fileName = fileName;
        this.fileType = fileType;
        this.uploadedAt = uploadedAt;
        this.recordCount = recordCount;
    }
    public UploadLog() {
    // required by JPA
}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }
    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
    public int getRecordCount() {
        return recordCount;
    }
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    // Constructors, Getters & Setters
}
