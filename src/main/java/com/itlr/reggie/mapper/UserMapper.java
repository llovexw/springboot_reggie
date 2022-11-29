package com.itlr.reggie.mapper;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-21:28
 */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itlr.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

