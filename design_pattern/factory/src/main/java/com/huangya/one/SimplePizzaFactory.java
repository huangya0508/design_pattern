package com.huangya.one;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/9
 * 披萨工厂 虽然代码和原来放在PizzaStore里面一样的 但是可能会有很多披萨店 现在把披萨店当成客户群体
 */
public class SimplePizzaFactory {
    public Pizza creatPizza(String type){
        Pizza pizza = null;
        if ("cheese".equals(type)){
            pizza = new CheesePizzs();
        }else if ("greek".equals(type)){
            pizza = new GreekPizza();
        }else if ("pepperoni".equals(type)){
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
