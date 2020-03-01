package com.huangya;

import java.util.ArrayList;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/1
 * 天气
 */
public class WeatherData implements Subject{
    //用来记录观察者 在构造函数中建立
    private ArrayList<Observer> observer;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observer = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observer.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observer.indexOf(o);
        if (i >= 0){
            observer.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        //我们把状态告诉观察者，因为观察者都实现了updata方法，所以我们知道如何通知他
        for (int i = 0; i < observer.size(); i++) {
            Observer observer = this.observer.get(i);
            observer.updata(temperature,humidity,pressure);

        }
    }

    /**
     * 当气象站得到更新观测值时，我们通知观察者
     */
    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public ArrayList<Observer> getObserver() {
        return observer;
    }

    public void setObserver(ArrayList<Observer> observer) {
        this.observer = observer;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
