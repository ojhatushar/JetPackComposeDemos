package com.example.login_signupdemo.screens.signinsignup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_signupdemo.R
import com.example.login_signupdemo.components.ImageComponent
import com.example.login_signupdemo.components.TextComponent
import com.example.login_signupdemo.components.TextFieldComponent
import com.example.login_signupdemo.ui.theme.JetpackComposeDemosTheme

@Composable
fun SignUpScreen(onBackButtonClicked: () -> Unit, onLoginTextClicked: () -> Unit) {

    Column {
        TopUi(onBackButtonClicked)
        SignUpField()
        OtherSignUpOptions(onLoginTextClicked)

    }
}


@Composable
private fun TopUi(onBackButtonClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {

        ImageComponent(
            /* modifier = Modifier
                     .width(dimensionResource(id = R.dimen.image_size_width)),*/
            image = R.drawable.ic_left_arrow,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 30.dp, y = (-45).dp)
                .clickable(onClick = onBackButtonClicked)

        )

        TextComponent(
            text = "Register",
            fontSize = 40.sp,
            color = Color(0xFF347243),
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 40.dp)

        )

        ImageComponent(
            image = R.drawable.login_signup_image_latest,
            /*   contentScale = ContentScale.FillBounds,*/
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.image_size_width))
                //  .height(dimensionResource(id = R.dimen.image_size_height))
                //  .aspectRatio(2f)
                .align(Alignment.TopEnd)
                .offset(x = 40.dp, y = 20.dp)
                .padding(top = 40.dp)
                .rotate(310f)


        )
        TextComponent(
            text = "Create your new account",
            fontSize = 18.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(x = 10.dp, y = (-20).dp)

        )
    }
}

@Composable
private fun SignUpField() {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    TextFieldComponent(
        label = R.string.tv_full_name,
        leadingIcon = R.drawable.ic_name,
        value = fullName,
        onValueChange = {
            fullName = it
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        onKeyboardDone = {

        },
    )

    TextFieldComponent(
        label = R.string.tv_email,
        leadingIcon = R.drawable.ic_email,
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_tick),
                contentDescription = null,
                tint = Color(0xFF699f4C)
            )
        },
        value = email,
        onValueChange = {
            email = it
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        onKeyboardDone = {

        },
    )

    TextFieldComponent(
        label = R.string.tv_password,
        leadingIcon = R.drawable.ic_password,
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = null,
                    )
                }
            } else {
                IconButton(onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = null,
                    )
                }
            }
        },
        value = password,
        onValueChange = {
            password = it
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        onKeyboardDone = {},
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
    )

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF347243),
            contentColor = Color.White
        ), contentPadding = PaddingValues(12.dp)
    ) {
        Text(
            text = "Register",
            fontSize = 16.sp
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextComponent(
            text = "Remember Me",
            fontSize = 12.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.fillMaxWidth(0.1f))
        TextComponent(
            text = "Forgot Password ?",
            fontSize = 12.sp,
            color = Color(0xFF347243),
            fontWeight = FontWeight.Medium,
        )
    }

    Spacer(modifier = Modifier.fillMaxHeight(0.1f))
}

@Composable
private fun OtherSignUpOptions(onLoginTextClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .weight(0.5f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                thickness = 2.dp,
                color = Color.LightGray, modifier = Modifier
                    .weight(1f)
                    .align(alignment = Alignment.CenterVertically)

            )
            TextComponent(
                text = "Or Continue with",
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
            )
            Divider(
                thickness = 2.dp,
                color = Color.LightGray, modifier = Modifier
                    .weight(1f)
                    .align(alignment = Alignment.CenterVertically)

            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
        ) {

            ImageComponent(
                /* modifier = Modifier
                         .width(dimensionResource(id = R.dimen.image_size_width)),*/
                image = R.drawable.ic_fb,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(10.dp)
                    .shadow(elevation = 5.dp, shape = CircleShape)
                    .background(Color.White)
                    .padding(18.dp)


            )
            ImageComponent(
                image = R.drawable.ic_google,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(10.dp)
                    .shadow(elevation = 5.dp, shape = CircleShape)
                    .background(Color.White)
                    .padding(18.dp)
            )
            ImageComponent(
                image = R.drawable.ic_apple,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(10.dp)
                    .shadow(elevation = 5.dp, shape = CircleShape)
                    .background(Color.White)
                    .padding(18.dp)
            )
        }


        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            TextComponent(
                text = "Already have an account ?",
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextComponent(
                text = "Login",
                fontSize = 16.sp,
                color = Color(0xFF347243),
                fontWeight = FontWeight.Bold,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable(onClick = onLoginTextClicked)
            )
        }
    }
}

@Preview(showSystemUi = true, device = "id:pixel_3a")
@Composable
fun PreviewSignUp() {
    JetpackComposeDemosTheme {
        SignUpScreen(onBackButtonClicked = {},
            onLoginTextClicked = {})
    }
}