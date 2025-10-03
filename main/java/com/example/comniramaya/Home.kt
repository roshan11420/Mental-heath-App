package com.example.comniramaya

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// ---------------- Chat Message Model ----------------
data class ChatMessage(val text: String, val isUser: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch { sheetState.show() } // Opens bottom sheet
                },
                containerColor = Color(0xFF0D47A1),
                shape = RoundedCornerShape(50)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mew),
                    contentDescription = "AI Assistant",
                    modifier = Modifier.size(75.dp)
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Dashboard",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    color = Color(0xFF0D47A1)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Row for Attendance, Credits, Achievements
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatCard("Attendance", "85%", Icons.Default.CheckCircle)
                StatCard("Credits", "24", Icons.Default.AccountBox)
                StatCard("Achievements", "5", Icons.Default.Star)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatCard("Extra Activity", "2", Icons.Default.CheckCircle)
                StatCard("Certification ", "7", Icons.Default.MailOutline)
                StatCard("College Programs", "4", Icons.Default.AccountBox)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Upcoming events
            Text(
                text = "Upcoming",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            EventCard("Workshop on AI in Healthcare", "Oct 15")
            EventCard("Workshop on Cyber Security", "Oct 19")
            EventCard("UI Development Contest", "Oct 22")
            EventCard("Web Dev Workshop", "Oct 25")
            EventCard("Programming Contest", "Nov 11")
        }

        // ---------------- ChatBot Modal Bottom Sheet ----------------
        if (sheetState.isVisible) {
            ModalBottomSheet(
                onDismissRequest = {
                    scope.launch { sheetState.hide() }
                },
                sheetState = sheetState,
                containerColor = Color.White
            ) {
                ChatBotUI()
            }
        }
    }
}

// ---------------- StatCard ----------------
@Composable
fun StatCard(title: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(icon, contentDescription = title, tint = Color(0xFF0D47A1))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = title, fontSize = 14.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Medium)
            Text(text = value, fontSize = 16.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        }
    }
}

// ---------------- EventCard ----------------
@Composable
fun EventCard(title: String, date: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, fontSize = 15.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Medium)
            Text(text = date, fontSize = 13.sp, color = Color.Gray)
        }
    }
}

// ---------------- ChatBot UI ----------------
@Composable
fun ChatBotUI() {
    var message by remember { mutableStateOf("") }
    var chatHistory by remember {
        mutableStateOf(
            listOf(ChatMessage("👋 Hello! I’m Niramaya Assistant. How can I help you today?", false))
        )
    }

    Column(
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = "AI Assistant",
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(chatHistory) { msg ->
                ChatBubble(msg)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Type a message...") }
            )
            IconButton(
                onClick = {
                    if (message.isNotBlank()) {
                        chatHistory = chatHistory + ChatMessage(message, true)
                        chatHistory = chatHistory + ChatMessage(
                            "🤖 Hello sir How  can i assist you",
                            false
                        )
                        message = ""
                    }
                }
            ) {
                Icon(Icons.Default.Send, contentDescription = "Send")
            }
        }
    }
}

// ---------------- ChatBubble ----------------
@Composable
fun ChatBubble(msg: ChatMessage) {
    val bubbleColor = if (msg.isUser) Color(0xFF0D47A1) else Color(0xFFE0E0E0)
    val textColor = if (msg.isUser) Color.White else Color.Black
    val alignment = if (msg.isUser) Alignment.CenterEnd else Alignment.CenterStart

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = alignment
    ) {
        Box(
            modifier = Modifier
                .background(bubbleColor, shape = MaterialTheme.shapes.medium)
                .padding(12.dp)
                .widthIn(max = 260.dp)
        ) {
            Text(msg.text, color = textColor, fontSize = 14.sp)
        }
    }
}
