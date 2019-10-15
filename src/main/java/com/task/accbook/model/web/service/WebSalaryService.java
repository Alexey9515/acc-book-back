package com.task.accbook.model.web.service;

import com.task.accbook.model.web.dto.SalaryRequest;
import com.task.accbook.model.web.dto.WebSalaryModel;

import java.util.List;

public interface WebSalaryService {

    List<WebSalaryModel> getSalaries();

    WebSalaryModel createSalary(SalaryRequest newSalaryRequest);

    WebSalaryModel changeSalary(WebSalaryModel webSalaryModel);

    void delete();
}
