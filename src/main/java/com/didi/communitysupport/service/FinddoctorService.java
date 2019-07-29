package com.didi.communitysupport.service;

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
    public List<QuestionEntity> getQuestionList();

}
