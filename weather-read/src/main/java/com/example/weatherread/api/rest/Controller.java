package com.example.weatherread.api.rest;


import com.example.weatherread.api.model.Data;

import com.example.weatherread.api.service.ServiceWeather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class Controller {


        private ServiceWeather service;

        public Controller(ServiceWeather service) {
            this.service = service;
        }

        @GetMapping("/current")
        public Data getCurrentWeatherData(@RequestParam final String city) {
            return service.getCurrentWeatherData(city);
        }

        @GetMapping("/forecast")
        public String getForecastWeatherData(@RequestParam final String city){
            return service.getForecastWeatherData(city);
        }


    }
