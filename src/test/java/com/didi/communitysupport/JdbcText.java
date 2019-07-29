package com.didi.communitysupport;

import com.didi.communitysupport.dao.QuestionMapper;
import com.didi.communitysupport.dao.UserMapper;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.service.FinddoctorService;
import com.didi.communitysupport.serviceimpl.FinddoctorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommunitysupportApplication.class)
public class JdbcText {

    @Resource
    FinddoctorService finddoctorService;
    @Test
    public void test() {

        System.out.println( finddoctorService.getQuestionList()+"--------------------->");
    }
}
