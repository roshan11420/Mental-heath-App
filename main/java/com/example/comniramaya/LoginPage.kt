package com.example.comniramaya

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.comniramaya.ui.theme.Black
import com.example.comniramaya.ui.theme.Peach
import com.google.firebase.database.FirebaseDatabase

import kotlin.jvm.java
import kotlin.let

class LoginPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LoginScreen()

        }
    }
}

@Composable
fun LoginScreen( ) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Text(text = "WellCome to Niramaya !!", fontSize = 35.sp, modifier = Modifier.padding(top = 150.dp, start = 35.dp, end = 35.dp))

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.niramaya2),
                contentDescription = null,
                modifier = Modifier.size(200.dp).clip(RoundedCornerShape(200.dp)),

                )

            Text(
                text = "Login",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Username
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Login Button
            Button(
                onClick = {

                    val database = FirebaseDatabase.getInstance().reference.child("Student")
                    database.get().addOnSuccessListener { data ->
                        var userFound = false
                        for (user in data.children){
                            val userEmail = user.child("email").getValue(String::class.java)
                            val userPassword = user.child("password").getValue(String::class.java)

                            if (email == userEmail && password == userPassword){
                                userFound = true
                                val intent = Intent(context, MainActivity::class.java)
                                // 🔹 You can also pass extra data if needed
                                // intent.putExtra("from", "RegisterScreen")
                                context.startActivity(intent)
                                break
                            }

                            if (!userFound){
                                errorMessage = "Invalid Email && password "
                            }

                        }
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Peach
                )
            ) {
                Text("Login", color = Black, fontSize = 25.sp)
            }

            errorMessage?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(it, color = Color.Red, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))



            Spacer(modifier = Modifier.height(10.dp))

            // College ERP Login Button
            Button(
                onClick = {
                    val intent = Intent(context, LoginWithERPStu::class.java)
                    // 🔹 You can also pass extra data if needed
                    // intent.putExtra("from", "RegisterScreen")
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor =Peach),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login with College ERP", color = Black, fontSize = 25.sp)
            }

            val context = LocalContext.current

            Button(
                onClick = {
                    val intent = Intent(context, StudentLoginActivity::class.java)
                    // 🔹 You can also pass extra data if needed
                    // intent.putExtra("from", "RegisterScreen")
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Peach),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Create New Account", color = Black, fontSize = 25.sp)
            }
        }
    }
}

//private fun ERROR.putExtra(string: String, string2: String) {}

