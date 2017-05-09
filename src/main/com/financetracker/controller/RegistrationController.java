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
 * Created by User on 09.05.2017.
 */

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/registration")
    public ModelAndView getUserCabinet() {
        try {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/registration");
            return modelAndView;
        }
        catch (Exception e) {
            return null;
        }
    }

}
