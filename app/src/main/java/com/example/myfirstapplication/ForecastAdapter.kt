package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class ForecastAdapter(private val data: List<DayForecast>) : RecyclerView.Adapter<ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {

        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}

class ForecastViewHolder(view : View) : RecyclerView.ViewHolder(view){
    private val forecastDate: TextView
    private val forecastSunrise: TextView
    private val forecastSunset: TextView
    private val forecastTemp: TextView
    private val forecastTempMax: TextView
    private val forecastTempMin: TextView
    //private val forecastPressure: TextView
    //private val forecastHumidity: TextView


    init {
        forecastDate = view.findViewById(R.id.forecast_date)
        forecastSunrise = view.findViewById(R.id.forecast_sunrise)
        forecastSunset = view.findViewById(R.id.forecast_sunset)
        forecastTemp = view.findViewById(R.id.forecast_temp)
        forecastTempMax = view.findViewById(R.id.forecast_temp_max)
        forecastTempMin = view.findViewById(R.id.forecast_temp_min)
    }

    fun bind(data: DayForecast) {
        forecastDate.text =  dateTimeConverter(data.date)
        forecastSunrise.text = "Sunrise: " + timeConverter(data.sunrise)
        forecastSunset.text = "Sunset: " + timeConverter(data.sunset)
        forecastTemp.text = "Temp: " + data.temp.day.toString()
        forecastTempMax.text = "Max: " + data.temp.max.toString()
        forecastTempMin.text = "Min: " + data.temp.min.toString()
    }

    fun dateTimeConverter(dateTimeStamp: Long): String {
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp, 0, ZoneOffset.of("-5"))
        return formatter.format(dateTime)
    }

    fun timeConverter(timeTimeStamp: Long): String{
        val timeFormatter = DateTimeFormatter.ofPattern("h:mm")
        val dateTime = LocalDateTime.ofEpochSecond(timeTimeStamp, 0, ZoneOffset.of("-5"))
        return timeFormatter.format(dateTime)
    }


}