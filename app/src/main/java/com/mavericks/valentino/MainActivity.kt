package com.mavericks.valentino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mavericks.valentino.ui.theme.ValentinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValentinoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ValentineScren()
                }
            }
        }
    }
}


@Composable
fun ValentineScren() {
    val info = listOf(
        Pair("Michelle", "Coroutines"),
        Pair("Josphat", "Firebase"),
        Pair("Joel", "Room"),
        Pair("Denis", "Compose"),
        Pair("Sammy", "Compose"),
        Pair("Victor", "Compose"),
    )

    var devInfo by remember {
        mutableStateOf(info.random())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "\uD83C\uDF39", fontSize = 100.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Android Crush", fontSize = 28.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "I am: ${devInfo.first}", fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "I love: ${devInfo.second}", fontSize = 16.sp
            )
        }

        Button(
            onClick = {
                      devInfo = info.random()
            },
            shape = MaterialTheme.shapes.large.copy(
                CornerSize(32.dp)
            )
        ) {
            Text(
                text = "Get Next"
            )
        }

    }
}

@Preview
@Composable
fun ValentineScreenPrev() {
    ValentineScren()
}