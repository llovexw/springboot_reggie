package com.itlr.reggie.dto;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-17:09
 */
import com.itlr.reggie.entity.Setmeal;
import com.itlr.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}

