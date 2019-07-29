package com.didi.communitysupport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginControler {

    @RequestMapping(value = "/login")
    @ResponseBody
    public String getlogin(){
        return "ok=0";
    }
}
