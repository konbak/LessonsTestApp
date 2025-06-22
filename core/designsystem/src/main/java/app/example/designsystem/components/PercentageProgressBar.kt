package app.example.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PercentageProgressBar(
    progress: Int,
    modifier: Modifier = Modifier,
    barHeight: Dp = 20.dp
) {
    val clampedProgress = progress.coerceIn(0, 100)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        LinearProgressIndicator(
            progress = { clampedProgress / 100f },
            modifier = Modifier
                .weight(1f)
                .height(height = barHeight)
                .clip(RoundedCornerShape(50)),
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "$clampedProgress%",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PercentageProgressBarPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PercentageProgressBar(progress = 25)
        PercentageProgressBar(progress = 50)
        PercentageProgressBar(progress = 75)
        PercentageProgressBar(progress = 100)
    }
}