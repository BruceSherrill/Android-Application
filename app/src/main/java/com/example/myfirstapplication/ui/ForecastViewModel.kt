package com.example.myfirstapplication.ui

import androidx.lifecycle.ViewModel
import com.example.myfirstapplication.models.DayForecast
import com.example.myfirstapplication.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel() {
    private val _dayForecast = Channel<DayForecast>()

    public val dayForecast: Flow<DayForecast> = _dayForecast.receiveAsFlow()

    fun fetchData() = runBlocking {
        val dayForecast = api.getForecast("55125")
        _dayForecast.trySend(dayForecast)
    }
}