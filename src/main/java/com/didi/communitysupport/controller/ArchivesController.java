package com.didi.communitysupport.controller;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.domain.IllEntity;
import com.didi.communitysupport.domain.UserEntity;
import com.didi.communitysupport.service.GetArchivesService;
import com.didi.communitysupport.service.LoginService;
import com.didi.communitysupport.utils.ResultVOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 个人档案的接口
 * 获取个人档案	get	/getarchives					user=用户信息和list（ill）的json
 */
@Controller
public class ArchivesController {
    @Resource
    GetArchivesService getArchivesService;


    @GetMapping("/getarchives")
    public ResultVO getArchives(HttpSession session){
        UserEntity user = getArchivesService.getArchives(session);
        List<IllEntity> list = getArchivesService.illList(user.getUId());
        Map json = new HashMap();
        json.put("user",user);
        json.put("list",list);
        System.out.println(json);
        return ResultVOUtil.success(json);

    }
}
