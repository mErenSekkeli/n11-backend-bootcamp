# Weather API Integration Project

This project integrates with external weather APIs to provide weather forecasts for specified locations and date ranges. It demonstrates the use of RESTful service calls, JSON data handling, and Spring Boot for backend development.

## Technologies Used

- **Spring Boot**: For creating the RESTful services.
- **Feign**: To make HTTP requests to external weather APIs.
- **Java 21**: For backend logic including stream API and new date/time API.
- **Maven**: For project management and build tool.
- **Visual Crossing Weather API**: As the external weather data provider.


## Api Endpoints

The project defines the following RESTful endpoints:

* **GET `/api/weather/summary`**: Fetches the weather summary for a specified location and date range.
** Request Parameters:
    - `location`: (required): The location for which to fetch the weather (e.g., "Ankara,TR").
    - `startDate`: (required): The start date of the date range (format: YYYY-MM-DD).
    - `endDate`: (not required): The start date of the date range (format: YYYY-MM-DD).

## Request Example

    
    GET /api/weather/summary?location=Ankara,TR&startDate=2020-10-01&endDate=2020-10-02
    

## Response Example

    {
        "address": "Ankara,TR",
        "days": [
            {
            "date": "2020-10-01",
            "temp": 68.8,
            "feelslike": 68.8,
            "description": "Partly cloudy throughout the day with rain."
            },
            {
            "date": "2020-10-02",
            "temp": 70.0,
            "feelslike": 70.0,
            "description": "Partly cloudy throughout the day."
            }
        ]
    }
