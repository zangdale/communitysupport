package com.didi.communitysupport.serviceimpl;

import com.didi.communitysupport.dao.UserMapper;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper um;

    @Override
    public UserEntity isLogin(String account,String password) {
        System.out.println(um);
        System.out.println("1");
        UserEntity user = new UserEntity();
        user.setUAccount(account);
        user.setUPasswd(password);
        List<UserEntity> users = um.getByCondition(user);
        if(users.size()>0){
            System.out.println(users.get(0));
             return users.get(0);

        }

        return null;
    }
}
