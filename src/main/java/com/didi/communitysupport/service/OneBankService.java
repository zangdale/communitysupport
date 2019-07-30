package com.didi.communitysupport.service;

import com.didi.communitysupport.domain.OnebankEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OneBankService {
    /**
     * 获取信息的题目列表
     * @return List<OnebankEntity>
     */
    List<OnebankEntity> getOneBankList();

    /**
     * 提交对应的json数据 解析之后 返回对应得分数
     * @param onebanks
     * @return
     */
    int SubmitOneBank(String onebanks);
}
