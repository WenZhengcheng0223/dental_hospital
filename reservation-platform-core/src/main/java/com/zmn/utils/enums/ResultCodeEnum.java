package com.zmn.utils.enums;

import lombok.Getter;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/13 下午 10:29
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.common
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
@Getter

public enum ResultCodeEnum {

    /**
     * 请求统一返回状态码
     */
    SUCCESS(true, 200, "成功"),
    FAIL(false, 400, "失败"),
    NOT_FOUND(false, 404, "请求资源不存在"),
    INTERNAL_SERVER_ERROR(false, 500, "服务器内部错误");

    private final Boolean success;
    private final Integer status;
    private final String message;

    ResultCodeEnum(Boolean success, Integer status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }
}
