package com.huangya.three;

import com.huangya.three.stock.*;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/14
 * 生产原料的工厂
 * 在接口中 每个原料都有对应的方法来创建原料
 */
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClams();
}
