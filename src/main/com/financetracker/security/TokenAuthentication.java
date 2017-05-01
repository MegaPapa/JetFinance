package com.financetracker.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by User on 02.05.2017.
 */

public class TokenAuthentication implements Authentication {

    private String token;
    private Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
    private boolean isAuthenticated;
    private UserDetails principal;
    private Object details;

    public TokenAuthentication(String token, Object details) {
        this.token = token;
        this.details = details;
    }

    public TokenAuthentication(String token) {
        this.token = token;
    }

    public TokenAuthentication() {

    }

    public TokenAuthentication(String token, Collection<GrantedAuthority> authorities, boolean isAuthenticated,
                               UserDetails principal, Object details) {
        this.token = token;
        this.authorities = authorities;
        this.isAuthenticated = isAuthenticated;
        this.principal = principal;
        this.details = details;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Object getCredentials() {
        return null;
    }

    public Object getDetails() {
        return details;
    }

    public String getName() {
        if (principal != null)
            return ((UserDetails) principal).getUsername();
        else
            return null;
    }

    public Object getPrincipal() {
        return principal;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        isAuthenticated = b;
    }

    public String getToken() {
        return token;
    }
}
