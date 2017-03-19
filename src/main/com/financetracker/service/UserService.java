package com.financetracker.service;

import com.financetracker.bean.User;

import java.util.Collection;

/**
 * Created by User on 14.03.2017.
 */
public interface UserService {

    void registration(User user);
    User getUser(int id);
    Collection<User> getAllUsers();
}
