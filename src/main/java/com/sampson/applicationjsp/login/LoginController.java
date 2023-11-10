package com.sampson.applicationjsp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

    @Autowired
    private LoginAuthenticationService loginAuthenticationService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/login")
    public String goTologinPage(@RequestParam String name, ModelMap model) {
        model.put("name",name);
        logger.debug("Request param is {}" ,name);
        return "login";
    }

    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String goTologinFormPage() {
        return "loginform";
    }

    @RequestMapping(value = "/loginform", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        if (loginAuthenticationService.authenticate(name,password)) {
            modelMap.put("name",name);
            modelMap.put("password",password);
            return "welcome";
        }
        modelMap.put("errorMessage","Invalid Credentials");
        return "loginform";
    }
}
