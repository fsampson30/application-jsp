package com.sampson.applicationjsp.login;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isValidUserName = username.equalsIgnoreCase("flavio");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");
        return isValidUserName && isValidPassword;
    }
}
