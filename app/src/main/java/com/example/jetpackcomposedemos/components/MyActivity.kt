package com.example.jetpackcomposedemos.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemos.R

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //  WidgetRowDemo()
            // WidgetColumnDemo()
            WidgetBoxDemo()
        }
    }
}

@Composable
fun WidgetColumnDemo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        TextComponent("Hello Compose")
        TextComponent("Hello Compose")
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Magenta
            ), shape = CutCornerShape(10),
            border = BorderStroke(1.dp, Color.Red),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            )
        ) {
            TextComponent("Click Here")
        }
    }
}

@Composable
fun WidgetRowDemo() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)// Outer padding (margin)
            /* .rotate(45f)
              .alpha(0.9f)
              .scale(2f)
             .clip(shape = CutCornerShape(20.dp))*/
            .border(2.dp, Color.Red, shape = CircleShape)
            .background(color = Color.Blue, shape = CircleShape)
            .padding(10.dp) // Inner padding


    ) {
        TextComponent("Hello Compose")
        Spacer(modifier = Modifier.width(width = 50.dp))
        TextComponent("Hello Compose")

    }


}

@Composable
fun WidgetBoxDemo() {
    val image =painterResource(id = R.drawable.ic_launcher_background)
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color.Blue),
            modifier = Modifier
                .wrapContentHeight()
                .padding(0.dp, 20.dp)
                //.clip(CircleShape)
                .clip(RoundedCornerShape(10))
                .background(Color.Red)
                .border(1.dp, Color.Red, RoundedCornerShape(10))
        )
        TextComponent("Hello Compose")
    }

}

@Preview(showSystemUi = true, device = "id:pixel_3a")
@Composable
fun RowPreview() {
     WidgetRowDemo()
   // WidgetColumnDemo()
    // WidgetBoxDemo()
}

/*@Preview(showSystemUi = true, device = "id:pixel_3a")
@Composable
fun ColumnPreview() {
    WidgetColumnDemo()
}*/

