package com.financetracker.controller;

import com.financetracker.bean.UserBean;
import com.financetracker.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 13.03.2017.
 */

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/cabinet/{id}")
    public ModelAndView getUserCabinet(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/cabinet");
        modelAndView.addObject("user",userDAO.getUserById(id));
        return modelAndView;
    }
}
