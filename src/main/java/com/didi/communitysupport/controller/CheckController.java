package com.didi.communitysupport.controller;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.enmu.ErrorEnum;
import com.didi.communitysupport.service.CheckService;
import com.didi.communitysupport.service.LoginService;
import com.didi.communitysupport.utils.ResultVOUtil;
import com.didi.communitysupport.utils.VERBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 养老预警
 * 获取监测信息	get	/getcheck					list（blood）list（jump）list（weught）list（keepage）的json
 */
@RestController
public class CheckController {
    @Resource
    CheckService checkService;
    @Resource
    LoginService loginService;
    @GetMapping("/getcheck")
    public ResultVO check(HttpServletRequest request){
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println(user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        user= loginService.isLogin(user.getUAccount(),null);
        Map json = checkService.check(user.getUId());

        return ResultVOUtil.success(json);
    }
}
