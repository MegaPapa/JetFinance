package com.financetracker.dao.impl;

import com.financetracker.bean.Role;
import com.financetracker.bean.StockTickers;
import com.financetracker.bean.User;
import com.financetracker.dao.UserDAO;
import com.financetracker.dao.exception.DAOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by User on 13.03.2017.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private final static int USER_ROLE_INDEX = 1;
    private final static String QUERY_GET_TICKER_BY_NAME = "from StockTickers where StockTickers.ticker =";
    private final static String QUERY_GET_USER_BY_EMAIL = "from User where User.email = ";
    private final static String QUERY_GET_ALL_USERS = "from User";

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Role role = session.get(Role.class, USER_ROLE_INDEX);
            user.setRoleByRoleId(role);
            System.out.println(user.getId());
            session.save(user);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public void addStockTicker(int userId, String tickerName) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.load(User.class, userId);
            StockTickers ticker = (StockTickers) session.createQuery(
                    QUERY_GET_TICKER_BY_NAME + tickerName
            ).getSingleResult();
            user.getTickers().add(ticker);
            session.save(user);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public User getUserById(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.get(User.class, id);
            if (user == null) {
                throw new DAOException("User with id = " + id + " not found");
            }
            return user;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public User getUserByEmail(String email) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = (User) session.createQuery(QUERY_GET_USER_BY_EMAIL + email).getSingleResult();
            if (user == null) {
                throw new DAOException("User with email '" + email + "' not found.");
            }
            return user;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public Set<StockTickers> getUserTickers(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.get(User.class, id);
            if (user == null) {
                throw new DAOException("User with id = " + id + " not found.");
            }
            Set<StockTickers> userTickers = user.getTickers();
            return userTickers;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public Role getRoleByName(String roleName) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Role role = (Role) session.createQuery(
                    "from Role where Role.roleName = " + roleName
            ).getSingleResult();
            return role;
        }
        catch (Exception exception) {
            throw new DAOException(exception);
        }
    }

    public void UpdateUser(User newUserInfo, int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User oldUser = session.load(User.class, id);
            oldUser = newUserInfo;
            session.merge(oldUser);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open new session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + id);
        }
    }

    public void setUserStatus(int id, boolean status) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.get(User.class, id);
            if (user == null) {
                throw new DAOException("User with id = " + id + " not found.");
            }
            user.setIsActive(status);
            session.update(user);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public List<User> getAllUsers() throws DAOException  {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<User> users = session.createQuery(
                    QUERY_GET_ALL_USERS
            ).list();
            return users;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }
}
