package com.didi.communitysupport.serviceimpl;

import com.didi.communitysupport.dao.BloodMapper;
import com.didi.communitysupport.dao.JumpMapper;
import com.didi.communitysupport.dao.KeepageMapper;
import com.didi.communitysupport.dao.WeightMapper;
import com.didi.communitysupport.domain.BloodEntity;
import com.didi.communitysupport.domain.JumpEntity;
import com.didi.communitysupport.domain.KeepageEntity;
import com.didi.communitysupport.domain.WeightEntity;
import com.didi.communitysupport.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CheckServiceImpl implements CheckService {
    /**
     * list（bloods）list（jumps）list（weughts）list（keepages）的json
     * @param uId
     * @return
     */
    @Autowired
    BloodMapper
    bm;
    @Autowired
    WeightMapper
    wm;
    @Autowired
    KeepageMapper km;
    @Autowired
    JumpMapper jm;

    @Override
    public Map check(int uId) {
        BloodEntity blood = new BloodEntity();
        JumpEntity jump= new JumpEntity();
        WeightEntity weight = new WeightEntity();
        KeepageEntity keepage = new KeepageEntity();

        blood.setBUserid(uId);
        jump.setJUserid(uId);
        weight.setWUserid(uId);
        keepage.setKUserid(uId);


        List<BloodEntity> bloods = bm.getByCondition(blood);
        List<JumpEntity> jumps = jm.getByCondition(jump);
        List<WeightEntity> weughts =wm.getByCondition(weight);
        List<KeepageEntity> keepages = km.getByCondition(keepage);
        Map json = new HashMap();
        json.put("bloods",bloods);
        json.put("jumps",jumps);
        json.put("weughts",weughts);
        json.put("keepages",keepages);
        return json;
    }
}
