package com.dreamhire.DreamHire.advisor;

import com.dreamhire.DreamHire.exception.NotFoundException;
import com.dreamhire.DreamHire.exception.RejectException;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(false,  e.getMessage(),null,404), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(RejectException.class)
    public ResponseEntity<StandardResponse> handleRejectException(RejectException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(false,  e.getMessage(),null,405), HttpStatus.METHOD_NOT_ALLOWED
        );
    }
}
