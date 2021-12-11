package com.yuansong.dailyHelper.common;

public class ResponseResult<T> {

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public ResponseResult<T> setCode(ResultCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public ResponseResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public ResponseResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
