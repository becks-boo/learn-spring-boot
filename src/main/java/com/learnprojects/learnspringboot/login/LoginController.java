package com.learnprojects.learnspringboot.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());;
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping("login")
    public String goToLogin(@RequestParam String name, @RequestParam String password) {

        if (authenticationService.authenticate(name, password)) {
            logger.debug(name);
            logger.info("I want this printed at info level");
            logger.warn("I want this printed at warn level");
            return "Welcome to the page!";
        }

        return "Password not valid";
    }

/*    @RequestMapping(value="login", method = RequestMethod.GET)
    public String goToLogin() {
        return "Welcome to the page!";
    }*/
}
