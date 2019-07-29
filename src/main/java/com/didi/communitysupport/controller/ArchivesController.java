package com.didi.communitysupport.controller;

import com.didi.communitysupport.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * 个人档案的接口
 * 获取个人档案	get	/getarchives					user=用户信息和list（ill）的json
 */
@Controller
public class ArchivesController {
    @Resource
    LoginService loginService;


    @GetMapping("/log")
    public String log(){
        System.out.println(loginService);
        System.out.println(loginService.isLogin("2","2"));
        return "";
    }
}
