package com.itlr.reggie.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlr.reggie.common.CustomException;
import com.itlr.reggie.entity.Dish;
import com.itlr.reggie.dto.DishDto;
import com.itlr.reggie.entity.DishFlavor;
import com.itlr.reggie.entity.Setmeal;
import com.itlr.reggie.entity.SetmealDish;
import com.itlr.reggie.mapper.DishMapper;
import com.itlr.reggie.service.DishFlavorService;
import com.itlr.reggie.service.DishService;
import com.itlr.reggie.service.SetmealDishService;
import com.itlr.reggie.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-22-16:35
 */
@Service
@Transactional
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    DishFlavorService dishFlavorService;

    @Autowired
    SetmealDishService setmealDishService;

    @Override
    public void saveWithFlavor(DishDto dishDto) {

        //保存菜品的基本信息到菜品表
        super.save(dishDto);
        //获取菜品id
        Long dishId = dishDto.getId();
        //获取菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();

        //将每条flavor的dishId赋上值
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表
        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public DishDto getByIdWithFlavor(Long id) {
        //通过id查询菜品基本信息
        Dish dish = super.getById(id);

        //创建dto对象
        DishDto dishDto = new DishDto();

        //对象拷贝
        BeanUtils.copyProperties(dish,dishDto);

        //条件查询flavor
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> list = dishFlavorService.list(queryWrapper);

        //将查询到的flavor赋值到dto对象中
        dishDto.setFlavors(list);

        return dishDto;
    }

    @Override
    public void updateWithFlavor(DishDto dishDto) {
        //根据id修改菜品的基本信息
        super.updateById(dishDto);

        //通过dish_id,删除菜品的flavor
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(queryWrapper);

        //获取前端提交的flavor数据
        List<DishFlavor> flavors = dishDto.getFlavors();

        //将每条flavor的dishId赋值
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());


        //将数据批量保存到dish_flavor数据库
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * 根据id删除分类
     * @param ids
     */
    @Override
    public void removeWithFlavor(List<Long> ids) {

        // 判断菜品是在售卖中
        LambdaQueryWrapper<Dish> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Dish::getId,ids);
        wrapper.eq(Dish::getStatus,1);
        int count = this.count(wrapper);
        if(count>0){
            throw new CustomException("菜品售卖中，无法删除");
        }

        // 判断是否有套餐关联
        LambdaQueryWrapper<SetmealDish> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 添加dish查询条件，根据菜品id进行查询
        setmealLambdaQueryWrapper.eq(SetmealDish::getDishId,ids);
        int count1 = setmealDishService.count(setmealLambdaQueryWrapper);

        //查看当前分类是否关联了套餐，如果已经关联，则抛出异常
        if (count1 > 0){
            //已关联套餐，抛出一个业务异常
            throw new CustomException("当前菜品关联了套餐，不能删除");
        }

        //正常删除
        super.removeByIds(ids);

        LambdaQueryWrapper<DishFlavor> dishFlavorWrapper = new LambdaQueryWrapper<>();
        dishFlavorWrapper.in(DishFlavor::getDishId,ids);
        dishFlavorService.remove(dishFlavorWrapper);
    }

}
