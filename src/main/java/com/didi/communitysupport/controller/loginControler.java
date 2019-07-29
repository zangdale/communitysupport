package com.didi.communitysupport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginControler {
    @RequestMapping("/login")
    public String getlogin(){

        return "ok=0";
    }
}
