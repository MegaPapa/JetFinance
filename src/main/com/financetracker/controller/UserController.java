package com.financetracker.controller;

import com.financetracker.service.UserService;
import com.financetracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by User on 13.03.2017.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize(value = "hasAuthority('admin')")
    @RequestMapping("/cabinet/{id}")
    public ModelAndView getUserCabinet(@PathVariable int id) {
        try {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/cabinet");
            modelAndView.addObject("user", userService.getUserById(id));
            return modelAndView;
        }
        catch (ServiceException exception) {
            return null;
        }
    }
}
