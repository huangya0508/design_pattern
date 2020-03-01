package com.huangya;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/1
 * 观察者
 */
public interface Observer {
    /**
     * 当气象观察值发生改变时，主题会把这些状态值作为方法的参数，传送给观察者
     * @param temperature 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    public void updata(float temperature,float humidity,float pressure);
}
