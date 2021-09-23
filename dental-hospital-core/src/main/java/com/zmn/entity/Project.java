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

@ApiModel(value = "project")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "project")
public class Project extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "end_time")
    @ApiModelProperty(value = "")
    private Date endTime;

    @TableField(value = "start_time")
    @ApiModelProperty(value = "")
    private Date startTime;

    @TableField(value = "project_result")
    @ApiModelProperty(value = "")
    private String projectResult;

    @TableField(value = "patient_name")
    @ApiModelProperty(value = "")
    private String patientName;

    @TableField(value = "patient_code")
    @ApiModelProperty(value = "")
    private String patientCode;

    @TableField(value = "doctor_name")
    @ApiModelProperty(value = "")
    private String doctorName;

    @TableField(value = "doctor_code")
    @ApiModelProperty(value = "")
    private String doctorCode;

    @TableField(value = "`time`")
    @ApiModelProperty(value = "")
    private String time;

    @TableField(value = "project_code")
    @ApiModelProperty(value = "")
    private String projectCode;

    @TableField(value = "project_name")
    @ApiModelProperty(value = "")
    private String projectName;

    @TableField(value = "project_id")
    @ApiModelProperty(value = "")
    private String projectId;

    private static final long serialVersionUID = 1L;
}