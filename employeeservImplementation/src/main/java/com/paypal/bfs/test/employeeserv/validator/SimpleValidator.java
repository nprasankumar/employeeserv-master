package com.paypal.bfs.test.employeeserv.validator;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Primary
public class SimpleValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.getErrorCount() == 0) {

            Employee emp = (Employee) target;
            if (emp.getFirstName() == null ||
            emp.getLastName() ==null  ) {

                errors.reject("100",

                        "FirstName/lastname can not be null");

            } else if (emp.getAddress()==null) {

                errors.reject("101",

                        "address can not be null");

            }

        }

    }

}