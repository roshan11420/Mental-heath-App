package com.example.comniramaya

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comniramaya.ui.theme.ComNiramayaTheme
import com.example.comniramaya.ui.theme.Peach

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Niramaya()
            var backPressedTime by remember { mutableStateOf(0L) }
            val context = LocalContext.current

            BackHandler {
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    finish() // close app
                } else {
                    Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
                }
                backPressedTime = System.currentTimeMillis()
            }
            }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Niramaya() {
    val context = LocalContext.current.applicationContext
    val navigationController = rememberNavController()
    val selected = remember { mutableStateOf(Icons.Default.Home) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Niramaya") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Peach
                )
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Peach) {

                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screen.Home.screen) { popUpTo(0) }
                }, modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Dashbord",
                        modifier = Modifier.size(25.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )

                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Star
                    navigationController.navigate(Screen.Discover.screen) { popUpTo(0) }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(R.drawable.discover_2),
                        contentDescription = "Activity Tracker",

                        modifier = Modifier.size(25.dp),
                        tint = if (selected.value == Icons.Default.Star) Color.White else Color.DarkGray,

                    )
                }



                IconButton(onClick = {
                    selected.value = Icons.Default.Favorite
                    navigationController.navigate(Screen.Treatment.screen) { popUpTo(0) }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(R.drawable.treatment),
                        contentDescription = "Portfolio",
                        modifier = Modifier.size(25.dp),
                        tint = if (selected.value == Icons.Default.Favorite) Color.White else Color.DarkGray
                    )
                }
                IconButton(onClick = {
                    selected.value = Icons.Default.MailOutline
                    navigationController.navigate(Screen.Result.screen) { popUpTo(0) }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(R.drawable.result),
                        contentDescription = "Report",
                        modifier = Modifier.size(25.dp),
                        tint = if (selected.value == Icons.Default.MailOutline) Color.White else Color.DarkGray
                    )
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.AccountCircle
                        navigationController.navigate(Screen.Profile.screen) { popUpTo(0) }
                    },
                    modifier = Modifier.weight(1f).align(alignment = Alignment.CenterVertically),
                ) {

                    Icon(
                        imageVector = Icons.Default.AccountCircle,

                        contentDescription = "Profile",
                        modifier = Modifier.size(25.dp),
                        tint = if (selected.value == Icons.Default.AccountCircle) Color.White else Color.DarkGray,
                    )

                }

            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screen.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.screen) { Home() }
            composable(Screen.Discover.screen) { Discover() }
            composable(Screen.Result.screen) { Result() }
            composable(Screen.Treatment.screen) { Treatment() }
            composable(Screen.Profile.screen) { Profile() }



        }
    }
}






