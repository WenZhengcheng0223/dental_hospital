package com.zmn.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/13 下午 11:18
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.utils
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
@Data
public class R {

    private static  R r;
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();
    private R(){};

    private static R getInstance(){
        if (r == null) {
            synchronized (R.class){
                if (r == null) {
                    r = new R();
                }
            }
        }
        return r;
    }

    public static R ok(){
        getInstance();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static R error(){
        getInstance();
        r.setSuccess(ResultCodeEnum.FAIL.getSuccess());
        r.setCode(ResultCodeEnum.FAIL.getCode());
        r.setMessage(ResultCodeEnum.FAIL.getMessage());
        return r;
    }

    public R success(Boolean success){
        this.success = success;
        return this;
    }

    public R message(String message){
        this.message = message;
        return this;
    }

    public R code(Integer code){
        this.code = code;
        return this;
    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
