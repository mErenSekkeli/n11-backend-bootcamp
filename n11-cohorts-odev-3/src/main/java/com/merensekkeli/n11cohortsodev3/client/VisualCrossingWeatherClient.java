package com.merensekkeli.n11cohortsodev3.client;

import com.merensekkeli.n11cohortsodev3.response.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "visualCrossingWeatherClient", url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services")
public interface VisualCrossingWeatherClient {

    @GetMapping("/timeline/{location}/{startDate}/{endDate}")
    WeatherResponse getWeatherForPeriod(@PathVariable("location") String location,
                                        @PathVariable("startDate") String startDate,
                                        @PathVariable(value = "endDate", required = false) String endDate,
                                        @RequestParam("key") String apiKey);
}