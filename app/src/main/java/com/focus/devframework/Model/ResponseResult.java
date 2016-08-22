package com.focus.devframework.Model;

/**
 * Created by chengxianyi on 2015/9/14.
 */
public class ResponseResult<T> {
    public String api = "";
    public String version = "";
    public ResultCode result;
    public T data ;

    public static class ResultCode{
        public String code ;
        public String message;
    }
}
