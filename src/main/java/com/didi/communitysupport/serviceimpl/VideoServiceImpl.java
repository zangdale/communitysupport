package com.didi.communitysupport.serviceimpl;

import com.didi.communitysupport.dao.AnswerMapper;
import com.didi.communitysupport.dao.VideoMapper;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.domain.VideoEntity;
import com.didi.communitysupport.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper qmap;
    @Override
    /**
     * video获取
     */
    public List<VideoEntity> getVideoList(){

            List<VideoEntity> videolist = qmap.getAllVideo();
            return videolist;

    };


}
