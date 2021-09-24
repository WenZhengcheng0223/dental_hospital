package com.zmn.controller;

import com.zmn.entity.Duty;
import com.zmn.service.DutyService;
import com.zmn.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/24 上午 11:02
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.controller
 * @ProjectName : DentalHospital
 * @Version : 1.0.0
 */

@RestController
@RequestMapping("/api/duty")
public class DutyController {

    private final DutyService service;
    DutyController(DutyService service){
        this.service = service;
    }

    @GetMapping("/select")
    public R selectAll(){
        List<Duty> list = service.list();
        if (!list.isEmpty()) {
            return R.ok().message("查询成功").data("list",list);
        }

        return R.error().message("查询失败");
    }


    @PostMapping("/save")
    @ApiOperation(value = "save", notes = "save")
    public R save(@RequestBody Duty duty){
        boolean save = service.save(duty);

        if (save) {
            return R.ok().message("添加成功");
        }

        return R.error().message("添加失败");
    }

    @PostMapping("/update")
    @ApiOperation(value = "update", notes = "update")
    public R update(@RequestBody Duty duty){
        System.out.println(duty.getId());
        boolean update = service.updateById(duty);
        if (update){
            return R.ok().message("更新成功").data(null);
        }
        return R.error().message("更新失败").data(null);
    }


    @GetMapping("/delete")
    @ApiOperation(value = "delete", notes = "delete")
    public R delete(@RequestParam String id){
        boolean remove = service.removeById(id);
        if (remove) {
            return R.ok().message("删除成功");
        }

        return R.error().message("删除失败");
    }


}
