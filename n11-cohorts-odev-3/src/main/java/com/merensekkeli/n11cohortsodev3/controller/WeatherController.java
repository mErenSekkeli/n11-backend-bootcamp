package com.merensekkeli.n11cohortsodev3.controller;

import com.merensekkeli.n11cohortsodev3.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/period")
    public ResponseEntity<?> getCurrentWeather(@RequestParam String location,
                                               @RequestParam String startDate,
                                               @RequestParam(required = false) String endDate) {
        return ResponseEntity.ok(weatherService.getPeriodWeatherData(location, startDate, endDate));
    }

}
