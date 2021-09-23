package com.zmn.config;

import com.zmn.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InvalidClassException;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/22 下午 06:07
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.config
 * @ProjectName : DentalHospital
 * @Version : 1.0.0
 */
@Slf4j
@WebFilter(filterName = "myFilter", urlPatterns = "/api/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("=========进入我的filter============");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");

        String token = req.getHeader("token");

        log.info("这是我的token: "+token);
        String uri = req.getRequestURI();
        if(null != token ){
            try {
                String decoded = JwtUtil.decoded(token);
                if(JwtUtil.verify(token,decoded)){
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("这是我的token"+token);
        }

        System.out.println(uri.indexOf("login"));
        if(uri.indexOf("login")>-1){
            System.out.println(uri.indexOf("login"));
            filterChain.doFilter(servletRequest,servletResponse);
        }
        log.info("=========退出我的filter============");
//        throw new InvalidClassException("权限不足！");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
