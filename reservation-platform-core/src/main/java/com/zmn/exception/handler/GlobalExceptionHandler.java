package com.zmn.exception.handler;

import com.zmn.exception.BaseException;
import com.zmn.exception.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description : 全局异常捕获
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/14 下午 01:31
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.exception.handler
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleException(BaseException ex, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex, request.getRequestURI());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(),ex.getError().getStatus());
    }
}
