package com.example.ormsandbox.service.employee;

import com.example.ormsandbox.DTO.EmployeeDTO;
import com.example.ormsandbox.Entity.Employee;
import com.example.ormsandbox.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private IEmployeeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeService(IEmployeeRepository repo) {}
    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employee = this.repository.findAll();
        return employee.stream().map((emp) -> modelMapper.map(emp, EmployeeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findByFirstName(String firstName) {
        List<Employee> employees = this.repository.findByFirstName(firstName);
        return employees.stream().map((emp) -> modelMapper.map(emp,EmployeeDTO.class)).collect(Collectors.toList());
    }
}
