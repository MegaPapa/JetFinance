package com.financetracker.controller;

import com.financetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/cabinet/{id}")
    public ModelAndView getUserCabinet(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/cabinet");
        modelAndView.addObject("user",userService.getUser(id));
        return modelAndView;
    }
}
