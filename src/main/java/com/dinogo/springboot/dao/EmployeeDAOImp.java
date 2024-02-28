package com.dinogo.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dinogo.springboot.entity.Employee;

import java.util.List;
@Repository
public class EmployeeDAOImp implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("from Employee");

        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee " +
                "where id =:employeeId ");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
