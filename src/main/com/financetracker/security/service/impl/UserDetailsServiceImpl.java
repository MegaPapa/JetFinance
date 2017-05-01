package com.financetracker.security.service.impl;

import com.financetracker.bean.Role;
import com.financetracker.bean.User;
import com.financetracker.security.util.SecurityUser;
import com.financetracker.service.UserService;
import com.financetracker.service.exception.ServiceException;
import com.financetracker.service.exchanger.DataExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 02.05.2017.
 */

@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public SecurityUser loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        try {
            userEmail = URLDecoder.decode(userEmail, "UTF-8");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        User user = null;

        try {
            user = DataExchanger.exchangeUser(userService.getUserByEmail(userEmail));
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new UsernameNotFoundException("User " + userEmail + " not found!");
        }

        List<GrantedAuthority> authorities = getUserRoles(user);

        return new SecurityUser(user.getEmail(), user.getPassword(), user.getId(),
                !user.getIsActive(), true, true, true, authorities);

    }

    private List<GrantedAuthority> getUserRoles(User user) {
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
        Role role = user.getRoleByRoleId();
        return result;
    }
}