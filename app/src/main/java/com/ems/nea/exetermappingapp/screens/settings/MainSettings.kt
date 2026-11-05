package com.ems.nea.exetermappingapp.screens.settings

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ems.nea.exetermappingapp.settings.MainSettings
import com.ems.nea.exetermappingapp.settings.MainSettingsViewModel
import com.ems.nea.exetermappingapp.funs.ColourSelector
import com.ems.nea.exetermappingapp.funs.DefaultSimpleButton
import com.ems.nea.exetermappingapp.funs.DefaultSlider

@Composable
fun MainSettingsSection(
    mainSettings: MainSettings,
    mainSettingsViewModel: MainSettingsViewModel = viewModel(factory = MainSettingsViewModel.Factory)
) {
    Column(
        modifier = Modifier
            .background(
                color = androidx.compose.ui.graphics.Color(mainSettings.secondaryColour),
                shape = MaterialTheme.shapes.small
            )
    ) {
        Text(
            text = "Main Settings:",
            fontSize = (30 * mainSettings.textSizeMultiplier).sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(
                    color = androidx.compose.ui.graphics.Color(mainSettings.primaryColour),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(8.dp)
        )

        DefaultSimpleButton(
            click = { mainSettingsViewModel.toggleTheme(!mainSettings.darkTheme) },
            icon = if (mainSettings.darkTheme) {
                Icons.Filled.DarkMode
            } else {
                Icons.Filled.LightMode
            },
            iconContentDescription = "Toggle Theme",
            title = "Theme",
            content = null,
            description = "Change the theme of the app between light and dark mode.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.TextFields,
            iconContentDescription = "Change Text Size",
            title = "Text Size",
            content = @Composable {
                DefaultSlider(
                    value = mainSettings.textSizeMultiplier,
                    onValueChange = {
                        mainSettingsViewModel.setTextSizeMultiplier(it)
                    },
                    valueRange = 0.5f..2f,
                    resetButton = true,
                    resetValue = 1f,
                )
            },
            description = "Change the size of the text in the app.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.Image,
            iconContentDescription = "Change Icon Style",
            title = "Icon Style",
            content = @Composable {
                TestBottomBar(
                    iconStyle = mainSettings.iconStyle,
                    onIconStyleChange = {
                        mainSettingsViewModel.setIconStyle(it)
                    },
                    textSize = 12 * mainSettings.textSizeMultiplier
                )
            },
            description = "Change how the navigation bar is displayed.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Background Colour",
            title = "Background Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = MaterialTheme.colorScheme.background.toArgb(),
                        initialColourValue = mainSettings.backgroundColour,
                        onValueChange = {
                            mainSettingsViewModel.setBackgroundColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt()
                    )
                },
            description = "Change the colour of the background on the map.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Primary Colour",
            title = "Primary Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = MaterialTheme.colorScheme.primary.toArgb(),
                        initialColourValue = mainSettings.primaryColour,
                        onValueChange = {
                            mainSettingsViewModel.setPrimaryColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt(),
                        displayAlpha = false
                    )
                },
            description = "Change the colour of primary UI elements.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Secondary Colour",
            title = "Secondary Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = MaterialTheme.colorScheme.secondary.toArgb(),
                        initialColourValue = mainSettings.secondaryColour,
                        onValueChange = {
                            mainSettingsViewModel.setSecondaryColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt(),
                        displayAlpha = false
                    )
                },
            description = "Change the colour of secondary UI elements.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        Spacer(
            modifier = Modifier
                .height(4.dp)
        )
    }
}

@Composable
fun TestBottomBar(
    iconStyle: Int,
    onIconStyleChange: (Int) -> Unit,
    textSize: Float,
){
    NavigationBar() {
        NavigationBarItem(
            selected = iconStyle == 0,
            onClick = { onIconStyleChange(0) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Image,
                    contentDescription = "Icon Style"
                )
            },
            label = {
                Text(
                    text = "Label",
                    fontSize = textSize.sp
                )
            }
        )
        NavigationBarItem(
            selected = iconStyle == 1,
            onClick = { onIconStyleChange(1) },
            icon = {

            },
            label = {
                Text(
                    text = "Label",
                    fontSize = textSize.sp
                )
            }
        )
        NavigationBarItem(
            selected = iconStyle == 2,
            onClick = { onIconStyleChange(2) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Image,
                    contentDescription = "Icon Style"
                )
            }
        )
    }

}