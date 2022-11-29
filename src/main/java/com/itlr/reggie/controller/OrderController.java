package com.itlr.reggie.controller;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-25-14:31
 */
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itlr.reggie.common.R;
import com.itlr.reggie.entity.Orders;
import com.itlr.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        log.info("orders={}",orders);

        orderService.submit(orders);
        return R.success("用户下单成功");
    }

    @GetMapping("/page")
    public R<Page> page (int page, int pageSize, String number){
        // 构造分页器
        Page pageInfo = new Page(page, pageSize);

        // 构造条件构造器
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();

        // 添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(number),Orders::getNumber,number);

        // 添加排序
        orderService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

}



