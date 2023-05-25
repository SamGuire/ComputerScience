package com.example.ormsandbox.service.employee;

import com.example.ormsandbox.DTO.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> findAllEmployees();
    List<EmployeeDTO> findByFirstName(String firstName);
}
