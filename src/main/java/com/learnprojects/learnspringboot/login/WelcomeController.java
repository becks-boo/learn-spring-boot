package com.learnprojects.learnspringboot.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    // In the tutorial he uses a login form and after clicking submit button, it's redirected to welcome jsp view
    @RequestMapping(value = "testtest", method = RequestMethod.POST)
    @ResponseBody
    public String goToLoginPage(@RequestParam String name, @RequestParam String password, HashMap model) {
        /*if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            // In the tutorial password is removed from here.
            model.put("password", password);

            return model.get(name) + " " + model.get(password);
            // jsp - return "welcome" instead
        }*/
        //TODO (Q) - How can I send general error messages (not system.exception messages)?
        return "Works";
        // jsp - return "login" instead
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}
