package com.didi.communitysupport.controller;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.domain.AnswerEntity;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.enmu.ErrorEnum;
import com.didi.communitysupport.utils.ResultVOUtil;
import com.didi.communitysupport.utils.VERBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *个人自检
 * 获取检测题目	get	/getonebank					list(onebank)的json列表
 * 提交测试题	post	/submitonebank	json（onebanks）只存id和答案就可以				grade=数字 表示分数
 */
@RestController
public class OnebankController {


    @GetMapping("/getonebank")
    public ResultVO getOneBank(HttpServletRequest request) {
        Map json = new HashMap();
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println(user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setADate(new Date());

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
    @PostMapping("/submitonebank")
    public ResultVO submitOneBank(HttpServletRequest request) {
        Map json = new HashMap();
        return ResultVOUtil.success(json);
    }
}
