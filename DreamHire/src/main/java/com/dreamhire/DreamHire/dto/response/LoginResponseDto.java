package com.dreamhire.DreamHire.dto.response;

import com.dreamhire.DreamHire.model.SystemUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String token;
    private SystemUser user;
}
