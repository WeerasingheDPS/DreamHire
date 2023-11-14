package com.dreamhire.DreamHire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class RejectException extends RuntimeException {
    public RejectException(String message){
        super(message);
    }
}
