package com.zmn.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zmn.entity.Account;
import com.zmn.entity.User;
import com.zmn.service.AccountService;
import com.zmn.utils.JwtUtil;
import com.zmn.utils.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "前端登录接口",tags = "前端登录接口")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private static final String ADMIN_ROLE = "admin";
    private static final String PUB_ROLE = "public";
    private final AccountService accountService;

    private final StringRedisTemplate stringRedisTemplate;

    public LoginController(AccountService accountService, StringRedisTemplate stringRedisTemplate) {
        this.accountService = accountService;
        this.stringRedisTemplate = stringRedisTemplate;
    }


    /**
     * 就收小程序端发送过来的openid
     * 查询账号表
     * 存在就直接生成token返回
     * 不存在就插入后再生成token返回
     * @param openid
     * @return token
     */
    @ApiOperation(value = "微信登录接口")
    @PostMapping("/weixin")
    @ApiImplicitParam(name = "openid", value = "微信小程序的唯一身份标识")
    public R wxLogin(String openid){
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid",openid);
        Account one = accountService.getOne(queryWrapper);
        if (one == null) {
            boolean save = accountService.save(Account.builder().openid(openid).build());
            if (!save){
                return R.error().status(500).message("服务器异常");
            }
            String token = JwtUtil.createJWT(openid, PUB_ROLE);
            stringRedisTemplate.opsForValue().set(openid,token);
            return R.ok().message("登录成功").data("token",token);

        }
        else {
            String token = JwtUtil.createJWT(openid, PUB_ROLE);
            stringRedisTemplate.opsForValue().set(openid,token);
            return R.ok().message("登录成功").data("token",token);
        }

    }


    @PostMapping("/web")
    @ApiOperation(value = "后台管理系统登录接口")
    public R webLogin(@RequestBody User user){
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_id",user.getUsername());
        queryWrapper.eq("openid",user.getPassword());

        Account one = accountService.getOne(queryWrapper);
        if (one == null) {
            return R.error().message("账号或者密码错误");
        }
        String token = JwtUtil.createJWT(user.getUsername(), ADMIN_ROLE);
        System.out.println(token);
        stringRedisTemplate.opsForValue().set(user.getUsername(),token);
        return R.ok().message("登录成功").data("token",token);
    }

}
