package com.paypal.bfs.test.employeeserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    private ResponseEntity<Object> buildResponseEntity(MyApiError apiError){
        return  new ResponseEntity<Object>(apiError,apiError.getStatus());
    }
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> handleResourceException(ResourceNotFound ex){
        return buildResponseEntity(new MyApiError(HttpStatus.NOT_FOUND,"Resource Request not found",ex));
    }
}
