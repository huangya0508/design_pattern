package com.huangya;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/1
 */
public class WeatherStation {
    public static void main(String[] args) {
        //首先先创建一个weather对象
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
    }
}
