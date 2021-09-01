package com.prime.jetpackcomposelearning

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prime.jetpackcomposelearning.ui.theme.JetpackComposeLearningTheme

class LoginActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginScreen()
        }
    }

    private fun checkAuthentication(username:String, password:String){
        if (username.isNotEmpty()&&password.isNotEmpty()){
            if(username == password)
                Toast.makeText(this, "Logged in", Toast.LENGTH_LONG).show()
            else Toast.makeText(this, "Not Authenticated", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Please fill all details", Toast.LENGTH_LONG).show()
        }
    }

    @Composable
    fun LoginFields(){
        var username:String by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        var passwordVisibility:Boolean by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                label = {
                    Text(text = "Username")
                },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "User icon")
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text(text = "Password")
                },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Password icon")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Password Visibility")
                    }
                },
                visualTransformation = if(passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()

            )
            Spacer(
                modifier = Modifier.padding(top = 40.dp)
            )
            Button(
                onClick = { checkAuthentication(username, password) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
            }

        }
    }

    @Composable
    fun LoginScreen(){
        JetpackComposeLearningTheme {
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    Column(
                        modifier = Modifier.padding(top = 50.dp, start = 20.dp, end = 20.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column{
                                Text(text = "Already", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                                Text(text = "have an", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                                Text(text = "Account?", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                            }
                            Image(
                                painter = painterResource(id = R.drawable.login_image),
                                contentDescription = "Login Image",
                                modifier = Modifier.height(180.dp)
                            )
                        }
                        LoginFields()
                    }
                    Column(
                        verticalArrangement = Arrangement.Bottom
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.background),
                            contentDescription = "background",
                            modifier = Modifier.fillMaxSize(),
                            alignment = Alignment.BottomEnd
                        )
                    }
                }
            }
        }
    }

    @Preview(name = "Light Mode", showBackground = true)
    @Composable
    fun Preview(){
        LoginScreen()
    }
}


