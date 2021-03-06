package com.zmn.controller;


import com.zmn.entity.Book;
import com.zmn.service.BookService;
import com.zmn.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "预约管理接口")
@RestController
@RequestMapping("/api/book")
public class BookController {


    private final BookService service;
    BookController(BookService service){
        this.service = service;
    }

    @GetMapping("/select")
    public R selectAll(){
        List<Book> list = service.list();
        if (!list.isEmpty()) {
            return R.ok().message("查询成功").data("list",list);
        }

        return R.error().message("查询失败");
    }


    @PostMapping("/save")
    @ApiOperation(value = "save", notes = "save")
    public R save(@RequestBody Book book){
        boolean save = service.save(book);

        if (save) {
            return R.ok().message("添加成功");
        }

        return R.error().message("添加失败");
    }

    @PostMapping("/update")
    @ApiOperation(value = "update", notes = "update")
    public R update(@RequestBody Book book){
        System.out.println(book.getId());
        boolean update = service.updateById(book);
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
