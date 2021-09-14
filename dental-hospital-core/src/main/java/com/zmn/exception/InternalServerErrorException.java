package com.zmn.exception;

import com.zmn.utils.enums.ResultCodeEnum;

import java.util.Map;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/14 下午 04:07
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.exception
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
public class InternalServerErrorException extends BaseException{
    public InternalServerErrorException(Map<String, Object> data) {
        super(ResultCodeEnum.INTERNAL_SERVER_ERROR, data);
    }
}
