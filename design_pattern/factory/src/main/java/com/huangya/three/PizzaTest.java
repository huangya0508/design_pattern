package com.huangya.three;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/14
 * 抽象工厂
 */
public class PizzaTest {
    public static void main(String[] args) {
        //创建一个纽约披萨店
        PizzaStore pizzaStore = new NYPizzaStore();
        //接受订单
        pizzaStore.orderPizza("cheese");


    }
}
