package com.huangya.three;

import java.util.Objects;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/11
 * 披萨店
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza creatPizza(String type) {
        Pizza pizza = null;
        //纽约店会用到纽约披萨原料工厂提供的原料
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();

        if (Objects.equals(type,"cheese")){
          pizza = new CheesePizza(factory);
          pizza.setName("new york style cheese pizza");
        }else if (Objects.equals(type,"clam")){
          pizza = new ClamPizza(factory);
          pizza.setName("new york style clam pizza");
        }
        return pizza;
    }
}



