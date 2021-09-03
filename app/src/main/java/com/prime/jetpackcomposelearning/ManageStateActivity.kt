package com.prime.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class ManageStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val color = remember {
                mutableStateOf(Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                ))
            }
            Column(modifier = Modifier.fillMaxSize()){
                ColorChangingBox(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ){
                    color.value = it
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .background(color.value)
                ){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "!! I will change my color !!",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.SansSerif
                            ),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ColorChangingBox(
    modifier : Modifier = Modifier,
    updateColor: (color:Color)->Unit
){
    val color  = remember {
        mutableStateOf(Color.Black)
    }
    Box(
        modifier = modifier
            .background(
                color = color.value
            )
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    ){
       Column(
           modifier = Modifier.fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           Text(
               text = "!! Click Me !!",
               style = TextStyle(
                   color = Color.White,
                   fontSize = 28.sp,
                   fontWeight = FontWeight.Bold,
                   textAlign = TextAlign.Center,
                   fontFamily = FontFamily.SansSerif
               ),
           )
       }
    }

}