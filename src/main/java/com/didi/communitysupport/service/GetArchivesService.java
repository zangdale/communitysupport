package com.didi.communitysupport.service;

import com.didi.communitysupport.domain.IllEntity;
import com.didi.communitysupport.domain.UserEntity;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface GetArchivesService {
    UserEntity getArchives(HttpSession session);
    List<IllEntity> illList(int uId);
}
