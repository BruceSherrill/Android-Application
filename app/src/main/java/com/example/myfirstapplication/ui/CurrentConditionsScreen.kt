package com.example.myfirstapplication.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myfirstapplication.R
import com.example.myfirstapplication.models.CurrentConditions

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    viewModel: CurrentConditionsViewModel = hiltViewModel(),
    onForecastButtonClick: () -> Unit,
) {
    val state by viewModel.currentConditions.collectAsState(null)

    LaunchedEffect(Unit){
        viewModel.fetchData()
    }

    Scaffold(
        topBar = { Appbar(title = stringResource(id = R.string.app_name)) },
    ) {
        state?.let {
            CurrentConditionsContent(it) {
                onForecastButtonClick()
            }
        }
    }

}

@Composable
private fun CurrentConditionsContent(
    currentConditions: CurrentConditions,
    onForecastButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(id = R.string.city_name),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(400)
            )
        )
        Spacer(modifier = Modifier.height(14.dp))
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(
                        id = R.string.temperature,
                        currentConditions.conditions.temperature.toInt()
                    ),
                    style = TextStyle(
                        fontSize = 72.sp,
                        fontWeight = FontWeight(400)
                    )
                )
                Text(
                    stringResource(id = R.string.feels_like_temp, currentConditions.conditions.feelsLike.toInt()),
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1.0f, true))
            AsyncImage(
                model = String.format("https://openweathermap.org/img/wn/%s@2x.png", currentConditions.weatherData.firstOrNull()?.iconName),
                modifier = Modifier.size(72.dp),
                contentDescription = "Sunny",
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            val textStyle = TextStyle(
                fontSize = 16.sp
            )
            Text(stringResource(id = R.string.low_temp, currentConditions.conditions.minTemperature.toInt()), style = textStyle)
            Text(stringResource(id = R.string.high_temp, currentConditions.conditions.maxTemperature.toInt()), style = textStyle)
            Text(stringResource(id = R.string.humidity, currentConditions.conditions.humidity.toInt()), style = textStyle)
            Text(stringResource(id = R.string.pressure, currentConditions.conditions.pressure.toInt()), style = textStyle)
        }

        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onForecastButtonClick) {
            Text(text = stringResource(id = R.string.forecast))
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun CurrentConditionsPreview() {
    CurrentConditions {}
}