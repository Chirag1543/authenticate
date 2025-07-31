package com.security.oauth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class JwtAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 1L; // Added serialVersionUID for serialization

    private final Object principal; // Typically the username or user details
    private Object credentials; // Typically null for JWT-based authentication

    // Constructor for unauthenticated token
    public JwtAuthentication(Object principal) {
        super(Collections.emptyList());
        this.principal = principal;
        this.credentials = null;
        setAuthenticated(false);
    }

    // Constructor for authenticated token
    public JwtAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}

