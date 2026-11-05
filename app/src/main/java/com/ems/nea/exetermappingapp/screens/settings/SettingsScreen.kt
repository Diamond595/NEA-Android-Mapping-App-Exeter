package com.ems.nea.exetermappingapp.screens.settings

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ems.nea.exetermappingapp.settings.MainSettings
import com.ems.nea.exetermappingapp.settings.MainSettingsViewModel
import com.ems.nea.exetermappingapp.settings.MapSettings
import com.ems.nea.exetermappingapp.settings.MapSettingsViewModel

// Display the settings screen
@Composable
fun SettingsScreen(
    mainSettings: MainSettings,
    mapSettings: MapSettings,
    mainSettingsViewModel: MainSettingsViewModel = viewModel(factory = MainSettingsViewModel.Factory),
    mapSettingsViewModel: MapSettingsViewModel = viewModel(factory = MapSettingsViewModel.Factory),
){
    // Creates a scrollable column with each setting block
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .statusBarsPadding()
    ) {
        item {
            // Lists all the main settings in one block
            MainSettingsSection(
                mainSettings = mainSettings,
                mainSettingsViewModel = mainSettingsViewModel
            )

            // Creates a spacer between the main settings and the map settings to separate them
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth()
            )

            // Lists all the map settings in one block
            MapSettingsSection(
                mapSettings = mapSettings,
                mainSettings = mainSettings,
                mapSettingsViewModel = mapSettingsViewModel
            )
        }
    }
}