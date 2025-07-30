package com.example.fileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fileupload.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
