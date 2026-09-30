package com.kamyesm.bitsystembackend.Service.Implemention;

import com.kamyesm.bitsystembackend.DTO.Auth.ChangeStaffRoleRequest;
import com.kamyesm.bitsystembackend.DTO.Auth.OTPVerifyRequest;
import com.kamyesm.bitsystembackend.DTO.Auth.VerifyOTPResponse;
import com.kamyesm.bitsystembackend.Service.AuthAndUserService;
import com.kamyesm.bitsystembackend.Service.JWTService;
import com.kamyesm.bitsystembackend.Utils.Enum.CustomerRole;
import com.kamyesm.bitsystembackend.Utils.Enum.TokenType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
public class AuthAndUserServiceImp implements AuthAndUserService {

    private final RedisTemplate<String , String> redisTemplate;
    private final SecureRandom random;
    private final JWTService jwtService;


    @Override
    public void sendOTP(String phoneNumber) {
        int otp = random.nextInt(999999) + 100000;
        log.info("OTP Code : {}" , otp);
        redisTemplate.opsForValue().set("otp:" + phoneNumber , String.valueOf(otp) , Duration.ofMinutes(2));
    }

    @Override
    public boolean verifyOTP(OTPVerifyRequest request) {
        String phone = request.getPhoneNumber();
        String otp = request.getOTPCode();
        String redisKey = "otp:" + phone;
        String otpRedis = redisTemplate.opsForValue().get(redisKey);

        if (Objects.equals(otpRedis, otp)) {
            redisTemplate.delete(redisKey);
            return true;
        }
        return false;
    }

    @Override
    public VerifyOTPResponse generateTokenResponse(Authentication authentication) {
        String token = jwtService.generateToken((UserDetails) authentication.getDetails(), CustomerRole.CUSTOMER.name());
        return new VerifyOTPResponse(token , TokenType.BEARER);
    }

    @Override
    public boolean changeStaffRole(ChangeStaffRoleRequest request) {
        return false;
    }
}
