package com.itlr.reggie.service.Impl;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-17:10
 */
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlr.reggie.entity.SetmealDish;
import com.itlr.reggie.mapper.SetmealDishMapper;
import com.itlr.reggie.service.SetmealDishService;
import org.springframework.stereotype.Service;

@Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper,SetmealDish> implements SetmealDishService {
}

