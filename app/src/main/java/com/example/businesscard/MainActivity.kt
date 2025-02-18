package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF073042)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Верхняя часть с логотипом и именем
        Column(
            modifier = Modifier
                .weight(1f) // Заполняет доступное пространство
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = "Android Logo",
                modifier = Modifier
                    .height(120.dp)
                    .width(150.dp)
            )
            Text(text = "Alexey Laptev", color = Color.White, fontSize = 32.sp)
            Text(text = "Android Developer", color = Color(0xFF3ddc84))
        }

        // Нижняя часть с контактными данными
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
            ContactRow(R.drawable.ic_phone, "+7 (981) 444 555 666")
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
            ContactRow(R.drawable.ic_share, "@kolapss")
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
            ContactRow(R.drawable.ic_email, "alex@android.com")
        }
    }
}

@Composable
fun ContactRow(iconRes: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)
    ) {
        val icon = painterResource(id = iconRes)
        Image(painter = icon, contentDescription = null, modifier = Modifier.padding(8.dp))
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}