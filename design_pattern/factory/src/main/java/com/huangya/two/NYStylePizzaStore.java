package com.huangya.two;

import java.util.Objects;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/11
 * 加盟店
 */
public class NYStylePizzaStore extends PizzaStore {
    @Override
    public Pizza creatPizza(String type) {
        Pizza pizza = null;
        if (Objects.equals(type,"cheese")){
           pizza =  new NYStyleCheesePizza();
        }else if (Objects.equals(type,"pepperoni")){
            pizza = new NYStylePepperoniPizza();
        }
        return pizza;
    }
}
