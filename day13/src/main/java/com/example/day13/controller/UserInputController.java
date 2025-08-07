package com.example.day13.controller;

import com.example.day13.model.UserInput;
import com.example.day13.service.UserInputService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/input")
public class UserInputController {

    private final UserInputService service;

    public UserInputController(UserInputService service) {
        this.service = service;
    }

    @PostMapping
    public UserInput submitInput(@RequestBody UserInput input) {
        return service.saveUserInput(input);
    }
    @GetMapping
    public java.util.List<UserInput> getAllInputs() {
        return service.getAllInputs();
    }

}
