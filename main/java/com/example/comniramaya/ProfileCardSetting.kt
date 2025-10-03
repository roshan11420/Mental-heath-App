package com.example.comniramaya

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ProfileData(
    @DrawableRes val icon: Int,
    val title : String
)


@Composable
fun CreateSystem(){
    val title = listOf(

        ProfileData(R.drawable.person_24, "Account"),
        ProfileData(R.drawable.settings_24, "setting"),
        ProfileData(R.drawable.folder_24, "Data & Security"),
        ProfileData(R.drawable.help_24, "Legal & device info"),
        ProfileData(R.drawable.phone_24, "Mental health Helpline")

    )

    LazyColumn(modifier = Modifier.fillMaxHeight().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp))
    {

    }
}

