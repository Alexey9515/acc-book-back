package com.task.accbook.model.exception;

import com.task.accbook.core.exception.CommonException;

public class DuplicateSalaryException extends CommonException {
    public DuplicateSalaryException() {
    }

    public DuplicateSalaryException(String message) {
        super(message);
    }

    public DuplicateSalaryException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateSalaryException(Throwable cause) {
        super(cause);
    }

    public DuplicateSalaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
