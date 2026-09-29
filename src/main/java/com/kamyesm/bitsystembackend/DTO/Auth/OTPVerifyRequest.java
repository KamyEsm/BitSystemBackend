package com.kamyesm.bitsystembackend.DTO.Auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OTPVerifyRequest {

    @NotBlank(message = "شماره موبایل الزامی است")
    @Pattern(
            regexp = "^(\\+98|0|0098|98)?9\\d{9}$",
            message = "فرمت شماره موبایل وارد شده صحیح نمی‌باشد"
    )
    private String phoneNumber;

    @NotBlank(message = "کد تایید الزامی است")
    private String OTPCode;
}
