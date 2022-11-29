package com.itlr.reggie.mapper;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-25-13:56
 */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itlr.reggie.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}

