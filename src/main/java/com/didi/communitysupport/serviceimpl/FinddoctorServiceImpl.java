package com.didi.communitysupport.serviceimpl;

import com.didi.communitysupport.dao.QuestionMapper;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.service.FinddoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class FinddoctorServiceImpl implements FinddoctorService {

    @Autowired
    QuestionMapper qmap;
    @Override
    public List<QuestionEntity> getQuestionList() {
        System.out.println(qmap);
        QuestionEntity questionEntity= qmap.getByQId(0);

        // List<QuestionEntity> questionlist=finddoctorService.getQuestionList();
        List<QuestionEntity> questionlist=new ArrayList<>();
        questionlist.add(questionEntity);
        return questionlist;
    }
}
