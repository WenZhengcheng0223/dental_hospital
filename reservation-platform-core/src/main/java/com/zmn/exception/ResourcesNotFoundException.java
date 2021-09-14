package com.zmn.exception;

import com.zmn.utils.enums.ResultCodeEnum;

import java.util.Map;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/14 下午 01:29
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.exception
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
public class ResourcesNotFoundException extends BaseException{
    public ResourcesNotFoundException(Map<String, Object> data) {
        super(ResultCodeEnum.NOT_FOUND, data);
    }
}
