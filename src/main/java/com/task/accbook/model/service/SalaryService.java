package com.task.accbook.model.service;

import com.task.accbook.model.entity.SalaryModel;
import com.task.accbook.model.web.dto.SalaryRequest;

import java.util.List;

public interface SalaryService {
    List<SalaryModel> getSalaries();

    SalaryModel createSalary(SalaryRequest request);

    SalaryModel changeSalary(SalaryModel salaryModel);

    void delete();
}
