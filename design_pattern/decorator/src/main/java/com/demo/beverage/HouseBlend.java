package com.demo.beverage;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 * 综合咖啡
 */
public class HouseBlend extends Beverage{
    public HouseBlend() {
        desription = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
