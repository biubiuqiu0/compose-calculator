package com.example.composecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composecalculator.ui.theme.CYellow
import com.example.composecalculator.ui.theme.ComposeCalculatorTheme


@Preview(showBackground = true, heightDp = 720, widthDp = 1080)
@Composable
fun DefaultPreview() {
    ComposeCalculatorTheme {
        HorizontalScreen(viewModel())
    }
}

@Composable
fun HorizontalScreen(viewModel: CalculatorViewModel = viewModel()) {
    val inputHeight = (LocalConfiguration.current.screenHeightDp / 5).dp

    val contentWidth = (LocalConfiguration.current.screenWidthDp * 0.4).dp
    Row(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.width(contentWidth)) {

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
                lineHeight = 70.sp,
                textAlign = TextAlign.End
            )
            
            Spacer(modifier = Modifier.height(30.dp))
        }
        Spacer(
            modifier = Modifier
                .width(0.5.dp)
                .fillMaxHeight()
                .background(CYellow)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {

            //Del \
            Row(
                modifier = Modifier.height(inputHeight),
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
            Row(
                modifier = Modifier.height(inputHeight), horizontalArrangement = Arrangement.Center
            ) {

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

            Row(
                modifier = Modifier.height(inputHeight), horizontalArrangement = Arrangement.Center
            ) {
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
            Row(
                modifier = Modifier.height(inputHeight), horizontalArrangement = Arrangement.Center
            ) {

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
                BoxText(modifier = Modifier.weight(1f), "3")
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
            Row(
                modifier = Modifier.height(inputHeight), horizontalArrangement = Arrangement.Center
            ) {
                BoxText(modifier = Modifier.weight(2f), "0")

                BoxText(
                    modifier = Modifier
                        .weight(3f)
                        .background(CYellow), "=", Color.Black
                )
            }
        }
    }

}