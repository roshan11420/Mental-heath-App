package com.example.comniramaya



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle

import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun Result() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: Add activity form */ },
                containerColor = Color(0xFF0D47A1)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Activity", tint = Color.White)
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
                text = "Activity Tracker",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0D47A1)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Example activities
            ActivityCard("Workshop on AI in Healthcare", "Conference", "Approved")
            ActivityCard("Programming Contest", "Competition", "Pending")
            ActivityCard("Community Volunteering", "Service", "Rejected")
        }
    }
}

@Composable
fun ActivityCard(title: String, type: String, status: String) {
    val (statusColor, statusIcon) = when (status) {
        "Approved" -> Color(0xFF2E7D32) to Icons.Default.CheckCircle
        "Pending" -> Color(0xFFF9A825) to Icons.Default.Build
        "Rejected" -> Color(0xFFC62828) to Icons.Default.Warning
        else -> Color.Gray to Icons.Default.Build
    }

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
            Column {
                Text(text = title, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                Text(text = type, fontSize = 13.sp, color = Color.Gray)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(statusIcon, contentDescription = status, tint = statusColor)
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = status, fontSize = 13.sp, color = statusColor)
            }
        }
    }
}

