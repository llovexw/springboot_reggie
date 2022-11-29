package com.itlr.reggie.mapper;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-25-14:29
 */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itlr.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}

