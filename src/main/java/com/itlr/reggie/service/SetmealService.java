package com.itlr.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itlr.reggie.dto.SetmealDto;
import com.itlr.reggie.entity.Setmeal;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-22-16:34
 */
public interface SetmealService extends IService<Setmeal> {
    @Transactional
    void saveWithDish(SetmealDto setmealDto);

    @Transactional
    void removeWithDish(List<Long> ids);

    SetmealDto getByIdWithDish(Long id);

    void updateWithDish(SetmealDto setmealDto);
}
