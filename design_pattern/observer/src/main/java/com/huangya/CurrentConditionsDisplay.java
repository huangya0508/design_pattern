package com.huangya;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/1
 * 目前状态布告板
 */
public class CurrentConditionsDisplay implements Observer ,DisplayElement{
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay() {
    }
    /**
     * 构造器需要一个weatherData对象(也就是主题）作为注册只用
     * @param weatherData
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    /**
     * 当updata被调用的时，我们帮温度和湿度保存起来，然后调用display
     * @param temperature 温度
     * @param humidity    湿度
     * @param pressure    气压
     */
    @Override
    public void updata(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    /**
     * display 就是帮当前的温度和湿度显示出来
     */
    @Override
    public void display() {
        System.out.println("Current conditions:"+temperature+"F dearees and "+ humidity+"% humidity");
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

    public Subject getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(Subject weatherData) {
        this.weatherData = weatherData;
    }
}
