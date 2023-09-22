package com.learnprojects.learnspringboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public String sayHelloAgain() {
        return "TEST TEST";
    }
}
