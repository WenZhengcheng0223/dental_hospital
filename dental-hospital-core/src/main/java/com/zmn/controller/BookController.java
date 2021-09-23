package com.zmn.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zmn.entity.Account;
import com.zmn.entity.Book;
import com.zmn.service.BookService;
import com.zmn.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "预约管理接口")
@RestController
@RequestMapping("/api/book")
public class BookController {


    private final BookService service;
    BookController(BookService service){
        this.service = service;
    }

    @ApiOperation(value = "查询", notes = "查询所有数据")
    @GetMapping("/select")
    public R selectAll(){

        List<Book> list = service.list();
        if (!list.isEmpty()) {
            return R.ok().message("查询成功").data("list",list);
        }

        return R.error().message("查询失败");
    }


    @PostMapping("/save")
    @ApiOperation(value = "插入", notes = "插入一条记录")
    public R save(Book book){
        boolean save = service.save(book);

        if (save) {
            return R.ok().message("添加成功");
        }

        return R.error().message("添加失败");
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新", notes = "更新数据")
    public R update(@ApiParam(name = "book",value = "") Book book){

        boolean update = service.update(book, new UpdateWrapper<>(book).eq("id", book.getBookId()));
        if (update){
            return R.ok().message("更新成功");
        }
        return R.error().message("更新失败");
    }


    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除一条记录", notes = "根据id删除一条记录")
    public R delete(
            @ApiParam(name = "id") long id){

        boolean remove = service.removeById(id);
        if (remove) {
            return R.ok().message("删除成功");
        }

        return R.error().message("删除失败");
    }

}
