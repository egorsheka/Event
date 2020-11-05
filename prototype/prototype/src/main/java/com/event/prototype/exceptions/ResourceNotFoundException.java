package com.event.prototype.exceptions;

import com.event.prototype.data.enums.ErrorCode;
import lombok.Data;

/**
 * Exception that rises when specific resource (usually backed by specific entity) is not found.
 */
@Data
public class ResourceNotFoundException extends BasicException {
    public ResourceNotFoundException(ErrorCode errorCode, String message, String fieldName) {
        super(errorCode, message, fieldName);
    }

    public ResourceNotFoundException(String message) {
        super(ErrorCode.RESOURCE_NOT_FOUND, message);
    }

    public ResourceNotFoundException(ErrorCode errorCode, Class<?> resourceClass, Object resourceId, String fieldName) {
        this(errorCode, String.format("%s with id %s was not found", resourceClass.getSimpleName(), resourceId), fieldName);
    }

    public ResourceNotFoundException(Class<?> resourceClass, Object resourceId, String fieldName) {
        this(ErrorCode.RESOURCE_NOT_FOUND, String.format("%s with id %s was not found", resourceClass.getSimpleName(), resourceId),
                fieldName);
    }

    public ResourceNotFoundException(String resourceClass, Object resourceId, String fieldName) {
        this(ErrorCode.RESOURCE_NOT_FOUND, String.format("%s with id %s was not found", resourceClass, resourceId),
                fieldName);
    }
}
