package com.task.accbook.model.web.dto;

import lombok.Data;

/**
 * Канальная модель оклада пользователя
 */
@Data
public class WebSalaryModel {
    /**
     * Идентификатор оклада
     */
    private int id;

    /**
     * Имя пользователя
     */
    private String name;

    /**
     * Оклад пользователя
     */
    private Double salary;
}
