package com.event.prototype.exceptions;

import com.event.prototype.data.enums.ErrorCode;
import lombok.Data;

@Data
public abstract class BasicException extends RuntimeException {
    private ErrorCode errorCode;
    private String field;

    public BasicException(ErrorCode errorCode, String message, String field) {
        super(message);
        this.errorCode = errorCode;
        this.field = field;
    }

    public BasicException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
