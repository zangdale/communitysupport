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
        //System.out.println("-0-------------->"+onebanks);
        onebanks = onebanks.replace("[", "");
        onebanks = onebanks.replace("{", "");
        //System.out.println("-0-------------->"+onebanks);
        String[] onebank = onebanks.split("},");
        int count = 0;
        int oid;
        int oright;
        OnebankEntity onebankEntity = null;
        for (String str : onebank) {
            //System.out.println("---------------"+str);
            str = str.replace("}", "");
            //System.out.println("---------------"+str);
            str = str.replace("\"oid\":", "");
           // System.out.println("---------------"+str);
            str = str.replace("\"oright\":", "");
            System.out.println("---------------"+str);
            String[] s = str.split(",");
            oid=Integer.parseInt(s[0]);
            oright=Integer.parseInt(s[1]);
            onebankEntity=omap.getByOId(oid);
            if(onebankEntity.getORight()==oright){
                count++;
            }
        }

        return count;
    }
}
