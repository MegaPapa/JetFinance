package com.financetracker.security;

import com.financetracker.security.util.SecurityUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.Date;

/**
 * Created by User on 02.05.2017.
 */

public class TokenAuthenticationManager implements AuthenticationManager {

    private final static String TOKEN_KEY = "finance_tracker";
    private final static String EXPIRATION_DATE = "TOKEN_EXPIRATION_DATE";
    private final static String EMAIL = "EMAIL";

    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {

            if (authentication instanceof TokenAuthentication) {
                return processAuthentication((TokenAuthentication) authentication);
            } else {
                authentication.setAuthenticated(false);
                return authentication;
            }

        } catch (Exception exception) {
            if ( exception instanceof AuthenticationServiceException) {
                try {
                    throw exception;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    private TokenAuthentication processAuthentication(TokenAuthentication tokenAuthentication)
            throws AuthenticationException {
        String token = tokenAuthentication.getToken();
        DefaultClaims claims;

        try {
            claims = (DefaultClaims) Jwts.parser().setSigningKey(TOKEN_KEY).parse(token).getBody();
        } catch (Exception ex) {
            throw new AuthenticationServiceException("Token corrupted");
        }

        Long date = claims.get(EXPIRATION_DATE, Long.class);

        if (date == null) {
            throw new AuthenticationServiceException("Invalid token");
        }

        Date expiredDate = new Date(date);

        if (!expiredDate.after(new Date())) {
            throw new AuthenticationServiceException("Token expired date error");
        }
        return buildFullTokenAuthentication(tokenAuthentication, claims);
    }

    private TokenAuthentication buildFullTokenAuthentication(TokenAuthentication authentication, DefaultClaims claims)
            throws AuthenticationServiceException {
        SecurityUser user = (SecurityUser) userDetailsService.loadUserByUsername(claims.get(EMAIL, String.class));

        if (!user.isEnabled()) {
            throw new AuthenticationServiceException("User disabled");
        }

        Collection<GrantedAuthority> authorities = user.getAuthorities();
        return new TokenAuthentication(authentication.getToken(), authorities, true, user, user.getId());
    }
}
