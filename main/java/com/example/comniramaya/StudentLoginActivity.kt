package com.example.comniramaya

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.rememberNavController
import com.example.comniramaya.ui.theme.Black
import com.example.comniramaya.ui.theme.Peach
import com.google.firebase.database.FirebaseDatabase

import kotlin.collections.forEach
import kotlin.jvm.java
import kotlin.let

class StudentLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            StudentLoginScreen(navController)
        }
    }
}

@Composable
fun StudentLoginScreen(navController: NavHostController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(" Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Student Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(" ERP  ") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value =confirmPassword ,
            onValueChange = { confirmPassword = it },
            label = { Text("confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))



        Button(
            onClick = {

                if (email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                    if (password!=confirmPassword){
                        Toast.makeText(context,"rewrite the password and confirm it ", Toast.LENGTH_SHORT).show()
                    }else{
                        val database = FirebaseDatabase.getInstance().reference.child("Student")
                        val  userId =  database.push().key?:""

                        val userData = mapOf(
                            "email" to email,
                            "username" to username,
                            "password" to password,
                            "confirmPass" to confirmPassword
                        )

                        database.child(userId).setValue(userData).addOnSuccessListener {
                            val intent = Intent(context, LoginPage::class.java)
                            // 🔹 You can also pass extra data if needed
                            // intent.putExtra("from", "RegisterScreen")
                            context.startActivity(intent)
                        }
                    }
                }else{
                    errorMessage = " fill the all require feilds"
                }


            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Peach
            )
        ) {
            Text("SignUp", color = Black, fontSize = 25.sp)
        }

        errorMessage?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(it, color = Color.Red, fontSize = 14.sp)
        }
    }

}


