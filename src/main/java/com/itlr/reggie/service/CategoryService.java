package com.itlr.reggie.service;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-22-16:15
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.itlr.reggie.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}

