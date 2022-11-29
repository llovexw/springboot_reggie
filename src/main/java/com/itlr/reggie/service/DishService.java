package com.itlr.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itlr.reggie.entity.Dish;
import com.itlr.reggie.dto.DishDto;

import java.util.List;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-22-16:34
 */
public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);

    DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);

    void removeWithFlavor(List<Long> ids);
}
