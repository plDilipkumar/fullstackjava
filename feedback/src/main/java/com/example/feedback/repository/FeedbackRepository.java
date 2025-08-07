package com.example.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feedback.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // This interface will automatically provide CRUD operations for Feedback entities
    // No additional methods are needed unless custom queries are required

    
} 