package com.dreamhire.DreamHire.util.enums;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public enum ErrorEnum {

    ERROR_DUPLICATE_EMAIL(40001,"ERROR_DUPLICATE_EMAIL", "Duplicate Email:", HttpStatus.BAD_REQUEST),
    ERROR_CODE_2(20,"002", "Error description 2", HttpStatus.NOT_FOUND),

    ;
    // Add more error codes as needed

    @Getter
    @Setter
    private int errorId;
    // Getter methods
    @Setter
    @Getter
    private String errorCode;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private HttpStatus httpStatus;

    // Constructor for the enum
    ErrorEnum(int errorId, String errorCode, String description, HttpStatus httpStatus) {
        this.errorId = errorId;
        this.errorCode = errorCode;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    ErrorEnum(String errorCode, String description, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    private static Map<String, ErrorEnum> map;
    // Static block to initialize the map
    static {
        map = new HashMap<>();
        for (ErrorEnum error : ErrorEnum.values()) {
            map.put(error.getErrorCode(), error);
        }
    }

    // Method to get ErrorEnum by errorCode
    public static ErrorEnum getByErrorCode(String errorCode) {
        return map.get(errorCode);
    }

}
