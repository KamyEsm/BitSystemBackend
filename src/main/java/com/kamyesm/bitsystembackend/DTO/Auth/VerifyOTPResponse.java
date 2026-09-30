package com.kamyesm.bitsystembackend.DTO.Auth;

import com.kamyesm.bitsystembackend.Utils.Enum.TokenType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VerifyOTPResponse {
    private String token;
    private TokenType tokenType;
}
