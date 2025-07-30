package com.example.fileupload.controller;

import com.example.fileupload.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/csv")
public class CSVController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/upload")
    public String uploadCSV(@RequestParam("file") MultipartFile file) {
        return service.saveEmployeesFromCSV(file);
    }
}
