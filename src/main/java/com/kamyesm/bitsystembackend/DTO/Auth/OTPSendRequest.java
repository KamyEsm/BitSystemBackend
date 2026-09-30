package com.kamyesm.bitsystembackend.DTO.Auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OTPSendRequest {

    @NotBlank(message = "شماره موبایل الزامی است")
    @Pattern(
            regexp = "^(\\+98|0|0098|98)?9\\d{9}$",
            message = "فرمت شماره موبایل وارد شده صحیح نمی‌باشد"
    )
    private String phoneNumber;
}
