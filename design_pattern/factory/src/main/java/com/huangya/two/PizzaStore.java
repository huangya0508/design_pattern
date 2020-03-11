package com.huangya.two;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/9
 * 订单系统
 */
public abstract class PizzaStore {

    Pizza orderPizza(String type){
        Pizza pizza = creatPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }


    /**
     * 让具体的加盟店确定自己的风味
     * @param type
     * @return
     */
    protected abstract Pizza creatPizza(String type);
}
