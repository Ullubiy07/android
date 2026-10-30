package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyContent()
        }
    }
}

@Preview(device = "id:POCO F5")
@Composable
fun MyContent() {
    val text = remember {
        mutableStateOf("")
    }
    val edit = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text.value,
            modifier = Modifier.padding(bottom = 20.dp),
            fontSize = 25.sp,
            color = Color(0xFF6200EE)
        )
        TextField(
            value = edit.value,
            modifier = Modifier.fillMaxWidth(0.7f),
            onValueChange = { newValue -> edit.value = newValue },
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            ),
            placeholder = {
                Text(
                    "Enter your name",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
        Button(
            modifier = Modifier.padding(top = 20.dp),
            onClick = { text.value = "Hello ${edit.value}!" }
        ) {
            Text("Confirm")
        }
    }
    StudentInfo()
}

@Composable
fun StudentInfo() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Сайгитов Уллубий Русланович, БПИ 258",
            fontSize = 16.sp
        )
    }
}
