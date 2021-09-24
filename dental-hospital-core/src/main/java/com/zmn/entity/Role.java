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

@ApiModel(value = "`role`")
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`role`")
public class Role extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "role_code")
    @ApiModelProperty(value = "")
    private String roleCode;

    @TableField(value = "role_name")
    @ApiModelProperty(value = "")
    private String roleName;

    @TableField(value = "role_id")
    @ApiModelProperty(value = "")
    private String roleId;

    private static final long serialVersionUID = 1L;
}