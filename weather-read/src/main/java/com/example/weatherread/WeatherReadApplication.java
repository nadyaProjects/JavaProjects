package com.example.weatherread;

import com.example.weatherread.api.model.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class WeatherReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherReadApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(final RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(final RestTemplate restTemplate) {
		return args -> {
			final Data currentWeatherData = restTemplate.getForObject(
					"http://api.openweathermap.org/data/2.5/weather?q=Warsaw&appid=f92ceb0c7deb150dc2c39e6db51061c2",
					Data.class);
			System.out.println(currentWeatherData);
			final String forecastWeatherData = restTemplate.getForObject(
					"http://api.openweathermap.org/data/2.5/forecast?q=Warsaw&appid=f92ceb0c7deb150dc2c39e6db51061c2",
					String.class);
			System.out.println(forecastWeatherData);
		};
	}

}
