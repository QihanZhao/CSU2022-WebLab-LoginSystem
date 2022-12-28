package com.hanx.util;

public class MessageModel {
    private Integer code = 0;  //state: 1=success; 0=failure
    private String msg = "Failure";
    private Object user;

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

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
}
