package com.aoher.bean.impl;

import com.aoher.bean.EmployeeBean;
import com.aoher.model.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EmployeeBeanImpl implements EmployeeBean {

    @PersistenceContext(unitName = "restPU")
    private EntityManager em;

    public boolean createEmployeeTable(Employee employee) {
        em.persist(employee);
        return true;
    }

    @Override
    public void addEmployee(String name, String address) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        em.persist(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        Query query = em.createQuery("DELETE FROM Employee e WHERE e.id = :id");
        query.setParameter("id", Long.parseLong(id));
        query.executeUpdate();
    }

    @Override
    public void updateEmployee(String id, String name, String address) {
        Query query = em.createQuery("UPDATE Employee e SET e.name = :name, e.address = :address WHERE e.id = :id");
        query.setParameter("id", Long.parseLong(id));
        query.setParameter("name", name);
        query.setParameter("address", address);
        query.executeUpdate();
    }

    @Override
    public Employee getEmployeeById(String id) {
        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.id = :id");
        query.setParameter("id", Long.parseLong(id));
        return (Employee) query.getSingleResult();
    }

    @Override
    public List<Employee> getEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }
}
