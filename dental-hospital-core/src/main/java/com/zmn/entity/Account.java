package com.zmn.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
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

@ApiModel(value = "account")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "account")
public class Account extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "note")
    @ApiModelProperty(value = "")
    private String note;

    @TableField(value = "card")
    @ApiModelProperty(value = "")
    private String card;

    @TableField(value = "age")
    @ApiModelProperty(value = "")
    private String age;

    @TableField(value = "sex")
    @ApiModelProperty(value = "")
    private String sex;

    @TableField(value = "role_code")
    @ApiModelProperty(value = "")
    private String roleCode;

    @TableField(value = "openid")
    @ApiModelProperty(value = "")
    private String openid;

    @TableField(value = "account_id")
    @ApiModelProperty(value = "")
    private String accountId;

    @TableField(value = "telephone")
    @ApiModelProperty(value = "")
    private String telephone;

    private static final long serialVersionUID = 1L;
}