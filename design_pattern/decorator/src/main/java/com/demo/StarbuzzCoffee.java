package com.demo;

import com.demo.beverage.*;
import com.demo.condiment.Mocha;
import com.demo.condiment.Soy;
import com.demo.condiment.Whip;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        //订一杯Espresso 不需要调料
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDesription()+"$"+espresso.cost());

        //订一杯浓缩咖啡加调料双摩卡和奶泡
        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDesription()+"$"+darkRoast.cost());

        //订一杯小杯综合咖啡加调料豆浆，摩卡，奶泡
        Beverage houseBlend = new HouseBlend();
        houseBlend.setSize(BeverageSizeEnum.TALL);
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println(houseBlend.getDesription()+"$"+houseBlend.cost());

        //订一杯小杯Espresso
        Beverage beverage = new Concentrate();
        beverage.setSize(BeverageSizeEnum.TALL);
        System.out.println("TALL"+beverage.getDesription()+"$"+beverage.cost());

    }
}
