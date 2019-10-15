package com.task.accbook.model.exception;

import com.task.accbook.core.exception.CommonException;

public class UpdateSalaryException extends CommonException {
    public UpdateSalaryException() {
    }

    public UpdateSalaryException(String message) {
        super(message);
    }

    public UpdateSalaryException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateSalaryException(Throwable cause) {
        super(cause);
    }

    public UpdateSalaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
