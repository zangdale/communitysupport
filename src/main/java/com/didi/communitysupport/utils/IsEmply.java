package com.didi.communitysupport.utils;

/**
 *判断字符串是否为空的null后者""
 */
public class IsEmply {
    /**
     * 判断字符串是否为空的和空白的
     * 返回的结果是 为空为true,不是空的就是false
     * @param str
     * @return
     */
    public static boolean StringIsEmply(String str){
        if (str!=null&&"".equals(str)){
            return true;
        }
        return false;
    }
}
