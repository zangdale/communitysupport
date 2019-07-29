package com.didi.communitysupport;


import com.didi.communitysupport.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.didi.dao")
public class CommunitysupportApplicationTests {
    @Autowired
    UserMapper um;
    @Test
    public void contextLoads() {
        System.out.println(um);
    }

}
