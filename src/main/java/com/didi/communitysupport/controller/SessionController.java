package com.didi.communitysupport.controller;

import com.didi.communitysupport.domain.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 个人信息验证
 * 登录信息获取	get	/getsession					ok==0表示失败ok==1表示成功user的json
 */
@Controller
public class SessionController {
    @PostMapping("/getsession")
    UserEntity getSession(){
        return new UserEntity();
    }

}
