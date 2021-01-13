package com.paypal.bfs.test.employeeserv.dao;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@EnableTransactionManagement
@EntityScan(basePackageClasses = com.paypal.bfs.test.employeeserv.api.model.Employee.class)
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Employee getbyId(Integer id) {

        return entityManager.find(Employee.class,id);
    }

    @Override
    @Transactional
    public Integer save(Employee employee) {
        entityManager.persist(employee);
        return employee.getId();
    }
}
