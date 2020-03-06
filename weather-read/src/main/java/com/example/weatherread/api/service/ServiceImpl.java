package com.example.weatherread.api.service;

import org.springframework.stereotype.Service;
import com.example.weatherread.api.model.Data;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ServiceImpl implements ServiceWeather {
    private final RestTemplate restTemplate;

    private final static String API_KEY = "f92ceb0c7deb150dc2c39e6db51061c2";
    private final static String URL = "http://api.openweathermap.org/data/2.5";
    private final static String CURRENT_WEATHER_PATH = "/weather";
    private final static String FORECAST_WEATHER_PATH = "/forecast";

    public ServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public com.example.weatherread.api.model.Data getCurrentWeatherData(final String city) {
        return restTemplate.getForObject(buildUrl(CURRENT_WEATHER_PATH, city), Data.class);
    }

    @Override
    public String getForecastWeatherData(String city) {
        return restTemplate.getForObject(buildUrl(FORECAST_WEATHER_PATH, city), String.class);
    }

    private String buildUrl(final String api, final String city) {
        return UriComponentsBuilder.fromHttpUrl(URL + api)
                .queryParam("q", city)
                .queryParam("appid", API_KEY)
                .build()
                .toUriString();
    }
}
