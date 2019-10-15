package com.task.accbook.api;

import com.task.accbook.model.web.dto.SalaryRequest;
import com.task.accbook.model.web.dto.WebSalaryModel;
import com.task.accbook.model.web.service.WebSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users/salaries")
public class SalaryController {

    @Autowired
    private WebSalaryService webSalaryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<WebSalaryModel> getSalaries() {
        return webSalaryService.getSalaries();
    }

    @RequestMapping(method = RequestMethod.POST)
    public WebSalaryModel createSalary(@RequestBody SalaryRequest newSalaryRequest) {
        return webSalaryService.createSalary(newSalaryRequest);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public WebSalaryModel changeSalary(@RequestBody WebSalaryModel webSalaryModel) {
        return webSalaryService.changeSalary(webSalaryModel);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete() {
        webSalaryService.delete();
    }
}
