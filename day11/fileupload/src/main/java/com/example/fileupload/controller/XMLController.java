package com.example.fileupload.controller;

import com.example.fileupload.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/xml")
public class XMLController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/upload")
    public String uploadXML(@RequestParam("file") MultipartFile file) {
        return service.saveEmployeesFromXML(file);
    }
}
