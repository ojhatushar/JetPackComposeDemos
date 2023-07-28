package com.example.jetpackcomposedemos.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextComponent(text: String,modifier: Modifier = Modifier) {
    /*Text(
        text = buildAnnotatedString {
            append("Game")
            withStyle(SpanStyle(MaterialTheme.colorScheme.primary)) {
                append("Res")
            }
        },
        fontFamily = FontFamily.SansSerif,
        style = style,
        modifier = modifier,
    )*/

    Text(
        modifier = modifier.padding(5.dp, 0.dp),
        text = text,
        color = Color.Cyan,
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            letterSpacing = 2.sp,
            fontStyle = FontStyle.Italic,
          /*  background = Color.Gray,*/
            /*shadow = Shadow(
                color = Color.Magenta,
                offset = Offset(5f, 5f),
                blurRadius = 5f
            )*/
        ),
    )
}

