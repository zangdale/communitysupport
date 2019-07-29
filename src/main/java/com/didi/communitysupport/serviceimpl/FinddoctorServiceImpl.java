package com.didi.communitysupport.serviceimpl;

import com.didi.communitysupport.dao.AnswerMapper;
import com.didi.communitysupport.dao.QuestionMapper;
import com.didi.communitysupport.domain.AnswerEntity;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.service.FinddoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FinddoctorServiceImpl implements FinddoctorService {

    @Autowired
    QuestionMapper qmap;

    @Autowired
    AnswerMapper amap;

    @Override
    public List<QuestionEntity> getQuestionList() {
        List<QuestionEntity> questionlist = qmap.getAllQuestion();

        return questionlist;
    }

    @Override
    public QuestionEntity getQuestion(int qid) {
        QuestionEntity questionEntity = qmap.getByQId(qid);
        return questionEntity;
    }

    @Override
    public List<AnswerEntity> getAnswersByQuestion(int qid) {
        List<AnswerEntity> answerEntityList = amap.getByAQuestionid(qid);
        return answerEntityList;
    }
}
