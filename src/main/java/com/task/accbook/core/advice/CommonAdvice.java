package com.task.accbook.core.advice;

import com.task.accbook.core.exception.CommonException;
import com.task.accbook.core.web.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class CommonAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(CommonAdvice.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CommonException.class)
    public ErrorDto errorHandler(CommonException e) {
        LOG.error("Ошибка на сервере");
        LOG.error(Arrays.toString(e.getStackTrace()));
        return new ErrorDto(e.getMessage());
    }
}