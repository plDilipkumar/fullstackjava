package com.example.feedback.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;

@Service
public class FeedbackService {
    @Autowired
    private  final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    public void saveFeedback(Feedback feedback) {
        feedback.setTimestamp(LocalDateTime.now());
        feedbackRepository.save(feedback);
    }
    public Feedback getFeedbackById(Long id){
        return feedbackRepository.findById(id).orElse(null);
    }
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    
}
