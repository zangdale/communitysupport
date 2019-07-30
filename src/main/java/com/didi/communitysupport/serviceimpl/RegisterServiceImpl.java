package com.didi.communitysupport.serviceimpl;

import com.didi.communitysupport.dao.UserMapper;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserMapper um;
    @Override
    public int register(UserEntity user) {
        int n = um.insert(user);

        return n;
    }
}
