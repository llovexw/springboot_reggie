package com.itlr.reggie.service.Impl;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-25-14:31
 */
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlr.reggie.entity.OrderDetail;
import com.itlr.reggie.mapper.OrderDetailMapper;
import com.itlr.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}

