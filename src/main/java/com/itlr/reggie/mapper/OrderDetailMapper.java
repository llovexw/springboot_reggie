package com.itlr.reggie.mapper;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-25-14:29
 */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itlr.reggie.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
}


