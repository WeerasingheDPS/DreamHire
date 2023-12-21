package com.dreamhire.DreamHire.advisor;

import com.dreamhire.DreamHire.dto.error.ErrorDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
import com.dreamhire.DreamHire.exception.DreamHireValidationException;
import com.dreamhire.DreamHire.util.enums.ErrorEnum;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.dreamhire.DreamHire.util.enums.ErrorEnum.ERROR_INVALID_EMAIL_OR_PASSWORD;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DreamHireException.class})
    public ResponseEntity<StandardResponse> handleDreamHireException(DreamHireException ex){

        ErrorDto errorDto = ErrorDto.generateFromDreamHireException(ex);
        HttpStatus httpStatus = ex.getErrorEnum().getHttpStatus() != null ? ex.getErrorEnum().getHttpStatus() : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<StandardResponse>(
               StandardResponse.builder()
                       .success(false)
                       .result(null)
                       .failure(errorDto)
                       .build(),
                httpStatus
        );
    }

    @ExceptionHandler({DreamHireValidationException.class})
    public ResponseEntity<StandardResponse> handleDreamHireValidationException(DreamHireValidationException ex){

        ErrorDto errorDto = ErrorDto.generateFromDreamHireException(ex);
        HttpStatus httpStatus = ex.getErrorEnum().getHttpStatus() != null? ex.getErrorEnum().getHttpStatus() : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<StandardResponse>(
                StandardResponse.builder()
                        .success(false)
                        .result(null)
                        .failure(errorDto)
                        .build(),
                httpStatus
        );
    }

    @ExceptionHandler({SignatureException.class})
    public ResponseEntity<StandardResponse> handleRunTimeException(SignatureException ex){

        ErrorDto errorDto = ErrorDto.builder().description(ex.getMessage()).build();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<StandardResponse>(
                StandardResponse.builder()
                        .success(false)
                        .result(null)
                        .failure(errorDto)
                        .build(),
                httpStatus
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<StandardResponse> handleException(Exception ex){

        ErrorDto errorDto = ErrorDto.builder().description(ex.getMessage()).build();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<StandardResponse>(
                StandardResponse.builder()
                        .success(false)
                        .result(null)
                        .failure(errorDto)
                        .build(),
                httpStatus
        );
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<StandardResponse> handleBadCredentialsException(BadCredentialsException ex){

        ErrorDto errorDto = ErrorDto.generateFromErrorEnum(ERROR_INVALID_EMAIL_OR_PASSWORD);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
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
