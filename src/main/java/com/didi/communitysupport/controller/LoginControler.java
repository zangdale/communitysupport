package com.didi.communitysupport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 写登录注册的接口
 * 注册接口	post	/register	uaccount,upasswd,uname,uage,utel,uoldtype,utype				ok==0表示失败ok==1表示成功
 * 登录接口	post	/login	uaccount,upasswd				ok==0表示失败ok==1表示成功
 */
@Controller
public class LoginControler {

    @RequestMapping(value = "/login")
    @ResponseBody
    public String getlogin(){
        return "ok=0";
    }
}
