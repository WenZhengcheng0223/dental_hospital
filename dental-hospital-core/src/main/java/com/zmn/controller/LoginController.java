package com.zmn.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zmn.entity.Account;
import com.zmn.service.AccountService;
import com.zmn.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "前端登录接口",tags = "前端登录接口")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }


    @ApiOperation(value = "微信登录接口")
    @PostMapping("/weixin")
    public R wxLogin(@ApiParam(name = "openid",value = "微信服务器返回的openid") String openid){
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid",openid);
        Account one = accountService.getOne(queryWrapper);
        if (one != null) {

        }


        return R.error().message("");
    }

}
