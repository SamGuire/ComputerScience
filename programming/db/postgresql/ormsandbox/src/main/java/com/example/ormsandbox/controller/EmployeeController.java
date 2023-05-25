package com.example.ormsandbox.controller;


import com.example.ormsandbox.DTO.EmployeeDTO;
import com.example.ormsandbox.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    public EmployeeController(){}
    @GetMapping("/")
    public List<EmployeeDTO> getAllEmployee() {
        return service.findAllEmployees();
    }
    @GetMapping("/{firstName}")
    public List<EmployeeDTO> getAllEmployeeByFirstName(@PathVariable("firstName") String firstName) {
        return service.findByFirstName(firstName);
    }

}
