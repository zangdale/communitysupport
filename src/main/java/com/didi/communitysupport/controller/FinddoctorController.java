package com.didi.communitysupport.controller;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.dao.QuestionMapper;
import com.didi.communitysupport.domain.AnswerEntity;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.enmu.ErrorEnum;
import com.didi.communitysupport.service.FinddoctorService;
import com.didi.communitysupport.serviceimpl.FinddoctorServiceImpl;
import com.didi.communitysupport.utils.IsEmply;
import com.didi.communitysupport.utils.ResultVOUtil;
import com.didi.communitysupport.utils.VERBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 寻医问药的接口
 * 获取问题列表接口	get	/getquestionlist					list(question)问题的json列表
 * 获取指定问题的详细界面	get	/getquestion	qid				question和list（answer）json
 * 添加问题	post	/addquestion	qtitle,qtext				ok==0表示失败ok==1表示成功list(question)问题的json列表
 * 添加回答	post	/addanswer	qid,atext				ok==0表示失败ok==1表示成功 question和list（answer）json
 */
@RestController
public class FinddoctorController {

    @Resource
    FinddoctorService finddoctorService;

    /**
     * 获取问题列表接口
     *
     * @return list(question)问题的json列表
     */
    @GetMapping(value = "/getquestionlist")
    public ResultVO getQuestionList(HttpServletRequest request) {
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println(user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        Map json = new HashMap();
        List<QuestionEntity> questionlist = finddoctorService.getQuestionList();
        if (questionlist == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        json.put("questions", questionlist);
        return ResultVOUtil.success(json);
    }

    /**
     * 获取指定问题的详细界面
     *
     * @return question和list（answer）json
     */
    @GetMapping(value = "/getquestion")
    public ResultVO getQuestion(@RequestParam(value="qid",required=true,defaultValue="-1") int qid,HttpServletRequest request) {
        if (qid == -1) {
            return ResultVOUtil.error(ErrorEnum.E500);
        }
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println(user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        Map json = new HashMap();
        QuestionEntity q = finddoctorService.getQuestion(qid);
        json.put("question", q);
        List<AnswerEntity> answerEntityList = finddoctorService.getAnswersByQuestion(qid);
        json.put("answers", answerEntityList);
        return ResultVOUtil.success(json);
    }


    /**
     * 添加问题的接口
     *
     * @param //qtitle,qtext
     * @param request
     * @return
     */
    @PostMapping("/addquestion")
    public ResultVO addQuestion(@RequestParam(value="qtitle",required=true,defaultValue="") String qtitle, @RequestParam(value="qtext",required=true,defaultValue="") String qtext, HttpServletRequest request) {
        if (IsEmply.StringIsEmply(qtitle)|| IsEmply.StringIsEmply(qtext)) {
            return ResultVOUtil.error(ErrorEnum.E500);
        }
        Map json = new HashMap();
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println(user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        System.out.println(qtext + "----" + qtitle);
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQDate(new Date());
        questionEntity.setQText(qtext);
        questionEntity.setQTitle(qtitle);
        //adduserid
        questionEntity.setQUserid(user.getUId());
        boolean b = finddoctorService.addQuestion(questionEntity);
        if (!b) {
            return ResultVOUtil.error(ErrorEnum.E500);
        }
        List<QuestionEntity> questionlist = finddoctorService.getQuestionList();
        json.put("questions", questionlist);
        return ResultVOUtil.success(json);
    }


    /**
     *添加回答	post	/addanswer	qid,atext				ok==0表示失败ok==1表示成功 question和list（answer）json
     * @param qid
     * @param atext
     * @param request
     * @return  question和list（answer）json
     */
    @PostMapping("/addanswer")
    public ResultVO addAnswer(@RequestParam(value = "qid",required=true,defaultValue="-1") int  qid, @RequestParam(value = "atext",required=true,defaultValue="") String atext, HttpServletRequest request) {
        if (qid==-1||IsEmply.StringIsEmply(atext)) {
            return ResultVOUtil.error(ErrorEnum.E500);
        }
        Map json = new HashMap();
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println(user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        System.out.println(qid + "----" + atext);
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setADate(new Date());

        answerEntity.setAQuestionid(qid);
        answerEntity.setAText(atext);
        //answerEntity.setuName(user.getUName());
        //adduserid
        answerEntity.setAUserid(user.getUId());
        boolean b = finddoctorService.addAnswerToQ(answerEntity);
        if (!b) {
            return ResultVOUtil.error(ErrorEnum.E500);
        }
        QuestionEntity q = finddoctorService.getQuestion(qid);
        json.put("question", q);
        List<AnswerEntity> answerEntityList = finddoctorService.getAnswersByQuestion(qid);
        json.put("answers", answerEntityList);
        return ResultVOUtil.success(json);
    }
}
