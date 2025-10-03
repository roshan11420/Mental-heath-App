package com.example.comniramaya

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comniramaya.ui.theme.Peach
import kotlinx.coroutines.delay
import kotlin.jvm.java

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen {
                // Navigate to MainActivity after splash
                startActivity(Intent(this, LoginPage::class.java))
                finish()
            }
        }
    }
}


@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds delay
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)), // Background color
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

           Image(
               painter = painterResource(R.drawable.niramaya2),
               contentDescription = null,
               modifier = Modifier.size(250.dp).clip(RoundedCornerShape(200.dp)),

           )


            // App Logo (replace with Image if you have one)
            Text(
                text = "Niramaya",
                fontSize = 46.sp,
                fontWeight = FontWeight.Bold,
                color = Peach
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Your mind , your space",
                fontSize = 18.sp,
                color = Peach
            )
        }
    }
}

