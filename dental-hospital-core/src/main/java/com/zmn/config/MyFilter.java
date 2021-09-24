package com.zmn.config;

import com.auth0.jwt.interfaces.Claim;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Strings;
import com.zmn.utils.JwtUtil;
import com.zmn.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.Map;

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

    private static final Integer LOGIN_URL = -1;


    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("=========进入我的filter============");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");

        String url = req.getRequestURI();
        String token = req.getHeader("token");

        log.info(url);
        log.info(String.valueOf(url.indexOf("index")));

        if(url.indexOf("login") > LOGIN_URL){
            System.out.println(url.indexOf("login"));
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        log.info("请求头携带的token："+token);

        boolean nullOrEmpty = Strings.isNullOrEmpty(token);

        if (nullOrEmpty){
            throw new InvalidClassException("未登录，请先登录");
        }

        JwtUtil.verifyToken(token);
        Map<String, String> user = JwtUtil.getUser(token);

        System.out.println(user.get("username"));
        String s = stringRedisTemplate.opsForValue().get(user.get("username"));

        if (Strings.isNullOrEmpty(s)){
            throw new InvalidClassException("请重新登录");
        }

        servletRequest.setAttribute("role",user.get("role"));
        System.out.println(servletRequest.getAttribute("role"));


        log.info("=========退出我的filter============");

//        为了测试接口 没有携带token直接放行，测试完毕后请注释掉
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
