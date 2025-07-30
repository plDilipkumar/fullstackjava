package com.example.fileupload.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.example.fileupload.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class EmployeeSAXHandler extends DefaultHandler {

    private List<Employee> empList = new ArrayList<>();
    private Employee emp;
    private StringBuilder data;

    public List<Employee> getEmployees() {
        return empList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("employee")) {
            emp = new Employee();
        }
        data = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("name")) {
            emp.setName(data.toString());
        } else if (qName.equalsIgnoreCase("role")) {
            emp.setRole(data.toString());
        } else if (qName.equalsIgnoreCase("salary")) {
            emp.setSalary(Double.parseDouble(data.toString()));
        } else if (qName.equalsIgnoreCase("employee")) {
            empList.add(emp);
        }
    }
}
