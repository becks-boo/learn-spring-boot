package com.learnprojects.learnspringboot.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("login")
    public String goToLogin(@RequestParam String name) {

        logger.debug(name);
        logger.info("I want this printed at info level");
        logger.warn("I want this printed at warn level");
        return "Welcome to the page!";
    }
}
