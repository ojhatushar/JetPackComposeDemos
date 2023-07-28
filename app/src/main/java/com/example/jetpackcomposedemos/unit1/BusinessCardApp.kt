package com.example.jetpackcomposedemos.unit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemos.R
import com.example.jetpackcomposedemos.ui.theme.JetpackComposeDemosTheme

class BusinessCardApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardDemo()
                }
            }
        }
    }
}

@Composable
fun BusinessCardDemo() {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x658BDA92)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .background(color = colorResource(R.color.teal_700))
        )
        Text(
            text = "Jennifer Doe",
            fontSize = 30.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Android Developer",
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(

                /* modifier = Modifier
                     .fillMaxWidth()
                     .offset(x = (12).dp),
                 horizontalArrangement = Arrangement.spacedBy(
                     12.dp,
                     alignment = Alignment.CenterHorizontally
                 )*/
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null,
                    tint = Color(0xFF3ddc84),
                )

                Spacer(modifier = Modifier.width(10.dp))


                Text(
                    text = "+91 7894561232",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center

                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                /*modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = (3).dp),
                horizontalArrangement = Arrangement.spacedBy(
                    15.dp,
                    alignment = Alignment.CenterHorizontally
                )*/
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = Color(0xFF3ddc84)

                )

                Spacer(modifier = Modifier.width(20.dp))


                Text(
                    text = "@AndroidDev",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                /*modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = (30).dp),
                horizontalArrangement = Arrangement.spacedBy(
                    15.dp,
                    alignment = Alignment.CenterHorizontally
                )*/
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = Color(0xFF3ddc84)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "jon.doe@android.com",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                )
            }

        }
    }
}

@Preview(showSystemUi = true, device = "id:pixel_3a")
@Composable
fun GreetingPreview5() {
    JetpackComposeDemosTheme {
        BusinessCardDemo()
    }
}