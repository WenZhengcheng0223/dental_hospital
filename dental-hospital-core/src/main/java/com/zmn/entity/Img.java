package com.zmn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

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

@ApiModel(value = "img")
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "img")
public class Img extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "note")
    @ApiModelProperty(value = "")
    private String note;

    @TableField(value = "`type`")
    @ApiModelProperty(value = "")
    private String type;

    @TableField(value = "img_url")
    @ApiModelProperty(value = "")
    private String imgUrl;

    @TableField(value = "img_id")
    @ApiModelProperty(value = "")
    private String imgId;

    private static final long serialVersionUID = 1L;
}