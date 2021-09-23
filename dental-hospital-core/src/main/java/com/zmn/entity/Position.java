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

@ApiModel(value = "`position`")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`position`")
public class Position extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "`level`")
    @ApiModelProperty(value = "")
    private String level;

    @TableField(value = "department_name")
    @ApiModelProperty(value = "")
    private String departmentName;

    @TableField(value = "department_code")
    @ApiModelProperty(value = "")
    private String departmentCode;

    @TableField(value = "doctor_name")
    @ApiModelProperty(value = "")
    private String doctorName;

    @TableField(value = "doctor_code")
    @ApiModelProperty(value = "")
    private String doctorCode;

    @TableField(value = "positon_name")
    @ApiModelProperty(value = "")
    private String positonName;

    @TableField(value = "position_id")
    @ApiModelProperty(value = "")
    private String positionId;

    private static final long serialVersionUID = 1L;
}