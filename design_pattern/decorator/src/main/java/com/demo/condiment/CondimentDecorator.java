package com.demo.condiment;

import com.demo.beverage.Beverage;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 *  调料抽象类
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDesription();
}
