package com.example.ormsandbox.repository;

import com.example.ormsandbox.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByFirstName(String firstName);
}
