package com.example.login_signupdemo.screens.splash

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_signupdemo.R
import com.example.login_signupdemo.components.ImageComponent
import com.example.login_signupdemo.components.TextComponent
import com.example.login_signupdemo.ui.theme.JetpackComposeDemosTheme

@Composable
fun SplashScreen(onSignInButtonClicked: () -> Unit, onRegisterTextClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        ImageComponent(
            image = R.drawable.splash_image,
            contentScale = ContentScale.FillBounds
        )

        TextComponent(
            text = "The best \n app for \n your plants",
            fontSize = 50.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 30.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
            lineHeight = 50.sp
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(150.dp))

            OutlinedButton(
                onClick = onSignInButtonClicked,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0x44FFFFFF)),
                shape = RoundedCornerShape(35),
                contentPadding = PaddingValues(10.dp)
            ) {

                TextComponent(
                    text = "Sign in",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            TextComponent(
                text = "Create an account",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable(onClick = onRegisterTextClicked)


            )
        }
    }
}


//@Preview(showBackground = true)
@Preview(showSystemUi = true, device = "id:pixel_3a")
@Composable
fun GreetingPreview() {
    JetpackComposeDemosTheme {
        SplashScreen(onSignInButtonClicked = {},
            onRegisterTextClicked = {})
    }
}