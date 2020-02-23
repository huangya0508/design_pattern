package com.demo.beverage;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 *  深焙咖啡
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        desription = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        if (getSize() == BeverageSizeEnum.TALL){
            return .49;
        }else if (getSize() == BeverageSizeEnum.VENTI){
            return 1.49;
        }else {
            return .99;
        }
    }

}
