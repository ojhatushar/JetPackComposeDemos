package com.example.jetpackcomposedemos.unit2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemos.R
import com.example.jetpackcomposedemos.unit2.ui.theme.JetpackComposeDemosTheme
import java.text.NumberFormat

class TipTime : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {

    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)

    Column(
        modifier = Modifier.padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.calculate_tip),
            fontSize = 14.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start)
        )

        EditNumberField(
            value = amountInput,
            onValueChange = {
                amountInput = it
            },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        //Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Composable
fun EditNumberField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text = stringResource(id = R.string.bill_amount)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showSystemUi = true, device = "id:pixel_3a")
@Composable
fun GreetingPreview8() {
    JetpackComposeDemosTheme {
        TipTimeLayout()
    }
}

