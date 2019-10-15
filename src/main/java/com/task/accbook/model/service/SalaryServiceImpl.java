package com.task.accbook.model.service;

import com.task.accbook.model.entity.SalaryModel;
import com.task.accbook.model.exception.DuplicateSalaryException;
import com.task.accbook.model.exception.UpdateSalaryException;
import com.task.accbook.model.repository.SalaryDao;
import com.task.accbook.model.web.dto.SalaryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    private static final Logger LOG = LoggerFactory.getLogger(SalaryServiceImpl.class);

    @Autowired
    public SalaryDao salaryDao;

    @Override
    public List<SalaryModel> getSalaries() {
        return salaryDao.getSalaries();
    }

    @Override
    @Transactional
    public SalaryModel createSalary(SalaryRequest request) {
        if (salaryDao.isExist(request.getName())) {
            throw new DuplicateSalaryException("Пользователь с таким именем уже существует");
        }
        SalaryModel salaryModel = salaryDao.create(request);
        LOG.debug("Создана запись " + salaryModel.toString());
        return salaryModel;
    }

    @Override
    @Transactional
    public SalaryModel changeSalary(SalaryModel salaryModel) {
        SalaryModel update = salaryDao.update(salaryModel);
        if (update == null) {
            throw new UpdateSalaryException("Ошибка изменения оклада");
        }
        LOG.debug("Изменена запись " + update.toString());
        return update;
    }

    @Override
    @Transactional
    public void delete() {
        int delete = salaryDao.delete();
        LOG.debug(String.format("Удалено %s записей", delete));
    }
}
