package com.kamyesm.bitsystembackend.Controller;

import com.kamyesm.bitsystembackend.DTO.Auth.OTPSendRequest;
import com.kamyesm.bitsystembackend.DTO.Auth.OTPVerifyRequest;
import com.kamyesm.bitsystembackend.DTO.Auth.VerifyOTPResponse;
import com.kamyesm.bitsystembackend.Security.OtpAuthenticationToken;
import com.kamyesm.bitsystembackend.Service.AuthAndUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/shop/auth")
@RequiredArgsConstructor
public class ShopAuthController {

    private final AuthenticationManager manager;
    private final AuthAndUserService authService;


    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOTP(@RequestBody @Valid OTPSendRequest request) {
        authService.sendOTP(request.getPhoneNumber());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<VerifyOTPResponse> verifyOTP(@RequestBody @Valid OTPVerifyRequest request){
        Authentication authentication = manager.authenticate(new OtpAuthenticationToken(request.getPhoneNumber() , request.getOTPCode()));
        VerifyOTPResponse res = authService.generateTokenResponse(authentication);
        return ResponseEntity.ok(res);
    }

}
