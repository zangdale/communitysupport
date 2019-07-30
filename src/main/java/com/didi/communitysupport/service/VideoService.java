package com.didi.communitysupport.service;

import com.didi.communitysupport.domain.AnswerEntity;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.domain.VideoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VideoService {


    /**
     * 获取VIDEO的list集合
     * @return
     */
  public List<VideoEntity> getVideoList();


}
