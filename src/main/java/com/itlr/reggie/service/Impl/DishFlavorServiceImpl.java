package com.itlr.reggie.service.Impl;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-15:45
 */
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlr.reggie.entity.DishFlavor;
import com.itlr.reggie.mapper.DishFlavorMapper;
import com.itlr.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}

