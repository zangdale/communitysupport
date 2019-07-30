package com.didi.communitysupport.serviceimpl;

import com.didi.communitysupport.dao.IllMapper;
import com.didi.communitysupport.dao.UserMapper;
import com.didi.communitysupport.domain.IllEntity;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.service.GetArchivesService;
import com.didi.communitysupport.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class GetArchivesServiceImpl implements GetArchivesService {
    @Autowired
    UserMapper um;
    @Override
    public UserEntity getArchives(HttpSession session) {

        return (UserEntity)session.getAttribute(Constant.USER_INFO);
    }
    @Autowired
    IllMapper im;
    @Override
    public List<IllEntity> illList(int uId) {
        IllEntity illEntity = new IllEntity();
        illEntity.setIId(uId);
        List<IllEntity> illList = im.getByCondition(illEntity);

        return illList;
    }
}
