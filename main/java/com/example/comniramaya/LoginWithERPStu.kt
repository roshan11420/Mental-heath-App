package com.example.comniramaya





import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.comniramaya.ui.theme.Black
import com.example.comniramaya.ui.theme.Peach
import com.google.firebase.database.FirebaseDatabase

class LoginWithERPStu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LoginWithERPStu(navController)

        }
    }
}

@Composable
fun LoginWithERPStu(navController: NavHostController) {
    val context = LocalContext.current
    var ERP by remember { mutableStateOf("") }
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
            Text(
                text = "Login",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Username
            OutlinedTextField(
                value = ERP,
                onValueChange = { ERP = it },
                label = { Text("ERP") },
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
                            val userERP = user.child("email").getValue(String::class.java)
                            val userPassword = user.child("password").getValue(String::class.java)

                            if (ERP == userERP && password == userPassword){
                                userFound = true
                                val intent = Intent(context, MainActivity::class.java)
                                // 🔹 You can also pass extra data if needed
                                // intent.putExtra("from", "RegisterScreen")
                                context.startActivity(intent)
                                break
                            }

                            if (!userFound){
                                errorMessage = "Invalid ERP && password "
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
                    val intent = Intent(context, LoginPage::class.java)
                    // 🔹 You can also pass extra data if needed
                    // intent.putExtra("from", "RegisterScreen")
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor =Peach),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login with College email", color = Black, fontSize = 25.sp)
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

