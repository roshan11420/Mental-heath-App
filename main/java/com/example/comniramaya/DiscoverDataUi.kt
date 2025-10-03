package com.example.comniramaya

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.comniramaya.ui.theme.Peach




@Composable
fun DiscoiverDataUi(
    discoverData: DiscoverData,
  //  onVideoClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 16.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = {
            //onVideoClick("wr4N-SdekqY") // send video ID to parent
        }
    ) {
        Column(Modifier.background(Peach)) {
            Image(
                painter = painterResource(id = discoverData.thumbnail),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {
                Text(text = discoverData.title, fontSize = 25.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
    }
}
