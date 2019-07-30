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
        List<OnebankEntity> onebankEntityList = omap.getAll();
        return onebankEntityList;
    }

    @Override
    public int SubmitOneBank(String onebanks) {
        //System.out.println(onebanks);
        onebanks = onebanks.replace("[", "");
        onebanks = onebanks.replace("{", "");
        // System.out.println(onebanks);
        String[] onebank = onebanks.split("},");
        int count = 0;
        int oid;
        int oright;
        OnebankEntity onebankEntity = null;
        for (String str : onebank) {
            str = str.replace("}", "");
            str = str.replace("\"oid\":", "");
            str = str.replace("\"oright\":", "");
            System.out.println(str);
            String[] s = str.split(",");
            oid=Integer.parseInt(s[0]);
            oright=Integer.parseInt(s[1]);
        }

        return count;
    }
}
