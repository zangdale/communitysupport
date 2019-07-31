package com.didi.communitysupport.controller;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.domain.VideoEntity;
import com.didi.communitysupport.enmu.ErrorEnum;
import com.didi.communitysupport.service.FinddoctorService;
import com.didi.communitysupport.service.VideoService;
import com.didi.communitysupport.utils.ResultVOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频教育的接口
 * 获取视频	get	/getvideo					list(video)的json
 */
@RestController
public class VideoController {

    @Resource
    VideoService videoservice ;

    /**
     * 获取视频列表接口
     * @return list(question)问题的json列表
     */
    @GetMapping(value = "/getvideo")
    public ResultVO getVideoList(){
        Map json = new HashMap();
        List<VideoEntity> Videolist= videoservice.getVideoList();
        if (Videolist==null){
            return ResultVOUtil.error(ErrorEnum.E404);
        }
        json.put("videos",Videolist);
        /**
         * vedio
         */
        return ResultVOUtil.success(json);
    }







}
