package com.kamyesm.bitsystembackend.Service;

import com.kamyesm.bitsystembackend.DTO.Auth.ChangeStaffRoleRequest;
import com.kamyesm.bitsystembackend.DTO.Auth.OTPVerifyRequest;
import com.kamyesm.bitsystembackend.DTO.Auth.VerifyOTPResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface AuthAndUserService {
    void sendOTP(String phoneNumber);
    boolean verifyOTP(OTPVerifyRequest request);
    VerifyOTPResponse generateTokenResponse(Authentication authentication);
    boolean changeStaffRole(ChangeStaffRoleRequest request);
}
