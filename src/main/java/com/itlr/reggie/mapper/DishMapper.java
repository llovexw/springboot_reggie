package com.itlr.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itlr.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-22-16:32
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
