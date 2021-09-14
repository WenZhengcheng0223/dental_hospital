package com.zmn.exception;

import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.HashMap;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/14 下午 01:37
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.exception
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
@Data
public class ErrorResponse {
    private Integer status;
    private String message;
    private String path;
    private Instant timestamp;
    private HashMap<String, Object> data = new HashMap<>();

    public ErrorResponse(){}

    public ErrorResponse(BaseException ex, String path){
        this(ex.getError().getStatus(), ex.getError().getMessage(), path, ex.getData());
    }

    public ErrorResponse(Integer status, String message, String path, HashMap<String, Object> data) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now();
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
