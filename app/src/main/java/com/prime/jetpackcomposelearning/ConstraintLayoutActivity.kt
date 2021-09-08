package com.prime.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet


class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val constraints = ConstraintSet {
                val blueBox = createRefFor("blueBox")
                val redBox = createRefFor("redBox")
                val greenBox = createRefFor("greenBox")

                constrain(blueBox) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }

                constrain(redBox) {
                    top.linkTo(blueBox.top)
                    bottom.linkTo(blueBox.bottom)
                    start.linkTo(blueBox.end)
                }

                constrain(greenBox) {
                    top.linkTo(blueBox.bottom)
                    start.linkTo(blueBox.start)
                    end.linkTo(redBox.end)

                }
            }

            ConstraintLayout(
                constraintSet = constraints,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .background(Color.Blue)
                        .layoutId("blueBox")
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Red)
                        .layoutId("redBox")
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color.Green)
                        .layoutId("greenBox")
                )
            }
        }
    }
}
