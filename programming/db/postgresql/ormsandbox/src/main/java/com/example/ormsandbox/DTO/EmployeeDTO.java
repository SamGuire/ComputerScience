package com.example.ormsandbox.DTO;

import java.util.Date;

public class EmployeeDTO {
    String firstName;
    String lastName;
    Date hiredDate;
    double salary;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getSalary() {
        return salary;
    }
}
