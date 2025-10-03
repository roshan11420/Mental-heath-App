package com.example.comniramaya

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comniramaya.ui.theme.Peach

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Treatment() {
    var expanded by remember { mutableStateOf(false) }
    var selectedName by remember { mutableStateOf("") }
    var sentRequests by remember { mutableStateOf(listOf<String>()) }

    // Example friend suggestions
    val friendSuggestions = listOf("Roshan ", "Aashutosh", "Kaif", "Rahul", "Tanisha","Ankit")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Send meeting Request to your mentor") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Peach)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(text = "Choose your Mentor's name:", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedName,
                    onValueChange = { }, // we don’t allow typing
                    label = { Text("Mentor  Name") },
                    readOnly = true,
                    modifier = Modifier
                        .menuAnchor() // important for dropdown
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    friendSuggestions.forEach { name ->
                        DropdownMenuItem(
                            text = { Text(name) },
                            onClick = {
                                selectedName = name
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (selectedName.isNotBlank()) {
                        sentRequests = sentRequests + selectedName
                        selectedName = ""
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Peach
                )
            ) {
                Text("Send Request")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Sent Requests:", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))

            sentRequests.forEach { request ->
                Text(text = "• $request :  Meeting time will send ", fontSize = 16.sp)
            }
        }
    }
}

