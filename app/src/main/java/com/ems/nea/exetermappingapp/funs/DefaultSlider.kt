package com.ems.nea.exetermappingapp.funs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// A slider that can be called to keep the look of the app the same and to increase readability
/**
 * A slider that has a plus sign on one side, a minus on the other and can have a reset button.
 * Should be used for when you need a uniform slider look.
 *
 * @param value The current value of the slider
 *
 * @param onValueChange What is returned when the slider is moved
 *
 * @param modifier Modifier to be applied to the slider
 *
 * @param minusOnLeft Whether the minus sign should be on the left or right of the slider
 *
 * @param resetButton Whether a reset button should be displayed
 *
 * @param resetValue The value to set the slider to reset it
 *
 * @param valueRange The range of values the slider can be
 *
 * @param textModifier The modifier for the plus and minus on the sides of the slider
 *
 * @param sliderModifier The modifier for the actual interactable slider
 *
 * @param steps The steps the slider should go up in
 *
 * @param colours The colours for the slider
 */
@Composable
fun DefaultSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    minusOnLeft: Boolean = true,
    resetButton: Boolean = false,
    resetValue: Float = 0f,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    textModifier: Modifier = Modifier,
    sliderModifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    steps: Int = 0,
    colours: SliderColors = SliderDefaults.colors(),
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .weight(8f)
        ) {
            // Text to display the + or - sign, based on the minusOnLeft parameter
            Text(
                text = if (minusOnLeft) {
                    "-"
                } else {
                    "+"
                },
                modifier = textModifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(4.dp),
                fontSize = 24.sp
            )
            // The slider, the main part
            Slider(
                value = value,
                onValueChange = onValueChange,
                valueRange = valueRange,
                modifier = sliderModifier
                    .align(alignment = Alignment.CenterVertically),
                colors = colours,
                steps = steps
            )
            // Text to display the + or - sign, based on the minusOnLeft parameter
            Text(
                text = if (minusOnLeft) {
                    "+"
                } else {
                    "-"
                },
                modifier = textModifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(4.dp),
                fontSize = 24.sp
            )
        }
        // displays the reset button if requested
        if (resetButton){
            Icon(
                imageVector = Icons.Filled.Replay,
                contentDescription = "Reset Text Size",
                modifier = iconModifier
                    .weight(2f)
                    .size(24.dp)
                    .clip(
                        shape = MaterialTheme.shapes.small,
                    )
                    .clickable(
                        onClick = {
                            onValueChange(resetValue)
                        }
                    )
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}