package com.example.day13.service;

import com.example.day13.model.UserInput;
import com.example.day13.repository.UserInputRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserInputService {

    private final UserInputRepository repository;

    public UserInputService(UserInputRepository repository) {
        this.repository = repository;
    }

    public UserInput saveUserInput(UserInput input) {
        return repository.save(input);
    }
    public List<UserInput> getAllInputs() {
    return repository.findAll();
}

}
