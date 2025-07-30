package com.example.fileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fileupload.model.UploadLog;

@Repository
public interface UploadLogRepository extends JpaRepository<UploadLog, Integer> {}
