package com.dmaharjan.springbootwebapp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService
{
    public boolean authenticate(String username, String password)
    {
        return (username.equalsIgnoreCase("dilip") || username.equalsIgnoreCase("crazdrms"))
            && password.equalsIgnoreCase("dilip");
    }

}
