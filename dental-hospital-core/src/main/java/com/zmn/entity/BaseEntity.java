package com.zmn.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/22 上午 10:51
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.entity
 * @ProjectName : DentalHospital
 * @Version : 1.0.0
 */
@Data
@ApiModel(value="公共字段", description = "公共字段")
public class BaseEntity {


    @TableField(value = "creat_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value="创建时间")
    private LocalDateTime creatTime;


    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;
}
