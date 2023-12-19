package com.dreamhire.DreamHire.advisor;

import com.dreamhire.DreamHire.dto.error.ErrorDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
import com.dreamhire.DreamHire.exception.DreamHireValidationException;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DreamHireException.class)
    public ResponseEntity<StandardResponse> handleDreamHireException(DreamHireException ex){

        ErrorDto errorDto = ErrorDto.generateFromDreamHireException(ex);
        HttpStatus httpStatus = ex.getErrorEnum().getHttpStatus() == null? ex.getErrorEnum().getHttpStatus() : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<StandardResponse>(
               StandardResponse.builder()
                       .success(false)
                       .result(null)
                       .failure(errorDto)
                       .build(),
                httpStatus
        );
    }

    @ExceptionHandler(DreamHireValidationException.class)
    public ResponseEntity<StandardResponse> handleDreamHireValidationException(DreamHireValidationException ex){

        ErrorDto errorDto = ErrorDto.generateFromDreamHireException(ex);
        HttpStatus httpStatus = ex.getErrorEnum().getHttpStatus() == null? ex.getErrorEnum().getHttpStatus() : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<StandardResponse>(
                StandardResponse.builder()
                        .success(false)
                        .result(null)
                        .failure(errorDto)
                        .build(),
                httpStatus
        );
    }
}
