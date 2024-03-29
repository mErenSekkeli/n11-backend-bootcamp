package com.merensekkeli.n11cohortsodev3.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WeatherResponse {
    private String address;
    private List<DayInfo> days;
}

