package com.merensekkeli.n11cohortsodev3.service;

import com.merensekkeli.n11cohortsodev3.client.OpenWeatherMapClient;
import com.merensekkeli.n11cohortsodev3.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Map;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final OpenWeatherMapClient openWeatherMapClient;

    public WeatherService(OpenWeatherMapClient openWeatherMapClient) {
        this.openWeatherMapClient = openWeatherMapClient;
    }

    public Object getDailyWeather(String city, String units, String lang) {
        WeatherResponse weatherResponse = openWeatherMapClient.getWeather(city, apiKey, units, lang);
        Map<String, Object> response = new HashMap<>();
        response.put("name", weatherResponse.getName());
        response.put("temperature", weatherResponse.getMain().getTemp());
        response.put("feels_like", weatherResponse.getMain().getFeels_like());

        if (!weatherResponse.getWeather().isEmpty()) {
            response.put("main", weatherResponse.getWeather().getFirst().getMain());
            response.put("description", weatherResponse.getWeather().getFirst().getDescription());
        }

        return response;
    }
}
