package com.zmn.controller;

import com.zmn.entity.Account;
import com.zmn.service.AccountService;
import com.zmn.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
@RequestMapping("/api")
@Api(tags = "测试")
public class TestResult {

    @Autowired
    private AccountService accountService;

    @GetMapping("/user/login")
    public R test() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "name");
        map.put("avatar", "avatar");
        return R.ok().data("info", map);
    }

    @ApiOperation(value = "filter测试接口", notes = "filter测试接口")
    @PostMapping("/wx/login")
    public R wxLogin() {
        Account account = new Account();
        account.setOpenid("88888");
        account.setId(29);
        accountService.updateById(account);
//        accountService.save(account);
        return R.ok();

    }
}
