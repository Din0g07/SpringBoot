package com.dinogo.springboot.dao;

import com.dinogo.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);


    void deleteEmployee(int id);
}
