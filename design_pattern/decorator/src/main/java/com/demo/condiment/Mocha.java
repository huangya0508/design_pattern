package com.demo.condiment;

import com.demo.beverage.Beverage;
import com.demo.beverage.BeverageSizeEnum;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 * 摩卡
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha() {
    }

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public BeverageSizeEnum getSize(){
        return beverage.getSize();
    }

    @Override
    public String getDesription() {
        return beverage.getDesription()+",Mocha";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        if (getSize() == BeverageSizeEnum.TALL){
            cost += .10;
        }else if (getSize() == BeverageSizeEnum.GRANDE){
            cost += .15;
        }else if (getSize() == BeverageSizeEnum.VENTI){
            cost += .20;
        }
        return cost;
    }
}
