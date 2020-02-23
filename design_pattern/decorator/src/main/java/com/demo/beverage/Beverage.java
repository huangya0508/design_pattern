package com.demo.beverage;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/22
 * 饮料抽象类
 */
public abstract class Beverage {
    String desription = "Unkonwn Beverage";

    BeverageSizeEnum size ;//饮料的容量

    public String getDesription() {
        return desription;
    }

    public abstract double cost();

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public BeverageSizeEnum getSize() {
        return size;
    }

    public void setSize(BeverageSizeEnum size) {
        this.size = size;
    }
}
