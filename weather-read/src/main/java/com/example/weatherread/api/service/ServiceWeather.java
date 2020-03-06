package com.example.weatherread.api.service;


import com.example.weatherread.api.model.Data;

public interface ServiceWeather {

    Data getCurrentWeatherData(String city);

    String getForecastWeatherData(String city);
}
