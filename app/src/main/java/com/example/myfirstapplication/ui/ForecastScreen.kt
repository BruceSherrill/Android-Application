package com.example.myfirstapplication.ui
//126:37 most recent video
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapplication.R
import com.example.myfirstapplication.models.DayForecast
import com.example.myfirstapplication.models.ForecastTemp
import com.example.myfirstapplication.toHourMinute
import com.example.myfirstapplication.toMonthDay
import org.intellij.lang.annotations.JdkConstants

//        DayForecast(1662068591L,1662068591L,1663442051L, ForecastTemp(51f, 0f, 70f),2.2f,76),
val startDay = 1662068591L
val sunrise = 1662068591L
val sunset = 1663442051L

val ForecastData = (0 until 16).map {
    DayForecast(
        date = startDay + (it * (24 * 60 * 60)),
        sunrise = sunrise + (it * 24 * 60 * 60),
        sunset = sunset + (it * 24 * 60 * 60),
        forecastTemp = ForecastTemp(min = 70f + it, max = 80f + it),
        pressure = 1024f,
        humidity = 76,
        )
}
@Composable
fun ForecastScreen(){
//    Scaffold(
//        topBar = { Appbar(title = stringResource(id = R.string.forecast))},
//    ) {
//        // Content goes here
//    }

    LazyColumn{
        items(items = ForecastData) { item: DayForecast ->
            ForecastRow(item = item)
        }
    }
}

@Composable
private fun ForecastRow(item: DayForecast){
    Row(
        modifier = Modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        ) {
        val textStyle = TextStyle(
            fontSize = 12.sp,
        )

        Image(painter = painterResource(id = R.drawable.sun_icon), contentDescription = "")
        Spacer(modifier = Modifier.weight(.5f, fill = true))
        Text(
            text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        
        Column() {
            Text(
                text = stringResource(id = R.string.high_temp, item.forecastTemp.max.toInt()),
                style = textStyle,
                )
            Text(
                text = stringResource(id = R.string.low_temp, item.forecastTemp.min.toInt()),
                style = textStyle,
            )
        }
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = stringResource(id = R.string.sunrise, item.sunrise.toHourMinute()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.sunset, item.sunset.toHourMinute()),
                style = textStyle,
            )

        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
private fun ForecastRowPreview() {
    ForecastRow(item = ForecastData[0])
}