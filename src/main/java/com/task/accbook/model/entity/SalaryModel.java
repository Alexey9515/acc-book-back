package com.task.accbook.model.entity;

import lombok.Data;

/**
 * Доменная модель оклада пользователя
 */
@Data
public class SalaryModel {
    /**
     * Идентификатор оклада
     */
    private int id;

    /**
     * Идентификатор пользователя
     */
    private int userId;

    /**
     * Имя пользователя
     */
    private String name;

    /**
     * Оклад пользователя
     */
    private Double salary;
}
