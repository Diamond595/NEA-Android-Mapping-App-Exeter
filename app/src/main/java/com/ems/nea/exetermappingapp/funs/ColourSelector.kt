package com.ems.nea.exetermappingapp.funs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red


// Used to select colours by using argb format. Displays the colour as a hex code and the colour on the alpha bar
/**
 * Displays a hex code for the current colour, and 4 or 3 sliders to change the argb colour.
 *
 * @param initialColourValue The current colour value of the slider
 *
 * @param onValueChange Called when the colour is changed
 *
 * @param modifier The modifier for the colour selector
 *
 * @param useResetButton If the reset button should be used
 *
 * @param defaultColourValue The default colour value to reset to if the reset button is used
 *
 * @param hexCodeModifier The modifier for the hex code text
 *
 * @param hexCodeColour The colour of the hex code text
 *
 * @param hexCodeFontSize The size of the hex code text
 *
 * @param displayAlpha If the alpha slider should be displayed
 */
@Composable
fun ColourSelector(
    initialColourValue: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    useResetButton: Boolean = true,
    defaultColourValue: Int = 0,
    hexCodeModifier: Modifier = Modifier,
    hexCodeColour: Color = Color.White,
    hexCodeFontSize: Int = 24,
    displayAlpha: Boolean = true,
    ) {
    // Set split the colour into the 4 segments for easier use
    var alpha = initialColourValue.alpha
    var red = initialColourValue.red
    var green = initialColourValue.green
    var blue = initialColourValue.blue

    // The modifier for the rows and text, to make the code look cleaner
    val rowModifier = Modifier
        .padding(8.dp)
    val textModifier = Modifier
        .padding(4.dp)

    // Splits the sliders to be on top of each other
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        // Spaces the items to be equal distance away from each other in the space provided
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Displays the hex code of the colour and a reset button
        Row(
            modifier = Modifier
                .align(
                    alignment = Alignment.CenterHorizontally,
                )
        ) {
            // The hex code is displayed in a big font
            Text(
                text = "#${initialColourValue.toHexString()}",
                modifier = hexCodeModifier,
                fontSize = hexCodeFontSize.sp,
                color = hexCodeColour
            )

            // The reset button, which uses the default value passed in to reset the colour
            if (useResetButton) {
                Icon(
                    imageVector = Icons.Filled.Replay,
                    contentDescription = "Reset Road View Distance Size",
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(24.dp)
                        .clip(
                            shape = MaterialTheme.shapes.small,
                        )
                        .clickable(
                            onClick = {
                                onValueChange(defaultColourValue)
                            }
                        )
                        .align(alignment = Alignment.CenterVertically)
                )
            }
        }
        // The first slider, the alpha slider
        if (displayAlpha) {
            Row(
                modifier = rowModifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // The actual slider
                Slider(
                    // The position along the slider is the alpha value
                    value = alpha.toFloat(),
                    // When the slider is moved, the colour is updated to include the new alpha value
                    onValueChange = {
                        alpha = it.toInt()
                        onValueChange(Color(red, green, blue, alpha).toArgb())
                    },
                    // The range of alpha values, ranging from 0 to 255, like normal
                    valueRange = 0f..255f,
                    // Change the colour of the slider to be the colour
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(red, green, blue, alpha),
                    )
                )
                // Displays A to show that it is the alpha slider
                Text(
                    text = "A",
                    modifier = textModifier
                )
            }
        }
        Row(
            modifier = rowModifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(
                value = red.toFloat(),
                onValueChange = {
                    red = it.toInt()
                    onValueChange(Color(red, green, blue, alpha).toArgb())
                },
                valueRange = 0f..255f,
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(red, 0, 0, 255),
                )
            )
            Text(
                text = "R",
                modifier = textModifier
            )
        }
        Row(
            modifier = rowModifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(
                value = green.toFloat(),
                onValueChange = {
                    green = it.toInt()
                    onValueChange(Color(red, green, blue, alpha).toArgb())
                },
                valueRange = 0f..255f,
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0, green, 0, 255),
                )
            )
            Text(
                text = "G",
                modifier = textModifier
            )
        }
        Row(
            modifier = rowModifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(
                value = blue.toFloat(),
                onValueChange = {
                    blue = it.toInt()
                    onValueChange(Color(red, green, blue, alpha).toArgb())
                },
                valueRange = 0f..255f,
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0, 0, blue, 255),
                )
            )
            Text(
                text = "B",
                modifier = textModifier
            )
        }
    }
}