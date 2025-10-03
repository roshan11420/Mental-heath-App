package com.example.comniramaya

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Discover(){

    val videolist = listOf(
        DiscoverData(R.drawable.stress, "How to Reduce Stress"),
        DiscoverData(R.drawable.mindset, "Make an effective mind set"),
        DiscoverData(R.drawable.beactive, "Make your more  active "),
        DiscoverData(R.drawable.study, " Focused on your aim"),
        DiscoverData(R.drawable.stress, "How to Reduce Stress"),
        DiscoverData(R.drawable.mindset, "Make an effective mind set"),
        DiscoverData(R.drawable.beactive, "Make your more  active "),
        DiscoverData(R.drawable.study, " Focused on your aim"),
        DiscoverData(R.drawable.stress, "How to Reduce Stress"),
        DiscoverData(R.drawable.mindset, "Make an effective mind set"),
        DiscoverData(R.drawable.beactive, "Make your more  active "),
        DiscoverData(R.drawable.study, " Focused on your aim"),
        DiscoverData(R.drawable.stress, "How to Reduce Stress"),
        DiscoverData(R.drawable.mindset, "Make an effective mind set"),
        DiscoverData(R.drawable.beactive, "Make your more  active "),
        DiscoverData(R.drawable.study, " Focused on your aim"),
        DiscoverData(R.drawable.stress, "How to Reduce Stress"),
        DiscoverData(R.drawable.mindset, "Make an effective mind set"),
        DiscoverData(R.drawable.beactive, "Make your more  active "),
        DiscoverData(R.drawable.study, " Focused on your aim"),
        DiscoverData(R.drawable.stress, "How to Reduce Stress"),
        DiscoverData(R.drawable.mindset, "Make an effective mind set"),
        DiscoverData(R.drawable.beactive, "Make your more  active "),
        DiscoverData(R.drawable.study, " Focused on your aim"),
        DiscoverData(R.drawable.stress, "How to Reduce Stress"),
        DiscoverData(R.drawable.mindset, "Make an effective mind set"),
        DiscoverData(R.drawable.beactive, "Make your more  active "),
        DiscoverData(R.drawable.study, " Focused on your aim"),
        DiscoverData(R.drawable.stress, "How to Reduce Stress"),
        DiscoverData(R.drawable.mindset, "Make an effective mind set"),
        DiscoverData(R.drawable.beactive, "Make your more  active "),
        DiscoverData(R.drawable.study, " Focused on your aim"),

    )

    LazyColumn(modifier = Modifier.fillMaxHeight().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp))
    {
        items(videolist){
                video -> DiscoiverDataUi(discoverData = video)
        }
    }

}