package com.huangya.two;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/11
 * 工厂方法
 */
public class PizzaTest {
    public static void main(String[] args) {
        PizzaStore nyStylePizzaStore = new NYStylePizzaStore();
        Pizza pizza = nyStylePizzaStore.orderPizza("pepperoni");
        System.out.println("Ethan ordered a "+pizza.getName());

        System.out.println("------------------------------");

        PizzaStore chicagoStylePizzaStore = new ChicagoStylePizzaStore();
        pizza = chicagoStylePizzaStore.orderPizza("cheese");
        System.out.println("Joel ordered a "+pizza.getName());
    }
}
