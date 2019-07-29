package com.didi.communitysupport.controller;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.enmu.ErrorEnum;
import com.didi.communitysupport.service.LoginService;
import com.didi.communitysupport.utils.Constant;
import com.didi.communitysupport.utils.ResultVOUtil;
import com.didi.communitysupport.utils.VERBUtil;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 写登录注册的接口
 * 注册接口	post	/register	uaccount,upasswd,uname,uage,utel,uoldtype,utype				ok==0表示失败ok==1表示成功
 * 登录接口	post	/login	uaccount,upasswd				ok==0表示失败ok==1表示成功
 */
@RestController
public class LoginControler {
    @Resource
    LoginService loginService;
   // @RequestMapping(value = "/login",method= RequestMethod.GET)

    @PostMapping("/login")
    public ResultVO getlogin(@RequestParam String uaccount,
                             @RequestParam String upasswd, HttpServletRequest request){
        UserEntity user = loginService.isLogin(uaccount,upasswd);
        System.out.println(user);
        if(user != null){
            VERBUtil.setUserSession(request,user);
            System.out.println(request.getSession().getAttribute(Constant.USER_INFO));
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ErrorEnum.E201);
    }
}
