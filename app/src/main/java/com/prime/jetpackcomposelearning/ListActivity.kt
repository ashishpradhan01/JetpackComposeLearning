package com.prime.jetpackcomposelearning

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LazyColumn{
//                items(count = 100){
//                    Text(
//                        text = "item $it",
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black,
//                        fontSize = 18.sp,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 10.dp),
//                        textAlign = TextAlign.Center
//                    )
//                }

                itemsIndexed(
                    arrayOf("James", "Robert", "John", "Michael",
                        "William", "David", "Richard", "Joseph", "Thomas", "Charles",
                        "James", "Robert", "John", "Michael","David",
                        "Richard", "Joseph", "Thomas", "Charles"),
                ){
                    index, item ->
                    Text(
                        text = "$index: $item",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}