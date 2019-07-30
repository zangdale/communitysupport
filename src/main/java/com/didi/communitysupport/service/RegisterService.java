package com.didi.communitysupport.service;

import com.didi.communitysupport.domain.UserEntity;

public interface RegisterService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    int register(UserEntity user);

}
