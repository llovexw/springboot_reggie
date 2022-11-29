package com.itlr.reggie.mapper;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-22-16:14
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itlr.reggie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}

