package com.task.accbook.model.repository;

import com.task.accbook.db.tables.Salaries;
import com.task.accbook.db.tables.records.SalariesRecord;
import com.task.accbook.db.tables.records.UsersRecord;
import com.task.accbook.model.entity.SalaryModel;
import com.task.accbook.model.web.dto.SalaryRequest;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.task.accbook.db.Sequences.SALARIES_ID_SEQ;
import static com.task.accbook.db.Sequences.USERS_ID_SEQ;
import static com.task.accbook.db.Tables.SALARIES;
import static com.task.accbook.db.Tables.USERS;

@Repository
public class SalaryDao {

    @Autowired
    DSLContext dsl;

    public List<SalaryModel> getSalaries() {
        return dsl.select()
                .from(SALARIES)
                .innerJoin(USERS).on(SALARIES.USER_ID.eq(USERS.ID))
                .fetch(SalaryRecordMapper.INSTANCE);
    }

    public SalaryModel create(SalaryRequest request) {
        UsersRecord usersRecord = dsl.insertInto(USERS)
                .values(USERS_ID_SEQ.nextval(), request.getName())
                .returning().fetchOne();
        SalariesRecord salariesRecord = dsl.insertInto(SALARIES)
                .values(SALARIES_ID_SEQ.nextval(), usersRecord.getId(), request.getSalary())
                .returning()
                .fetchOne();
        SalaryModel salaryModel = new SalaryModel();
        salaryModel.setId(salariesRecord.get(SALARIES.ID));
        salaryModel.setUserId(usersRecord.get(USERS.ID));
        salaryModel.setName(usersRecord.get(USERS.NAME));
        salaryModel.setSalary(salariesRecord.get(SALARIES.VALUE));
        return salaryModel;
    }

    public int delete() {
        dsl.deleteFrom(SALARIES).execute();
        return dsl.deleteFrom(USERS).execute();
    }

    public boolean isExist(String name) {
        return dsl.select()
                .from(USERS)
                .where(USERS.NAME.equalIgnoreCase(name))
                .fetch().size() > 0;
    }

    public SalaryModel update(SalaryModel salaryModel) {
        return dsl.update(SALARIES)
                .set(SALARIES.VALUE, salaryModel.getSalary())
                .where(SALARIES.ID.eq(salaryModel.getId()))
                .execute() > 0 ? salaryModel : null;
    }

    private static class SalaryRecordMapper implements RecordMapper<Record, SalaryModel> {
        static final SalaryRecordMapper INSTANCE = new SalaryRecordMapper();

        @Override
        public SalaryModel map(Record record) {
            SalaryModel salaryModel = new SalaryModel();
            salaryModel.setId(record.get(SALARIES.ID));
            salaryModel.setUserId(record.get(USERS.ID));
            salaryModel.setName(record.get(USERS.NAME));
            salaryModel.setSalary(record.get(SALARIES.VALUE));
            return salaryModel;
        }
    }
}
