package com.yuansong.dailyHelper.util.io;

public class Response {

    public static <T> ResponseResult<T> makeResp(ResultCode retCode) {
        return new ResponseResult<T>().initCode(retCode.code).initMsg(retCode.msg);
    }

    public static <T> ResponseResult<T> makeResp(ResultCode retCode, T data) {
        return new ResponseResult<T>().initCode(retCode.code).initMsg(retCode.msg);
    }

    public static <T> ResponseResult<T> makeResp(int code, String msg) {
        return new ResponseResult<T>().initCode(code).initMsg(msg);
    }

    public static <T> ResponseResult<T> makeResp(int code, String msg, T data) {
        return new ResponseResult<T>().initCode(code).initMsg(msg).initData(data);
    }

    public static <T> ResponseResult<T> makeOKResp() {
        return new ResponseResult<T>().initCode(ResultCode.SUCCESS.code).initMsg(ResultCode.SUCCESS.msg);
    }

    public static <T> ResponseResult<T> makeOKResp(String message) {
        return new ResponseResult<T>().initCode(ResultCode.SUCCESS.code).initMsg(message);
    }

    public static <T> ResponseResult<T> makeOKResp(T data) {
        return new ResponseResult<T>()
                .initCode(ResultCode.SUCCESS.code)
                .initMsg(ResultCode.SUCCESS.msg)
                .initData(data);
    }

    public static ResponseResult<String> makeOKStringResp(String data) {
        return new ResponseResult<String>()
                .initCode(ResultCode.SUCCESS.code)
                .initMsg(ResultCode.SUCCESS.msg)
                .initData(data);
    }

    public static <T> ResponseResult<T> makeOKResp(String message, T data) {
        return new ResponseResult<T>()
                .initCode(ResultCode.SUCCESS.code)
                .initMsg(message)
                .initData(data);
    }

    public static <T> ResponseResult<T> makeErrResp() {
        return new ResponseResult<T>()
                .initCode(ResultCode.FAIL.code)
                .initMsg(ResultCode.FAIL.msg);
    }

    public static <T> ResponseResult<T> makeErrRsp(String message) {
        return new ResponseResult<T>()
                .initCode(ResultCode.FAIL.code)
                .initMsg(message);
    }

}
