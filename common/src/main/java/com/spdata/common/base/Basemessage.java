package com.spdata.common.base;

public class Basemessage {
    //访问正常
    public final static Integer success = 2000;
    public final static String success_message = "访问正常";
    //出现异常
    public final static Integer error = 5001;
    public final static String error_message = "出现异常";
    //系统错误
    public final static Integer error_system = 5002;
    public final static String error_system_message = "系统错误";
    //权限不足
    public final static Integer Refuse = 4003;
    //参数错误
    public final static Integer ParameterError = 4001;
    public final static String Refuse_message = "权限不足";
    //请求超时
    public final static Integer Timeout = 5003;
    //请求超时
    public final static String Timeout_message = "请求超时";


    //4004
    public final static String NoHandler = "找不到这个地址";


}
