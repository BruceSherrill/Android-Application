package com.example.myfirstapplication.service

import com.example.myfirstapplication.models.CurrentConditions
import com.example.myfirstapplication.models.DayForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "5e816460d82b198caf779180a6b5de67",
        @Query("units") units: String = "imperial",
    ) : CurrentConditions


    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "5e816460d82b198caf779180a6b5de67",
        @Query("cnt") cnt: String = "16",
        @Query("units") units: String = "imperial",
    ) : DayForecast

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "5e816460d82b198caf779180a6b5de67",
        @Query("units") units: String = "imperial",
        ):CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "5e816460d82b198caf779180a6b5de67",
        @Query("cnt") cnt: String = "16",
        @Query("units") units: String = "imperial",
    ) : DayForecast
}