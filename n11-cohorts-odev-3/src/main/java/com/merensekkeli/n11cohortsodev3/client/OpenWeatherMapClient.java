package com.merensekkeli.n11cohortsodev3.client;

import com.merensekkeli.n11cohortsodev3.response.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openWeatherMapClient", url = "https://api.openweathermap.org/data/2.5")
public interface OpenWeatherMapClient {

    @GetMapping("/weather")
    WeatherResponse getWeather(@RequestParam("q") String city,
                               @RequestParam("appid") String appid,
                               @RequestParam("units") String units,
                               @RequestParam("lang") String lang);
}