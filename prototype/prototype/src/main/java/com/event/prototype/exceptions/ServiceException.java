package com.event.prototype.exceptions;


import com.event.prototype.data.enums.ErrorCode;

public class ServiceException extends BasicException{

    public ServiceException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ServiceException(String message) {
        super(ErrorCode.SERVICE_EXCEPTION, message, null);
    }

    public ServiceException(Class<?> resourceClass, Object resourceId) {
        this(ErrorCode.RESOURCE_NOT_FOUND,
                String.format("%s with id %s was not found", resourceClass.getSimpleName(), resourceId));
    }
}
