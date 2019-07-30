package com.didi.communitysupport.controller;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.enmu.ErrorEnum;
import com.didi.communitysupport.utils.Constant;
import com.didi.communitysupport.utils.ResultVOUtil;
import com.didi.communitysupport.utils.VERBUtil;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 个人信息验证
 * 登录信息获取	get	/getsession					ok==0表示失败ok==1表示成功user的json
 */
@RestController
public class SessionController {
    /**
     * 返回登录用户的user信息
     *
     * @param request
     * @return
     */
    @GetMapping("/getsession")
    public ResultVO getSession(HttpServletRequest request) {
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println("/getsession"+user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }else{
            user.setUPasswd(Constant.NULL_INFO);
            user.setUAge(Constant.USERAGE_INFO);
            user.setUOldtype(Constant.NULL_INFO);
            user.setUTel(Constant.NULL_INFO);
            user.setUType(Constant.NULL_INFO);
        }
        return ResultVOUtil.success(user);
    }

}
