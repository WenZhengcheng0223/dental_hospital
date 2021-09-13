package com.zmn.controller;

import com.zmn.utils.R;
import com.zmn.utils.ResultCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/13 下午 11:51
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.controller
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
@RestController
public class TestResult {

    @GetMapping("/test")
    public R test(){

        return R.error().code(ResultCodeEnum.NOT_FOUND.getCode()).message(ResultCodeEnum.NOT_FOUND.getMessage());
    }

    @GetMapping("/test1")
    public R test1(){

        return R.error().code(ResultCodeEnum.NOT_FOUND.getCode()).message(ResultCodeEnum.NOT_FOUND.getMessage());
    }
}
