package com.huangya;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/1
 * 主题
 */
public interface Subject {
    /**
     * 观察者用来注册的方法
     * @param o
     */
    public void registerObserver(Observer o);

    /**
     * 观察者用来删除的方法
     * @param o
     */
    public void removeObserver(Observer o);

    /**
     * 当主题发生改变时，这个方法会被调用，同来通知所有观察者
     */
    public void notifyObserver();
}
