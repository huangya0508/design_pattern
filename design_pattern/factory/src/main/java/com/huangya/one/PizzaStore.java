package com.huangya.one;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/9
 * 披萨店
 */
public class PizzaStore {
    //把工厂引用进来
    SimplePizzaFactory factory;

    //通过构造方法实例化
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    Pizza orderPizza(String type){
        Pizza pizza = factory.creatPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
