package com.didi.communitysupport.utils;

import com.didi.communitysupport.domain.UserEntity;


import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息的验证,在session中获取用户是否登录
 */
public class VERBUtil {
    /**
     * 查看用户是否已经登陆,在session中已经有对象了,传入的参数有一个
     * HttpServletRequest和UserEntity
     *
     * @param request
     * @param u
     * @return 一个boolean
     */
    public static boolean getUserSession(HttpServletRequest request, UserEntity u) {
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        if (u.getUId() == user.getUId()) {
            return true;
        }
        return false;
    }

    /**
     * 存储用户到session中去
     * @param request HttpServletRequest
     * @param u UserEntity
     * @return boolean
     */
    public static void setUserSession(HttpServletRequest request, UserEntity u) {
        request.getSession().setAttribute("user",u);
    }

}
