package com.didi.communitysupport.utils;

import com.didi.communitysupport.VO.ResultVO;
import com.didi.communitysupport.enmu.ErrorEnum;

public class ResultVOUtil {


    public static ResultVO success(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("");
        return resultVO;
    }

    public static ResultVO success(Object data){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(ErrorEnum errorEnum){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(errorEnum.getCode());
        resultVO.setMsg(errorEnum.getMsg());
        return resultVO;
    }
}
