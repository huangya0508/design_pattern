package com.huangya;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/9
 */
public abstract class Pizza {
    void prepare(){
        System.out.println("prepare");
    }
    void bake(){
        System.out.println("bake");
    }
    void cut(){
        System.out.println("cut");
    }
    void box(){
        System.out.println("box");
    }
}
