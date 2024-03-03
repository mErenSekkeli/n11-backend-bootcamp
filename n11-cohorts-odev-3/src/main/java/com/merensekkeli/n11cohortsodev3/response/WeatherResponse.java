package com.merensekkeli.n11cohortsodev3.response;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    private String name;
    private Main main;
    private List<Weather> weather;

    @Data
    public static class Main {
        private double temp;
        private double feels_like;

    }
    @Data
    public static class Weather {
        private String main;
        private String description;

    }
}

