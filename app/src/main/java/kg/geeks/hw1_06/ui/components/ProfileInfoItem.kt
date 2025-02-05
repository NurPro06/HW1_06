package kg.geeks.hw1_06.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

@Composable
fun ProfileInfoItem(label: String, value: String, onClick: () -> Unit) {
    Column(
        modifier = WatchEvent.Modifier
            .fillMaxSize()
            .clickable { onClick() }
            .padding(vertical = 8.dp),
    ) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
        Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}