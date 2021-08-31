package com.prime.jetpackcomposelearning

import android.content.res.Configuration

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prime.jetpackcomposelearning.ui.theme.JetpackComposeLearningTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }

    fun showToast(text:String){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}

@Composable
fun Greeting() {
    JetpackComposeLearningTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "JetPack Compose Learning") },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Drawer")
                        }
                    },
                    actions = {
                        IconButton(onClick = {  }) {
                            Icon(Icons.Filled.Settings, contentDescription = "Settings")
                        }
                        IconButton(onClick = {  }) {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Filled.Add, contentDescription = "Floating Button")
                }
            }
        ) {
            Column(Modifier.fillMaxHeight()) {
                Image(
                    painter = painterResource(id = R.drawable.happy_meal),
                    contentDescription = "MC Happy Meal"
                )
                Column(
                    modifier = Modifier.padding(all=16.dp)
                ) {
                    Text(
                        text = "MC Happy Meal",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    Text(
                        text = "Price: 10.00 $",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 10.sp
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    ShowSwitch()
                }
            }
        }
    }
}

@Composable
fun ShowSwitch(){
    val isChecked = remember{
        mutableStateOf(true)
    }
    Switch(
        checked = isChecked.value,
        onCheckedChange = { value : Boolean ->
            isChecked.value = value
        },
        modifier = Modifier.run {
            size(16.dp)
            padding(10.dp)
        }
    )
}

@Preview(showBackground = true, name = "Light Mode")
//@Preview(showBackground = true, name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    JetpackComposeLearningTheme {
        Greeting()
    }
}