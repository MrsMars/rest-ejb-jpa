package com.aoher.bean;

import com.aoher.model.Employee;

import java.util.List;

public interface EmployeeBean {

    boolean createEmployeeTable(Employee em);
    void addEmployee(String name, String address);
    void deleteEmployee(String id);
    void updateEmployee(String id, String name, String address);
    Employee getEmployeeById(String id);
    List<Employee> getEmployees();
}
