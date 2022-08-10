package com.example.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composecalculator.ui.CalculatorViewModel
import com.example.composecalculator.ui.theme.CYellow
import com.example.composecalculator.ui.theme.ComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Calculator(viewModel = viewModel())
                }
            }
        }
    }
}

@Composable
fun Calculator(viewModel: CalculatorViewModel) {

    Column(modifier = Modifier.fillMaxHeight()) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        // input
        Text(
            text = viewModel.inputState.value,
            fontSize = 38.sp,
            color = Color.Gray,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            lineHeight = 38.sp
        )

        // Result

        Text(
            text = viewModel.resultState.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            fontSize = 70.sp,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.height(20.dp))
        Spacer(
            modifier = Modifier
                .height(0.5.dp)
                .fillMaxWidth()
                .background(CYellow)
        )
        //Del \
        Row(
            modifier = Modifier.height(76.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {

            BoxText(modifier = Modifier.weight(3f), "DEL", Color.Black)


            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )


            BoxText(modifier = Modifier.weight(1f), "÷")
        }

        Spacer(
            modifier = Modifier
                .height(0.5.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )
        // 7 8 9 *
        Row(modifier = Modifier.height(76.dp), horizontalArrangement = Arrangement.Center) {

            BoxText(modifier = Modifier.weight(1f), "7")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "8")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "9")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "*")
        }
        Spacer(
            modifier = Modifier
                .height(0.5.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )
        Row(modifier = Modifier.height(76.dp), horizontalArrangement = Arrangement.Center) {
            BoxText(modifier = Modifier.weight(1f), "4")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "5")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "6")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "-")
        }
        Spacer(
            modifier = Modifier
                .height(0.5.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )
        Row(modifier = Modifier.height(76.dp), horizontalArrangement = Arrangement.Center) {

            BoxText(modifier = Modifier.weight(1f), "1")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "2")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "4")
            Spacer(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            BoxText(modifier = Modifier.weight(1f), "+")

        }
        Spacer(
            modifier = Modifier
                .height(0.5.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )
        Row(modifier = Modifier.height(76.dp), horizontalArrangement = Arrangement.Center) {
            BoxText(modifier = Modifier.weight(2f), "0")

            BoxText(
                modifier = Modifier
                    .weight(3f)
                    .background(CYellow), "=", Color.Black
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeCalculatorTheme {
        Calculator(viewModel())
    }
}


@Composable
fun BoxText(
    modifier: Modifier,
    text: String,
    color: Color = Color.Gray,
    viewModel: CalculatorViewModel = viewModel()
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clickable {
                viewModel.input(text)
            }, contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, textAlign = TextAlign.Center, fontSize = 29.sp, color = color
        )
    }
}