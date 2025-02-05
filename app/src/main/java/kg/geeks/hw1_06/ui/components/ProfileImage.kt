package kg.geeks.hw1_06.ui.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ProfileImage(image: Painter){
    Image(
        painter = image,
        contentDescription = "Фото профиля",
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
    )
}