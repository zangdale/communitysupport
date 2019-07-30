package com.didi.communitysupport.serviceimpl;

import com.didi.communitysupport.dao.OnebankMapper;
import com.didi.communitysupport.domain.OnebankEntity;
import com.didi.communitysupport.service.OneBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneBankServiceImpl implements OneBankService {
    @Autowired
    OnebankMapper omap;

    @Override
    public List<OnebankEntity> getOneBankList() {
        List<OnebankEntity> onebankEntityList=omap.getAll();
        return onebankEntityList;
    }

    @Override
    public int SubmitOneBank(String onebanks) {

        return 0;
    }
}
