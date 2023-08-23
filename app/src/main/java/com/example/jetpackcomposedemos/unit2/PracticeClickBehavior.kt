package com.example.jetpackcomposedemos.unit2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemos.R
import com.example.jetpackcomposedemos.unit2.ui.theme.JetpackComposeDemosTheme

class PracticeClickBehavior : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeCreateDemo()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeCreateDemo() {

    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "Lemonade", fontWeight = FontWeight.Bold) },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    }) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {

                1 -> {
                    LemonadeWithImageClick(
                        textResId = R.string.tv_lemonade1,
                        drawableResId = R.drawable.lemon_tree,
                        contentDescId = R.string.tv_lemonade5,
                        onImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        })
                }

                2 -> {
                    LemonadeWithImageClick(
                        textResId = R.string.tv_lemonade2,
                        drawableResId = R.drawable.lemon_squeeze,
                        contentDescId = R.string.tv_lemonade6,
                        onImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        })
                }

                3 -> {
                    LemonadeWithImageClick(
                        textResId = R.string.tv_lemonade3,
                        drawableResId = R.drawable.lemon_drink,
                        contentDescId = R.string.tv_lemonade7,
                        onImageClick = {
                            currentStep = 4
                        })
                }

                4 -> {
                    LemonadeWithImageClick(
                        textResId = R.string.tv_lemonade4,
                        drawableResId = R.drawable.lemon_restart,
                        contentDescId = R.string.tv_lemonade7,
                        onImageClick = {
                            currentStep = 1
                        })
                }
            }
        }

    }


}

@Composable
fun LemonadeWithImageClick(
    textResId: Int,
    drawableResId: Int,
    contentDescId: Int,
    modifier: Modifier = Modifier,
    onImageClick: () -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = drawableResId),
            contentDescription = stringResource(id = contentDescId),
            modifier = Modifier
                .clickable(
                    onClick = onImageClick
                )
                .background(color = Color.Green, shape = CutCornerShape(4.dp))
                .padding(10.dp)
                .border(width = 2.dp, color = Color.Green, shape = CutCornerShape(4.dp))


        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = textResId), fontSize = 18.sp)
    }

}


@Preview(showSystemUi = true, device = "id:pixel_3a")
@Composable
fun GreetingPreview7() {
    JetpackComposeDemosTheme {
        LemonadeCreateDemo()
    }
}