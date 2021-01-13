package com.paypal.bfs.test.employeeserv.dao;

import com.paypal.bfs.test.employeeserv.api.model.Employee;


public interface EmployeeDao {
    public Employee getbyId(Integer id);

    public Integer save(Employee employee);

}
