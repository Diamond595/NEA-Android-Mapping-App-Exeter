package com.ems.nea.exetermappingapp.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// The screen that shows an error as the screen changed to a non-existent screen
@Composable
fun ErrorScreen(
    screenName: String
){
    // Fills the whole screen with an error background
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.error
            )
    ) {
        // Sends a log message to Logcat that shows the error
        Log.e(TAG, "ERROR: $screenName is not a screen.")
        // Notifies the user of the error message
        Text(
            text = "ERROR: $screenName is not a screen.",
            color = MaterialTheme.colorScheme.onError,
            fontSize = 48.sp,
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(8.dp)
        )
    }
}