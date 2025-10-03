package com.example.comniramaya

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comniramaya.ui.theme.OffWhite
import com.example.comniramaya.ui.theme.Peach


@Composable
fun SurveyItem(option: SurveyOption, isSelected: Boolean, onSelect: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Peach, RoundedCornerShape(16.dp)) // dark card background
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = option.icon),
            contentDescription = null,
            tint = Peach,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = option.title,
            color = Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )

        Checkbox(
            checked = isSelected,
            onCheckedChange = { onSelect() },
            colors = CheckboxDefaults.colors(
                checkedColor = Green, // purple
                uncheckedColor = OffWhite
            )
        )
    }
}