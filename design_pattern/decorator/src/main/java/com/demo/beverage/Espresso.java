package com.demo.beverage;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 * 浓缩咖啡
 */
public class Espresso extends Beverage{
    public Espresso() {
        desription = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
