package com.task.accbook.modul;

import com.task.accbook.model.entity.SalaryModel;
import com.task.accbook.model.repository.SalaryDao;
import com.task.accbook.model.service.SalaryService;
import com.task.accbook.model.web.dto.SalaryRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
public class SalaryTests {

    @Autowired
    private SalaryService salaryService;

    @Test
    public void create() {
        String name = "Test " + UUID.randomUUID().toString();
        Double salaryValue = 110D;

        SalaryRequest salaryRequest = new SalaryRequest();
        salaryRequest.setName(name);
        salaryRequest.setSalary(salaryValue);

        SalaryModel salary = salaryService.createSalary(salaryRequest);

        assertNotNull(salary);
        assertEquals(name, salary.getName());
        assertEquals(salaryValue, salary.getSalary());
        assertNotEquals(0, salary.getId());
        assertNotEquals(0, salary.getUserId());
    }

}
