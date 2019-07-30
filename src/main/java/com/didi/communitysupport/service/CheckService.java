package com.didi.communitysupport.service;

import java.util.Map;

public interface CheckService {
    /**
     * 通过用户id进行养老警示 list（bloods）list（jumps）list（weughts）list（keepages）的json
     * @param uId
     * @return
     */
    Map check(int uId);
}
