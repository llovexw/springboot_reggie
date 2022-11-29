package com.itlr.reggie.service.Impl;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-21:29
 */
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlr.reggie.entity.User;
import com.itlr.reggie.mapper.UserMapper;
import com.itlr.reggie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}


