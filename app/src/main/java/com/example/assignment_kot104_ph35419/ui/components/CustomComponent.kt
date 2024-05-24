import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTopBar(
    title: String,
    subtitle: String?,
    leftIconId: Int?,
    rightIconId: Int?,
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit,
    function: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (leftIconId != null) {
            IconButton(onClick = onLeftClick) {
                Icon(
                    painter = painterResource(id = leftIconId),
                    contentDescription = "Left Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        } else {
            Spacer(modifier = Modifier.size(24.dp)) // Space for the missing icon
        }

        Spacer(modifier = Modifier.weight(1f))

        Column {
            Text(
                text = title,
                fontSize = if (!subtitle.isNullOrEmpty()) 18.sp else 22.sp,
                fontWeight = FontWeight.Bold,
                color =if (!subtitle.isNullOrEmpty()) Color.Gray else Color.Black,
                textAlign = TextAlign.Center,
            )
            if (!subtitle.isNullOrEmpty()) {
                Text(
                    text = subtitle ?: "",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        if (rightIconId != null) {
            IconButton(onClick = onRightClick) {
                Icon(
                    painter = painterResource(id = rightIconId),
                    contentDescription = "Right Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        } else {
            Spacer(modifier = Modifier.size(24.dp)) // Space for the missing icon
        }
    }
}


