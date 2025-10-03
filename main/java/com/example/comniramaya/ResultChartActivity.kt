package com.example.comniramaya



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.comniramaya.ui.theme.ComNiramayaTheme
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import android.graphics.Color as AndroidColor



class ResultChartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComNiramayaTheme {
                ResultChartScreen()
            }
        }
    }
}


@Composable
fun ResultChartScreen() {
    // Example data for chart
    val entries = listOf(
        PieEntry(40f, "Math"),
        PieEntry(30f, "Science"),
        PieEntry(20f, "English"),
        PieEntry(10f, "Others")
    )

    val dataSet = PieDataSet(entries, "Overall Result").apply {
        colors = listOf(
            AndroidColor.RED,
            AndroidColor.BLUE,
            AndroidColor.GREEN,
            AndroidColor.MAGENTA
        )
        valueTextSize = 16f
        sliceSpace = 2f
    }

    val pieData = PieData(dataSet)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AndroidView(
            factory = { context ->
                PieChart(context).apply {
                    this.data = pieData
                    this.description.isEnabled = false
                    this.isRotationEnabled = true
                    this.setUsePercentValues(true)
                    this.animateY(1000)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )
    }
}

