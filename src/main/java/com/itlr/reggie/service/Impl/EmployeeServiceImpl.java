package com.itlr.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlr.reggie.entity.Employee;
import com.itlr.reggie.mapper.EmployeeMapper;
import com.itlr.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-19-17:13
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
