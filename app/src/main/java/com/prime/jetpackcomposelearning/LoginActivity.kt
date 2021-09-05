package com.prime.jetpackcomposelearning

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prime.jetpackcomposelearning.ui.theme.JetpackComposeLearningTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
    fun LoginFieldsAndButton(
        scaffoldState: ScaffoldState,
        scope: CoroutineScope,
    ){
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
                onClick = {
                    if (username.isNotEmpty() && password.isNotEmpty())
                        scope.launch {
                            scaffoldState.snackbarHostState
                                .showSnackbar("$username $password",)
                        }
                    else
                        scope.launch {
                            scaffoldState.snackbarHostState
                                .showSnackbar("Please fill details")
                        }
//                    checkAuthentication(username, password)
                          },
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
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            val scrollScope = rememberScrollState()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollScope)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 50.dp, start = 20.dp, end = 20.dp)

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
                        LoginFieldsAndButton(
                            scaffoldState,
                            scope
                        )
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
}


