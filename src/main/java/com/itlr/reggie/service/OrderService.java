package com.itlr.reggie.service;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-25-14:30
 */
import com.baomidou.mybatisplus.extension.service.IService;
import com.itlr.reggie.entity.Orders;

public interface OrderService extends IService<Orders> {
    void submit(Orders orders);
}

