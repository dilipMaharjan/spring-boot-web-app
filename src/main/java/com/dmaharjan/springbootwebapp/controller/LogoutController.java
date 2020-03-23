package com.dmaharjan.springbootwebapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LogoutController
{
    @GetMapping("/")
    public String welcome(ModelMap model)
    {
        model.put("username", formatUsername(getLoggedInUsername(model)));
        return "welcome";
    }

    private String getLoggedInUsername(ModelMap model)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();

        }
        return principal.toString();
    }

    private String formatUsername(String username)
    {
        return username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase();
    }
}
