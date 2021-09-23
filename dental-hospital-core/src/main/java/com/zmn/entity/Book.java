package com.zmn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/23 上午 01:03
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.entity
 * @ProjectName : DentalHospital
 * @Version : 1.0.0
 */

@ApiModel(value = "book")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book")
public class Book extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "note")
    @ApiModelProperty(value = "")
    private String note;

    @TableField(value = "`status`")
    @ApiModelProperty(value = "")
    private String status;

    @TableField(value = "doctor_name")
    @ApiModelProperty(value = "")
    private String doctorName;

    @TableField(value = "doctor_code")
    @ApiModelProperty(value = "")
    private String doctorCode;

    @TableField(value = "telephone")
    @ApiModelProperty(value = "")
    private String telephone;

    @TableField(value = "project_name")
    @ApiModelProperty(value = "")
    private String projectName;

    @TableField(value = "project_code")
    @ApiModelProperty(value = "")
    private String projectCode;

    @TableField(value = "book_name")
    @ApiModelProperty(value = "")
    private String bookName;

    @TableField(value = "book_id")
    @ApiModelProperty(value = "")
    private String bookId;

    private static final long serialVersionUID = 1L;
}