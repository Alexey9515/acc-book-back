package com.task.accbook.model.web.service;

import com.task.accbook.core.orika.mapper.Mapper;
import com.task.accbook.model.entity.SalaryModel;
import com.task.accbook.model.service.SalaryService;
import com.task.accbook.model.web.dto.SalaryRequest;
import com.task.accbook.model.web.dto.WebSalaryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSalaryServiceImpl implements WebSalaryService {

    @Autowired
    public SalaryService salaryService;

    @Autowired
    private Mapper mapper;

    @Override
    public List<WebSalaryModel> getSalaries() {
        return mapper.mapAsList(salaryService.getSalaries(), WebSalaryModel.class);
    }

    @Secured("ROLE_USER")
    @Override
    public WebSalaryModel createSalary(SalaryRequest request) {
        return mapper.map(salaryService.createSalary(request), WebSalaryModel.class);
    }

    @Override
    public WebSalaryModel changeSalary(WebSalaryModel webSalaryModel) {
        SalaryModel salaryModel = mapper.map(webSalaryModel, SalaryModel.class);
        return mapper.map(salaryService.changeSalary(salaryModel), WebSalaryModel.class);
    }

    @Override
    public void delete() {
        salaryService.delete();
    }
}
