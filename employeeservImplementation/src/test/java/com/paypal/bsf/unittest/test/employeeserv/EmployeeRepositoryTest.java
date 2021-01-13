package com.paypal.bsf.unittest.test.employeeserv;

import com.paypal.bfs.test.employeeserv.EmployeeservApplication;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackageClasses = {EmployeeservApplication.class})
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Test
    public void save(){
        Address add=new Address();
        add.setLine1("test line1");
        add.setLine2("test line2");
        add.setCity("somecity");
        add.setCountry("anotherCountry");
        add.setZipCode("9999");
        Employee emp= new Employee();
        emp.setFirstName("fdadd");
        emp.setLastName("ladd");
        emp.setAddress(add);
        employeeDao.save(emp);
        Employee result= employeeDao.getbyId(emp.getId());
        Assert.assertEquals(emp.getFirstName(),result.getFirstName());
        Assert.assertEquals(emp.getLastName(),result.getLastName());
        Assert.assertEquals(emp.getAddress(),result.getAddress());

    }
}
