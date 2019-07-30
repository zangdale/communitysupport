package com.didi.communitysupport.service;

import com.didi.communitysupport.domain.AnswerEntity;
import com.didi.communitysupport.domain.QuestionEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public interface FinddoctorService {
    /**
     * 获取question的list集合
     * @return
     */
    List<QuestionEntity> getQuestionList();

    /**
     * 获取指定qid的question的详细信息
     * @param qid
     * @return QuestionEntity
     */
    QuestionEntity getQuestion(int qid);

    /**
     * 根据问题的id获取对应的回答的列表
     * @param qid
     * @return List<AnswerEntity>
     */
    List<AnswerEntity> getAnswersByQuestion(int qid);

    /**
     * 添加一个问题
     * @param questionEntity
     * @return boolean
     */
    boolean addQuestion(QuestionEntity questionEntity);
}
