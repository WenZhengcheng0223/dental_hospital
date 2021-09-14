package com.zmn.exception;

import com.zmn.utils.enums.ResultCodeEnum;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/14 下午 12:51
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.exception
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
@Getter
public abstract class BaseException extends RuntimeException {
    private final ResultCodeEnum error;
    private final HashMap<String, Object> data = new HashMap<>();

    public BaseException(ResultCodeEnum error, Map<String, Object> data) {
        super(error.getMessage());
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    protected BaseException(ResultCodeEnum error, Map<String, Object> data, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }


}
