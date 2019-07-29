package com.didi.communitysupport.controller;

import com.didi.communitysupport.dao.QuestionMapper;
import com.didi.communitysupport.domain.AnswerEntity;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.service.FinddoctorService;
import com.didi.communitysupport.serviceimpl.FinddoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻医问药的接口
 * 获取问题列表接口	get	/getquestionlist					list(question)问题的json列表
 * 获取指定问题的详细界面	get	/getquestion	qid				question和list（answer）json
 * 添加问题	post	/addquestion	qtitle,qtext,qdate				ok==0表示失败ok==1表示成功list(question)问题的json列表
 * 添加回答	post	/addanswer	qid,atext,adate				ok==0表示失败ok==1表示成功 question和list（answer）json
 */
@Controller
public class FinddoctorController {

    @Resource
    FinddoctorService finddoctorService;

    /**
     * 获取问题列表接口
     * @return list(question)问题的json列表
     */
    @GetMapping(value = "/getquestionlist")
    @ResponseBody
    public Map getQuestionList(){
        Map json = new HashMap();
        List<QuestionEntity> questionlist=finddoctorService.getQuestionList();
        json.put("questions",questionlist);
        return json;
    }

    /**
     * 获取指定问题的详细界面
     * @return question和list（answer）json
     */
    @GetMapping(value = "/getquestion")
    @ResponseBody
    public Map getQuestion(@RequestParam("qid") int qid){
        Map json = new HashMap();
        QuestionEntity q = finddoctorService.getQuestion(qid);
        json.put("question",q);
        List<AnswerEntity> answerEntityList=finddoctorService.getAnswersByQuestion(qid);
        json.put("answers",answerEntityList);
        return json;
    }


}
