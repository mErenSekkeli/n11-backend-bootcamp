package com.merensekkeli.n11cohortsodev3.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DayInfo {
    private String date;
    private double temp;
    private double feelslike;
    private String description;
}
