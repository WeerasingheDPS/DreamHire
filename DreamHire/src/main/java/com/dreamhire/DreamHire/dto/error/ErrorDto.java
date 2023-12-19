package com.dreamhire.DreamHire.dto.error;

import com.dreamhire.DreamHire.exception.DreamHireException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private int errorId;

    private String errorCode;

    private String description;


    public static  ErrorDto generateFromDreamHireException(final DreamHireException ex){
        var error = ErrorDto.builder();

        error.errorCode(ex.getErrorCode())
                .description(StringUtils.hasText(ex.getDescription())? ex.getDescription(): ex.getMessage())
                .errorId(!ObjectUtils.isEmpty(ex.getErrorEnum().getErrorId())? ex.getErrorEnum().getErrorId() : 0);

        return error.build();
    }
}
