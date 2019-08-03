package com.didi.communitysupport;


import com.didi.communitysupport.dao.UserMapper;
import com.didi.communitysupport.dao.VideoMapper;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.domain.VideoEntity;
import com.didi.communitysupport.service.LoginService;
import com.didi.communitysupport.serviceimpl.LoginServiceImpl;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.didi.dao")
public class CommunitysupportApplicationTests {
    @Resource
    LoginService loginService;
    @Autowired
    VideoMapper vm;
    @Test
    public void contextLoads() {
        List<VideoEntity> list = vm.getAllVideo();
        System.out.println(list);

    }

}
