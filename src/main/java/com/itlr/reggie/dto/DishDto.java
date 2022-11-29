package com.itlr.reggie.dto;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-16:15
 */
import com.itlr.reggie.entity.Dish;
import com.itlr.reggie.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}

