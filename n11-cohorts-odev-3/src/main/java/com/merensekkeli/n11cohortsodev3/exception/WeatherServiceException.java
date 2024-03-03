package com.merensekkeli.n11cohortsodev3.exception;

public class WeatherServiceException extends RuntimeException{
    public WeatherServiceException(String message) {
        super(message);
    }
}
