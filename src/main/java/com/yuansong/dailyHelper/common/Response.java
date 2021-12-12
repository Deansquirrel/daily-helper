package com.yuansong.dailyHelper.common;

public class Response {

    private final static String SUCCESS = "success";
    private final static String FAIL = "fail";

    public static <T> ResponseResult<T> makeResp(ResultCode retCode, String msg) {
        return new ResponseResult<T>().initCode(retCode).initMsg(msg);
    }

    public static <T> ResponseResult<T> makeResp(ResultCode retCode, String msg, T data) {
        return new ResponseResult<T>().initCode(retCode.code).initMsg(msg).initData(data);
    }

    public static <T> ResponseResult<T> makeResp(int code, String msg) {
        return new ResponseResult<T>().initCode(code).initMsg(msg);
    }

    public static <T> ResponseResult<T> makeResp(int code, String msg, T data) {
        return new ResponseResult<T>().initCode(code).initMsg(msg).initData(data);
    }

    public static <T> ResponseResult<T> makeOKResp() {
        return new ResponseResult<T>().initCode(ResultCode.SUCCESS).initMsg(SUCCESS);
    }

    public static <T> ResponseResult<T> makeOKResp(String message) {
        return new ResponseResult<T>().initCode(ResultCode.SUCCESS).initMsg(message);
    }

    public static <T> ResponseResult<T> makeOKResp(T data) {
        return new ResponseResult<T>().initCode(ResultCode.SUCCESS).initMsg(SUCCESS).initData(data);
    }

    public static ResponseResult<String> makeOKStringResp(String data) {
        return new ResponseResult<String>().initCode(ResultCode.SUCCESS).initMsg(SUCCESS).initData(data);
    }

    public static <T> ResponseResult<T> makeOKResp(String message, T data) {
        return new ResponseResult<T>().initCode(ResultCode.SUCCESS).initMsg(message).initData(data);
    }

    public static <T> ResponseResult<T> makeErrResp() {
        return new ResponseResult<T>().initCode(ResultCode.FAIL).initMsg(FAIL);
    }

    public static <T> ResponseResult<T> makeErrRsp(String message) {
        return new ResponseResult<T>().initCode(ResultCode.FAIL).initMsg(message);
    }

}
