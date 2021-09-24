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

@ApiModel(value = "doctor")
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "doctor")
public class Doctor extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "work_time")
    @ApiModelProperty(value = "")
    private String workTime;

    @TableField(value = "`level`")
    @ApiModelProperty(value = "")
    private String level;

    @TableField(value = "department_name")
    @ApiModelProperty(value = "")
    private String departmentName;

    @TableField(value = "department_code")
    @ApiModelProperty(value = "")
    private String departmentCode;

    @TableField(value = "telephone")
    @ApiModelProperty(value = "")
    private String telephone;

    @TableField(value = "age")
    @ApiModelProperty(value = "")
    private String age;

    @TableField(value = "sex")
    @ApiModelProperty(value = "")
    private String sex;

    @TableField(value = "doctor_code")
    @ApiModelProperty(value = "")
    private String doctorCode;

    @TableField(value = "doctor_name")
    @ApiModelProperty(value = "")
    private String doctorName;

    @TableField(value = "doctor_id")
    @ApiModelProperty(value = "")
    private String doctorId;

    private static final long serialVersionUID = 1L;
}