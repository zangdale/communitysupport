package com.didi.communitysupport.enmu;

public enum ErrorEnum {
    E404(404,"地址错误"),
    E500(500,"拒绝服务"),
    E201(201,"未登录");

    private Integer code;
    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
