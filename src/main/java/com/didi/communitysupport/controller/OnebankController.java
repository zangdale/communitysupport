package com.didi.communitysupport.controller;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.domain.AnswerEntity;
import com.didi.communitysupport.domain.OnebankEntity;
import com.didi.communitysupport.domain.QuestionEntity;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.enmu.ErrorEnum;
import com.didi.communitysupport.service.OneBankService;
import com.didi.communitysupport.utils.IsEmply;
import com.didi.communitysupport.utils.ResultVOUtil;
import com.didi.communitysupport.utils.VERBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *个人自检
 * 获取检测题目	get	/getonebank					list(onebanks)的json列表
 * 提交测试题	post	/submitonebank	json（onebanks）只存id和答案就可以				grade=数字 表示分数
 */
@RestController
public class OnebankController {

    @Resource
    OneBankService oneBankService;

    /**
     * 获取检测题目	get	/getonebank					list(onebanks)的json列表
     * @param request
     * @return list(onebanks)的json列表
     */
    @GetMapping("/getonebank")
    public ResultVO getOneBank(HttpServletRequest request) {
        Map json = new HashMap();
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println(user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        List<OnebankEntity> onebankEntities =  oneBankService.getOneBankList();
        json.put("onebanks", onebankEntities);
        return ResultVOUtil.success(json);
    }

    /**
     * 提交测试题	post	/submitonebank	json（onebanks）只存id和答案就可以				grade=数字 表示分数
     * @param request
     * @return grade=数字 表示分数 ,required=true,defaultValue=""
     */
    @PostMapping("/submitonebank")
    public ResultVO submitOneBank(@RequestParam(value = "onebanks") String onebanks ,HttpServletRequest request) {

        if (IsEmply.StringIsEmply(onebanks)) {
            return ResultVOUtil.error(ErrorEnum.E500);
        }
        Map json = new HashMap();
        UserEntity user = VERBUtil.getUserSession(request);
        System.out.println(user);
        if (user == null) {
            return ResultVOUtil.error(ErrorEnum.E201);
        }
        int grade=oneBankService.SubmitOneBank(onebanks);
        json.put("grade",grade);
        return ResultVOUtil.success(json);
    }
}
