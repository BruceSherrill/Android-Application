package com.example.myfirstapplication.models

data class DayForecast(
    val date: Long,
    val sunrise: Long,
    val sunset: Long,
    val forecastTemp: com.example.myfirstapplication.models.ForecastTemp,
    val pressure: Float,
    val humidity: Int,
)

data class ForecastTemp(
    val min: Float,
    val max: Float,
)