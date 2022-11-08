package com.example.myfirstapplication.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapplication.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    onForecastButtonClick: () -> Unit,
) {
//    Scaffold(
//        topBar = { Appbar(title = stringResource(id = R.string.app_name))},
//
//    ) {
//        CurrentConditionsContent {
//        }
//    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                navigationIcon = {
                },

            )
        }, content = {

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
                            text = stringResource(id = R.string.current_temp),
                            style = TextStyle(
                                fontSize = 72.sp,
                                fontWeight = FontWeight(400)
                            )
                        )
                        Text(
                            stringResource(id = R.string.feels_like_temp, 80),
                            style = TextStyle(
                                fontSize = 14.sp
                            )
                        )
                    }
                    Spacer(modifier = Modifier.weight(1.0f, true))
                    Image(
                        modifier = Modifier
                            .size(72.dp),
                        painter = painterResource(id = R.drawable.sun_icon),
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
                    Text(stringResource(id = R.string.low_temp, 60), style = textStyle)
                    Text(stringResource(id = R.string.high_temp, 90), style = textStyle)
                    Text(stringResource(id = R.string.humidity, 50), style = textStyle)
                    Text(stringResource(id = R.string.pressure, 80), style = textStyle)
                }

                Spacer(modifier = Modifier.height(72.dp))
                Button(onClick = onForecastButtonClick) {
                    Text(text = stringResource(id = R.string.forecast))
                }

            }
        })
}

//@Composable
//private fun CurrentConditionsContent(
//    onForecastButtonClick: () -> Unit,
//){
//
//}
@Preview("CurrendConditions",
        device = Devices.PIXEL_4,
        showBackground = true,
)
@Composable
fun CurrentConditionsScreenPreview() {
    CurrentConditions {}
}