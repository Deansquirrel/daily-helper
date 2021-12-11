package com.yuansong.dailyHelper.common;

public class Response {

    private final static String SUCCESS = "success";
    private final static String FAIL = "fail";

    public static <T> ResponseResult<T> makeResp(ResultCode retCode, String msg) {
        return new ResponseResult<T>().setCode(retCode).setMsg(msg);
    }

    public static <T> ResponseResult<T> makeResp(ResultCode retCode, String msg, T data) {
        return new ResponseResult<T>().setCode(retCode.code).setMsg(msg).setData(data);
    }

    public static <T> ResponseResult<T> makeResp(int code, String msg) {
        return new ResponseResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ResponseResult<T> makeResp(int code, String msg, T data) {
        return new ResponseResult<T>().setCode(code).setMsg(msg).setData(data);
    }

    public static <T> ResponseResult<T> makeOKResp() {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> ResponseResult<T> makeOKResp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(message);
    }

    public static <T> ResponseResult<T> makeOKResp(T data) {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static ResponseResult<String> makeOKStringResp(String data) {
        return new ResponseResult<String>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> ResponseResult<T> makeOKResp(String message, T data) {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(message).setData(data);
    }

    public static <T> ResponseResult<T> makeErrResp() {
        return new ResponseResult<T>().setCode(ResultCode.FAIL).setMsg(FAIL);
    }

    public static <T> ResponseResult<T> makeErrRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.FAIL).setMsg(message);
    }

}
