package com.huangya.two;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/11
 * 纽约披萨
 */
public class NYStylePepperoniPizza extends Pizza {
    //纽约披萨有大蒜番茄酱和薄饼
    public NYStylePepperoniPizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
