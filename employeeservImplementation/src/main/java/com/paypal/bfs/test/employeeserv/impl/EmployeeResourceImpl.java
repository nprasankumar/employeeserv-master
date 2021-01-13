package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;
import com.paypal.bfs.test.employeeserv.exception.ResourceNotFound;
import com.paypal.bfs.test.employeeserv.validator.SimpleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SimpleValidator simpleValidator;

    @InitBinder(value = "employee")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(simpleValidator);
    }

    @Override
    public ResponseEntity<Employee> employeeGetById(String id)  {
        Employee response = employeeDao.getbyId(Integer.valueOf(id));
        if(response==null) throw new ResourceNotFound("Employee id not found");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override

    public ResponseEntity<Integer> createEmployee(@Validated Employee employee) {

        Integer id = employeeDao.save(employee);
        return  new ResponseEntity<>(id,HttpStatus.CREATED);
    }
}
