package com.financetracker.service;

import java.util.Collection;

/**
 * Created by User on 14.03.2017.
 */
public interface UserService {

    void registration(UserBean user);
    UserBean getUser(int id);
    Collection<UserBean> getAllUsers();
}
