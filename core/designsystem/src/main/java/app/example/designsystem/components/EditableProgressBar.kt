package app.example.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EditableProgressBar(
    progress: Int,
    onProgressChanged: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var sliderPosition by remember { mutableFloatStateOf(progress.toFloat()) }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        PercentageProgressBar(progress = sliderPosition.toInt())

        Slider(
            value = sliderPosition,
            onValueChange = { newValue ->
                sliderPosition = newValue
                onProgressChanged(newValue.toInt())
            },
            valueRange = 0f..100f,
            steps = 100,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Progress: ${sliderPosition.toInt()}%",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EditableProgressBarPreview() {
    var progress by remember { mutableIntStateOf(40) }

    EditableProgressBar(
        progress = progress,
        onProgressChanged = { newProgress ->
            progress = newProgress
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}