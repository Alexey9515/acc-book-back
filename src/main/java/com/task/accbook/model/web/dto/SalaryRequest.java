package com.task.accbook.model.web.dto;

import lombok.Data;

/**
 * Модель запроса на создание новой записи
 */
@Data
public class SalaryRequest {

    /**
     * Имя пользователя
     */
    private String name;

    /**
     * Оклад пользователя
     */
    private Double salary;
}
