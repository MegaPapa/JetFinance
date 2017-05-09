package com.financetracker.service.impl;

import com.financetracker.bean.StockTickers;
import com.financetracker.bean.User;
import com.financetracker.dao.UserDAO;
import com.financetracker.dao.exception.DAOException;
import com.financetracker.dto.CompanyDTO;
import com.financetracker.dto.RoleDTO;
import com.financetracker.dto.UserDTO;
import com.financetracker.service.UserService;
import com.financetracker.service.exception.ServiceException;
import com.financetracker.service.exchanger.DataExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 14.03.2017.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void registration(UserDTO user) throws ServiceException {
        try {
            User userBean = DataExchanger.exchangeUser(user);
            userBean.setIsActive(true);
            userDAO.addUser(userBean);
        }
        catch (DAOException exception) {
            throw new ServiceException("User '" + user.getEmail() + "' is already exist.");
        }
    }

    public void addStockTicker(int userId, String ticket) throws ServiceException {
        try {
            userDAO.addStockTicker(userId, ticket);
        }
        catch (DAOException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public UserDTO getUserById(int id) throws ServiceException {
        try {
            return DataExchanger.exchangeUserToDTO(userDAO.getUserById(id));
        }
        catch (DAOException exception) {
            throw new ServiceException("User with id = " + id + " not found.");
        }
    }

    public RoleDTO getRoleByName(String roleName) throws ServiceException {
        try {
            return DataExchanger.exchangeRoleToRoleDTO(userDAO.getRoleByName(roleName));
        }
        catch (DAOException exception) {
            throw new ServiceException(exception);
        }
    }

    public UserDTO getUserByEmail(String email) throws ServiceException {
        try {
            return DataExchanger.exchangeUserToDTO(userDAO.getUserByEmail(email));
        }
        catch (DAOException exception) {
            throw new ServiceException("User with email '" + email + "' not found.");
        }
    }

    public Set<CompanyDTO> getUserTickers(int id) throws ServiceException {
        try {
            Set<StockTickers> tickers = userDAO.getUserTickers(id);
            Set<CompanyDTO> result = new HashSet<CompanyDTO>();
            for (StockTickers ticker : tickers) {
                result.add(DataExchanger.exchangeStockTickerToDTO(ticker));
            }
            return result;
        }
        catch (DAOException exception) {
            throw new ServiceException("User with id = " + id + " not found.");
        }
    }

    public UserDTO getUser(int id) throws ServiceException {
        try {
            UserDTO user = DataExchanger.exchangeUserToDTO(userDAO.getUserById(id));
            return user;
        }
        catch (DAOException exception) {
            throw new ServiceException("User with id = " + id + " not found.");
        }
    }

    public List<UserDTO> getAllUsers() throws ServiceException {
        try {
            List<User> users = userDAO.getAllUsers();
            List<UserDTO> dtos = new ArrayList<UserDTO>();
            for (User user : users) {
                dtos.add(DataExchanger.exchangeUserToDTO(user));
            }
            return dtos;
        }
        catch (DAOException exception) {
            throw new ServiceException("Can't get all users.");
        }
    }

    public void UpdateUser(UserDTO newUserInfo, int id) throws ServiceException {
        try {
            userDAO.UpdateUser(DataExchanger.exchangeUser(newUserInfo), id);
        }
        catch (DAOException exception) {
            throw new ServiceException("User with id = " + id + " not found.");
        }
    }

    public void setUserStatus(int id, boolean status) throws ServiceException {
        try {
            userDAO.setUserStatus(id, status);
        }
        catch (DAOException exception) {
            throw new ServiceException("User with id = " + id + " not found.");
        }
    }
}
