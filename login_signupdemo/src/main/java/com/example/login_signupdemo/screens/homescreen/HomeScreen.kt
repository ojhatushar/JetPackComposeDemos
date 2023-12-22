package com.example.login_signupdemo.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.login_signupdemo.components.TextComponent
import com.example.login_signupdemo.ui.theme.JetpackComposeDemosTheme

@Composable
fun HomeScreen(email: String) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextComponent(
            text = email,
            fontSize = 25.sp,
            color = Color(0xFF347243),
            fontWeight = FontWeight.Medium,
        )
    }
}

//@Preview(showBackground = true)
@Preview(showSystemUi = true, device = "id:pixel_3a")
@Composable
fun PreviewLogin() {
    JetpackComposeDemosTheme {
        HomeScreen(email = "dasdas")
    }
}