package com.example.myfirstapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.myfirstapplication.databinding.FragmentForecastBinding
import java.time.format.DateTimeFormatter

class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()



    private val forecastData = listOf(
        DayForecast(1662068591L,1662068591L,1663442051L, ForecastTemp(51f, 0f, 70f),2.2f,76),
        DayForecast(1662154991L,1662102071L,1663442111L,ForecastTemp(52f, 1f, 71f),1.2f,86),
        DayForecast(1662241391L,1662188531L,1663442171L, ForecastTemp(53f, 2f, 72f),2.7f,96),
        DayForecast(1662327791L,1662274991L,1663442231L,ForecastTemp(54f, 3f, 73f),1.8f,56),
        DayForecast(1662361451L,1662361451L,1663442291L, ForecastTemp(55f, 4f, 74f),2.9f,46),
        DayForecast(1662447911L,1662447911L,1663442351L,ForecastTemp(56f, 5f, 75f),3.1f,36),
        DayForecast(1662620771L,1662620771L,1663442411L, ForecastTemp(57f, 6f, 76f),2.1f,26),
        DayForecast(1662759791L,1662759791L,1663442471L,ForecastTemp(58f, 7f, 77f),1.3f,16),
        DayForecast(1662793631L,1662793631L,1663442531L, ForecastTemp(59f, 8f, 78f),2.4f,6),
        DayForecast(1662880091L,1662880091L,1663442591L,ForecastTemp(60f, 9f, 79f),1.9f,55),
        DayForecast(1662966551L,1662966551L,1663442651L,ForecastTemp(61f, 10f, 80f),1.8f,54),
        DayForecast(1663053011L,1663053011L,1663442711L,ForecastTemp(62f, 11f, 81f),1.7f,53),
        DayForecast(1663139471L,1663139471L,1663442771L,ForecastTemp(63f, 12f, 82f),1.6f,53),
        DayForecast(1663225931L,1663225931L,1663442831L,ForecastTemp(64f, 13f, 83f),1.5f,52),
        DayForecast(1663312391L,1663312391L,1663442891L,ForecastTemp(65f, 14f, 84f),1.4f,51),
        DayForecast(1663398851L,1663398851L,1663442951L,ForecastTemp(66f, 15f, 85f),1.3f,59),

        )

//date: 1663199760
    //sunset: 1663182000
    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(forecastData)
    (activity as AppCompatActivity).supportActionBar?.title = "Forecast"
    }




}