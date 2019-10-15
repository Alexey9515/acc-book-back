package com.task.accbook.integration;

import com.task.accbook.model.entity.SalaryModel;
import com.task.accbook.model.repository.SalaryDao;
import com.task.accbook.model.web.dto.SalaryRequest;
import com.task.accbook.model.web.dto.WebSalaryModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalaryControllerTests {

    private static final String REST_PATH = "/users/salaries";

    @MockBean
    private SalaryDao salaryDao;

    @Autowired
    TestRestTemplate restTemplate;

    @Before
    public void init() {
        restTemplate = restTemplate.withBasicAuth("USER", "USER");
    }

    @Test
    public void create() {
        String name = "Test " + UUID.randomUUID().toString();
        Double salaryValue = 110D;

        SalaryRequest salaryRequest = new SalaryRequest();
        salaryRequest.setName(name);
        salaryRequest.setSalary(salaryValue);

        SalaryModel salaryModel = new SalaryModel();
        salaryModel.setName(name);
        salaryModel.setSalary(salaryValue);
        salaryModel.setUserId(1);
        salaryModel.setId(2);

        Mockito.when(salaryDao.create(salaryRequest)).thenReturn(salaryModel);

        ResponseEntity<WebSalaryModel> response = restTemplate.exchange(REST_PATH
                , HttpMethod.POST
                , new HttpEntity<>(salaryRequest)
                , WebSalaryModel.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        WebSalaryModel salary = response.getBody();

        assertNotNull(salary);
        assertEquals(name, salary.getName());
        assertEquals(salaryValue, salary.getSalary());
        assertEquals(2, salary.getId());
    }

    @Test
    public void createNegative() {
        String name = "Test " + UUID.randomUUID().toString();
        Double salaryValue = 110D;

        SalaryRequest salaryRequest = new SalaryRequest();
        salaryRequest.setName(name);
        salaryRequest.setSalary(salaryValue);

        SalaryModel salaryModel = new SalaryModel();
        salaryModel.setName(name);
        salaryModel.setSalary(salaryValue);
        salaryModel.setUserId(1);
        salaryModel.setId(2);

        Mockito.when(salaryDao.isExist(salaryRequest.getName())).thenReturn(true);

        ResponseEntity<WebSalaryModel> response = restTemplate.exchange(REST_PATH
                , HttpMethod.POST
                , new HttpEntity<>(salaryRequest)
                , WebSalaryModel.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
