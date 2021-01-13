package com.paypal.bsf.unittest.test.employeeserv.controller;

import com.paypal.bfs.test.employeeserv.EmployeeservApplication;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = EmployeeservApplication.class)
public class EmployeeResourceControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private EmployeeResourceImpl employeeResource;

    @Before
    public void setUp(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(
                get("/v1/bfs/employees/1")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void testPut() throws Exception {
        when(employeeResource.createEmployee(any(Employee.class))).thenReturn( new ResponseEntity<>(1, HttpStatus.CREATED));
        mockMvc.perform(
                post("/v1/bfs/employees")
                        .content("{\n" +
                                "  \"last_name\": \"ut aute adipisicing\",\n" +
                                "    \"address\":{\n" +
                                "  \"line1\": \"ullamco sit\",\n" +
                                "  \"state\": \"eius\",\n" +
                                "  \"country\": \"in adipisicing ea a\",\n" +
                                "  \"zip_code\": \"eiusmod fugiat\",\n" +
                                "  \"city\": \"et aliquip incididunt culpa laborum\",\n" +
                                "  \"line2\": \"dolor ex\"\n" +
                                "},\n" +
                                "  \"date_of_birth\": \"1941-06-08\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }


}