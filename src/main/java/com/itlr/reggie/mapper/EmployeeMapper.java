package com.itlr.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itlr.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-19-17:09
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
