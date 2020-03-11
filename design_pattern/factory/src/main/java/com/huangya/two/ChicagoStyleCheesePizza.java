package com.huangya.two;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/11
 * 芝加哥披萨
 */
public class ChicagoStyleCheesePizza extends Pizza {
    //芝加哥披萨使用小番茄作为酱料，并使用厚饼
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }


    /**
     * 芝加哥披萨覆写了cut方法 将披萨切成正方形
     */
    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
