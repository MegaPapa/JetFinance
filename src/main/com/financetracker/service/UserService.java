package com.financetracker.service;

import com.financetracker.bean.User;
import com.financetracker.dto.CompanyDTO;
import com.financetracker.dto.UserDTO;
import com.financetracker.service.exception.ServiceException;

import java.util.Collection;
import java.util.Set;

/**
 * Created by User on 14.03.2017.
 */
public interface UserService {

    void registration(UserDTO user) throws ServiceException;
    void addStockTicker(int userId, String ticket) throws ServiceException;

    UserDTO getUserById(int id) throws ServiceException;
    UserDTO getUserByEmail(String email) throws ServiceException;
    Set<CompanyDTO> getUserTickers(int id) throws ServiceException;
    Collection<UserDTO> getAllUsers() throws ServiceException;

    void UpdateUser(UserDTO newUserInfo, int id) throws ServiceException;
    void setUserStatus(int id, boolean status) throws ServiceException;
}
