package com.kamyesm.bitsystembackend.Security;

import com.kamyesm.bitsystembackend.DTO.Auth.OTPVerifyRequest;
import com.kamyesm.bitsystembackend.Service.AuthAndUserService;
import com.kamyesm.bitsystembackend.Service.Implemention.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {

    private final AuthAndUserService authService;
    private final CustomUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OtpAuthenticationToken token = (OtpAuthenticationToken) authentication;

        String phoneNumber = token.getPrincipal().toString();
        String otpCode = token.getCredentials().toString();

        boolean res = authService.verifyOTP(new OTPVerifyRequest(phoneNumber , otpCode));

        if (!res) {
            throw new BadCredentialsException("کد موقت صحیح نمیباشد");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(phoneNumber);

        return new OtpAuthenticationToken(userDetails , userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OtpAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
