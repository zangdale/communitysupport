package com.didi.communitysupport.service;

import com.didi.communitysupport.domain.IllEntity;
import com.didi.communitysupport.domain.UserEntity;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface GetArchivesService {
    /**
     * 通过session获取用户信息
     * @param session
     * @return
     */
    UserEntity getArchives(HttpSession session);

    /**
     * 通过uid获取用户病例列表
     * @param uId
     * @return
     */
    List<IllEntity> illList(int uId);
}
