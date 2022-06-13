package com.yuansong.dailyHelper.util.io;

public enum ResultCode {

    SUCCESS(0,"操作成功"),
    FAIL(-1,"操作失败"),
    AUTH_FAILED(10000000,"用户名不存在或密码错误"),
    AUTH_INVALID(10000001,"登录已失效");

    public int code;
    public String msg;

    ResultCode(int code, String msg) {this.code = code; this.msg = msg;}

}
