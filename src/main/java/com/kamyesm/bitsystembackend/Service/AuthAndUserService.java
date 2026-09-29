package com.kamyesm.bitsystembackend.Service;

import com.kamyesm.bitsystembackend.DTO.Auth.ChangeStaffRoleRequest;
import com.kamyesm.bitsystembackend.DTO.Auth.OTPVerifyRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthAndUserService {
    void sendOTP(String phoneNumber);
    boolean verifyOTP(OTPVerifyRequest request);
    boolean changeStaffRole(ChangeStaffRoleRequest request);
}
