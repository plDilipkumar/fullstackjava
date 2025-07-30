package com.example.fileupload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.example.fileupload.model.Employee;
import com.example.fileupload.model.UploadLog;
import com.example.fileupload.repository.EmployeeRepository;
import com.example.fileupload.repository.UploadLogRepository;
import com.example.fileupload.sax.EmployeeSAXHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private UploadLogRepository logRepo;

    public String saveEmployeesFromCSV(MultipartFile file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Employee> list = new ArrayList<>();
            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                Employee e = new Employee();
                e.setName(data[0]);
                e.setRole(data[1]);
                e.setSalary(Double.parseDouble(data[2]));
                list.add(e);
            }

            repo.saveAll(list);

            logRepo.save(new UploadLog(file.getOriginalFilename(), "CSV", LocalDateTime.now(), list.size()));
            return "CSV uploaded successfully with " + list.size() + " records";

        } catch (Exception e) {
            return "Failed to upload CSV: " + e.getMessage();
        }
    }

    public String saveEmployeesFromXML(MultipartFile file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            EmployeeSAXHandler handler = new EmployeeSAXHandler();
            parser.parse(file.getInputStream(), handler);

            List<Employee> empList = handler.getEmployees();
            repo.saveAll(empList);

            logRepo.save(new UploadLog(file.getOriginalFilename(), "XML", LocalDateTime.now(), empList.size()));
            return "XML uploaded successfully with " + empList.size() + " records";

        } catch (Exception e) {
            return "Failed to upload XML: " + e.getMessage();
        }
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public List<UploadLog> getUploadLogs() {
        return logRepo.findAll();
    }
}
