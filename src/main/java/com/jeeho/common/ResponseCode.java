package com.jeeho.common;

public enum  ResponseCode {

    SUCCESS(0,"success"),
    ERROR(1,"error"),
    NOLOGIN(3,"no-login"),
    NOAUTH(4,"no-auth");

    private final int code;
    private final String desc;

    ResponseCode(int code ,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
