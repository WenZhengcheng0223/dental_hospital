package com.zmn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/14 下午 11:57
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn
 * @ProjectName : DentalHospital
 * @Version : 1.0.0
 */

@Slf4j
@RestController
public class LogController {
    @GetMapping("/log")
    public String testLog(){
        log.trace("trace");
        log.debug("debug");
        log.warn("warn");
        log.info("info");
        log.error("error");
        return "hello springboot";
    }
}
