package com.didi.communitysupport.service;

import com.didi.communitysupport.domain.UserEntity;

public interface LoginService {
    /**
     * 验证是否存在该用户，存在返回1，否则返回0
     * @param account
     * @param password
     * @return
     */
    UserEntity isLogin(String account, String password);
}
