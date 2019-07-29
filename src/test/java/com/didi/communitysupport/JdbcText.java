package com.didi.communitysupport;

import com.didi.communitysupport.dao.UserMapper;
import com.didi.communitysupport.domain.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommunitysupportApplication.class)
public class JdbcText {
    private UserMapper umap;

    @Test
    public void test(){
        UserEntity user=new UserEntity();
        user.setUId(1);
       int t= umap.getByUId(1);
        System.out.println(t+"------------------->>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
