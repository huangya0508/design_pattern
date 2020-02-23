package com.demo.beverage;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 * 浓缩咖啡
 */
public class Concentrate extends Beverage {
    public Concentrate() {
        desription = "Concentrate";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
