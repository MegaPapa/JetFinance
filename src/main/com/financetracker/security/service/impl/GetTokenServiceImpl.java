package com.financetracker.security.service.impl;

import com.financetracker.security.service.GetTokenService;
import com.financetracker.security.service.exception.AuthenticationException;
import com.financetracker.security.util.SecurityUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 02.05.2017.
 */

@Service
public class GetTokenServiceImpl implements GetTokenService {

    private final static String TOKEN_KEY = "finance_tracker";
    private final static String EMAIL = "EMAIL";
    private final static String USER_ID = "USER_ID";
    private final static String EXPIRATION_DATE = "TOKEN_EXPIRATION_DATE";

    private UserDetailsService userDetailsService;

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String getToken(String email, String password) throws AuthenticationException {

        if (email == null || password == null) {
            return null;
        }

        SecurityUser user;
        try {
            user = (SecurityUser) userDetailsService.loadUserByUsername(email);
        } catch (UsernameNotFoundException exception) {
            throw new AuthenticationException("No user with suh email!", exception);
        }

        Map<String, Object> tokenData = new HashMap<String, Object>();

        if (password.equals(user.getPassword())) {
            tokenData.put(USER_ID, user.getId());
            tokenData.put(EMAIL, user.getUsername());

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 100);
            tokenData.put(EXPIRATION_DATE, calendar.getTime());

            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);

            return jwtBuilder.signWith(SignatureAlgorithm.HS512, TOKEN_KEY).compact();
        } else {
            throw new AuthenticationException("Wrong password!");
        }
    }
}
