package com.kamyesm.bitsystembackend.Security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class OtpAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private Object credentials;

    public OtpAuthenticationToken(String phoneNumber, String otpCode) {
        super(null);
        this.principal = phoneNumber;
        this.credentials = otpCode;
        setAuthenticated(false);
    }


    public OtpAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = null;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}