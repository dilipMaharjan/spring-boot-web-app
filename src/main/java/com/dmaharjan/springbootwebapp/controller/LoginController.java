package com.dmaharjan.springbootwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dmaharjan.springbootwebapp.service.LoginService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes("username")
public class LoginController
{
    LoginService loginservice;

    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, ModelMap model)
    {
        if (loginservice.authenticate(username, password)) {
            model.put("username", username.toUpperCase());
            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials.");
        return "login";
    }
}
