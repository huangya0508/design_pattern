package com.huangya.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/9
 * 所有披萨的超类
 */
public abstract class Pizza {
    //每一个披萨都有自己的名称，面团类型，酱料类型和一套佐料
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing " + dough);
        System.out.println("Adding " + sauce);
        toppings.forEach(c -> System.out.println(c));
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
