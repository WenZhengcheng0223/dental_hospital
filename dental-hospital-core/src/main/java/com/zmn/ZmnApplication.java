package com.zmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description : 程序入口
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/13 下午 5:22
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.reservation-platform
 * @ProjectName : reservation-platform
 * @Version : 1.0.0
 */
@SpringBootApplication
@ServletComponentScan
public class ZmnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmnApplication.class, args);
    }

}
