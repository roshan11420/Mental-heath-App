package com.example.comniramaya

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comniramaya.ui.theme.Peach

@Composable
fun Profile(){

        Text(text = "Profile", fontSize = 35.sp, modifier = Modifier.padding(bottom = 25.dp))
        val context = LocalContext.current
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 45.dp, start = 25.dp, end = 25.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        )
        {
            Image(
                imageVector = Icons.Default.AccountCircle, // replace with your image
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(170.dp) // size of the image
                    .clip(CircleShape) // make it circular
                    .align(Alignment.CenterHorizontally)
            )


            // User Name
            Text(
                text = "User Name",  // dynamic later
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(12.dp))




            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 1.dp)
                    .clickable { },
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(containerColor = Peach),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.Black, // Orange tint
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Account",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Go",
                        tint = Color.Gray
                    )
                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 1.dp)
                    .clickable { },
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(containerColor =Peach),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null,
                            tint = Color.Black, // Orange tint
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Setting",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Go",
                        tint = Color.Gray
                    )
                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 1.dp)
                    .clickable { },
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(containerColor = Peach),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.MailOutline,
                            contentDescription = null,
                            tint = Color.Black, // Orange tint
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Data & privacy",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Go",
                        tint = Color.Gray
                    )
                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 1.dp)
                    .clickable { },
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(containerColor = Peach),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = null,
                            tint = Color.Black, // Orange tint
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Legal & device info ",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Go",
                        tint = Color.Gray
                    )
                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 1.dp)
                    .clickable { },
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(containerColor = Peach),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = null,
                            tint = Color.Black, // Orange tint
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Mental health HelpLine",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Go",
                        tint = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 25.dp))
            Text("Support", fontSize = 25.sp)


            Button(onClick = {}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                containerColor = Peach,
                contentColor = Color.Black
            )) {
                Text("Report issue",fontSize = 25.sp)
            }

            Button(onClick = {},modifier = Modifier.fillMaxWidth(),colors = ButtonDefaults.buttonColors(
                containerColor = Peach,
                contentColor = Color.Black)
                ) {
                Text("Recommend to friends",fontSize = 25.sp)
            }

            Button(onClick = {
                val intent = Intent(context , LoginPage::class.java)
                context.startActivity(intent)
                if (context is ComponentActivity) {
                    context.finish()   // ✅ closes current screen
                }

            },modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Peach,
                    contentColor = Color.Black)) {
                Text("logout",fontSize = 25.sp)
            }


        }



}






