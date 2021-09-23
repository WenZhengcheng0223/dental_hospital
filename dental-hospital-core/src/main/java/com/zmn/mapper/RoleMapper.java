package com.zmn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zmn.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description : 
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/23 上午 01:03
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.mapper
 * @ProjectName : DentalHospital
 * @Version : 1.0.0
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}