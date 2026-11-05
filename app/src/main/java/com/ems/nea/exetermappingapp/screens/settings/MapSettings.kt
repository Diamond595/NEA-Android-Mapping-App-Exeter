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
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ems.nea.exetermappingapp.settings.MainSettings
import com.ems.nea.exetermappingapp.settings.MapSettings
import com.ems.nea.exetermappingapp.settings.MapSettingsViewModel
import com.ems.nea.exetermappingapp.funs.ColourSelector
import com.ems.nea.exetermappingapp.funs.DefaultSimpleButton
import com.ems.nea.exetermappingapp.funs.DefaultSlider

// Draws the settings for the map on the screen when called
@Composable
fun MapSettingsSection(
    mapSettings: MapSettings,
    mainSettings: MainSettings,
    mapSettingsViewModel: MapSettingsViewModel = viewModel(factory = MapSettingsViewModel.Factory)
){
    // Stacks the buttons on top of each other
    Column(
        modifier = Modifier
            .background(
                color = androidx.compose.ui.graphics.Color(mainSettings.secondaryColour),
                shape = MaterialTheme.shapes.small
            )
    ) {
        // The title text that announces what this settings section is
        Text(
            text = "Map Settings:",
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

        // The first button, changes the building view distance with a slider
        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.Business,
            iconContentDescription = "Change Building View Distance",
            title = "Building View Distance",
            content =
                @Composable {
                        DefaultSlider(
                            value = mapSettings.buildingViewDistance,
                            onValueChange = {
                                mapSettingsViewModel.setBuildingViewDistance(it)
                            },
                            valueRange = 0f..5f,
                            resetButton = true,
                            resetValue = 1f,
                        )
                },
            description = "Change at what zoom levels buildings stop rendering.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        // The next button which changes the road name view distance with a slider, same as previous button
        DefaultSimpleButton(
            click = null,
            icon = Icons.AutoMirrored.Filled.Label,
            iconContentDescription = "Change Road Name View Distance",
            title = "Road Name View Distance",
            content =
                @Composable {
                    DefaultSlider(
                        value = mapSettings.roadNameViewDistance,
                        onValueChange = {
                            mapSettingsViewModel.setRoadNameViewDistance(it)
                        },
                        valueRange = 0f..5f,
                        resetButton = true,
                        resetValue = 1f,
                    )
                },
            description = "Change at what zoom levels road names stop rendering.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        // The first colour selector that changes the main road colour
        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Main Road Colour",
            title = "Main Road Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = Color.argb(255, 255, 244, 79),
                        initialColourValue = mapSettings.mainRoadColour,
                        onValueChange = {
                            mapSettingsViewModel.setMainRoadColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt()
                    )
                },
            description = "Change the colour of the main roads on the map.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        // The next colour selector that changes the motorway colour
        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Motorway Colour",
            title = "Motorway Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = Color.argb(255, 0, 255, 0),
                        initialColourValue = mapSettings.motorwayRoadColour,
                        onValueChange = {
                            mapSettingsViewModel.setMotorwayColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt()
                    )
                },
            description = "Change the colour of the motorways on the map.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        // The next colour selector that changes the default road colour
        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Default Road Colour",
            title = "Default Road Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = Color.argb(255, 255, 255, 255),
                        initialColourValue = mapSettings.defaultRoadColour,
                        onValueChange = {
                            mapSettingsViewModel.setDefaultRoadColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt()
                    )
                },
            description = "Change the colour of the default roads on the map.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        // The next colour selector that changes the building colour
        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Building Colour",
            title = "Building Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = Color.argb(255, 127, 127, 127),
                        initialColourValue = mapSettings.buildingColour,
                        onValueChange = {
                            mapSettingsViewModel.setBuildingColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt()
                    )
                },
            description = "Change the colour of the buildings on the map.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        // The next colour selector that changes the park colour
        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Park Colour",
            title = "Park Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = Color.argb(255, 144, 238, 144),
                        initialColourValue = mapSettings.parkColour,
                        onValueChange = {
                            mapSettingsViewModel.setParkColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt()
                    )
                },
            description = "Change the colour of the parks on the map.",
            titleSize = 20 * mainSettings.textSizeMultiplier,
            descriptionSize = 12 * mainSettings.textSizeMultiplier,
            buttonColour = androidx.compose.ui.graphics.Color(mainSettings.primaryColour)
        )

        // The next colour selector that changes the water colour
        DefaultSimpleButton(
            click = null,
            icon = Icons.Filled.ColorLens,
            iconContentDescription = "Change Water Colour",
            title = "Water Colour",
            content =
                @Composable {
                    ColourSelector(
                        defaultColourValue = Color.argb(255, 118, 203, 255),
                        initialColourValue = mapSettings.waterColour,
                        onValueChange = {
                            mapSettingsViewModel.setWaterColour(it)
                        },
                        hexCodeFontSize = (24 * mainSettings.textSizeMultiplier).toInt()
                    )
                },
            description = "Change the colour of the water on the map.",
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