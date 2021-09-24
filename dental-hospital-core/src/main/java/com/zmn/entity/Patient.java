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

@ApiModel(value = "patient")
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "patient")
public class Patient extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "note")
    @ApiModelProperty(value = "")
    private String note;

    @TableField(value = "telephone")
    @ApiModelProperty(value = "")
    private String telephone;

    @TableField(value = "card")
    @ApiModelProperty(value = "")
    private String card;

    @TableField(value = "age")
    @ApiModelProperty(value = "")
    private String age;

    @TableField(value = "sex")
    @ApiModelProperty(value = "")
    private String sex;

    @TableField(value = "patient_code")
    @ApiModelProperty(value = "")
    private String patientCode;

    @TableField(value = "patient_name")
    @ApiModelProperty(value = "")
    private String patientName;

    @TableField(value = "patient_id")
    @ApiModelProperty(value = "")
    private String patientId;

    private static final long serialVersionUID = 1L;
}