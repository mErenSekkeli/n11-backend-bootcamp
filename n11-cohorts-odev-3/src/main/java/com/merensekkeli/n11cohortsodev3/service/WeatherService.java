package com.merensekkeli.n11cohortsodev3.service;

import com.merensekkeli.n11cohortsodev3.client.VisualCrossingWeatherClient;
import com.merensekkeli.n11cohortsodev3.response.DayInfo;
import com.merensekkeli.n11cohortsodev3.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final VisualCrossingWeatherClient weatherClient;

    public WeatherService(VisualCrossingWeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherResponse getPeriodWeatherData(String location, String startDate, String endDate) {
        WeatherResponse weatherResponse = weatherClient.getWeatherForPeriod(location, startDate, endDate, apiKey);
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);

        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(start, end.plusDays(1));

        List<DayInfo> dayInfos = IntStream.range(0, (int) daysBetween)
                .mapToObj(i -> {
                    LocalDate currentDate = start.plusDays(i);
                    DayInfo day = weatherResponse.getDays().get(i);
                    return new DayInfo(
                            currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE),
                            day.getTemp(),
                            day.getFeelslike(),
                            day.getDescription()
                    );
                })
                .collect(Collectors.toList());

        return new WeatherResponse(weatherResponse.getAddress(), dayInfos);
    }
}
