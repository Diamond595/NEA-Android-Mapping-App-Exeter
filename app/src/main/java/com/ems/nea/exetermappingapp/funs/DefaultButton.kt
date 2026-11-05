package com.ems.nea.exetermappingapp.funs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ems.nea.exetermappingapp.settings.MainSettings


// A useful button design that I developed to make settings buttons in particular look better
/**
 * A simple, customisable button that keeps a consistent look throughout the program when used.
 *
 * @param click Called when the button is clicked. If the value is `null`, then it disables the clicking
 *
 * @param icon The icon that is displayed on the side of the button to the left of the button. A `null` value disables this
 *
 * @param iconContentDescription The content description of the icon which is mandatory for all icons
 *
 * @param title The title of the button
 *
 * @param content A special feature of the button, used to give custom content. A `null` value disables this
 *
 * @param description The description of the button that is displayed below the title
 *
 * @param titleSize The size that the title should be drawn as
 *
 * @param descriptionSize The size the description should be drawn as
 */
@Composable
fun DefaultSimpleButton (
    click: (() -> Unit)?,
    icon: ImageVector?,
    iconContentDescription: String?,
    title: String,
    content: @Composable (() -> Unit)?,
    description: String?,
    titleSize: Float = 20f,
    descriptionSize: Float = 12f,
    buttonColour: Color = MaterialTheme.colorScheme.primaryContainer
    ){
    // If there is no click functionality, the clickable modifier is omitted
    val modifier = if (click == null) {
        Modifier
    } else {
        Modifier
            .clip(
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(
            onClick =
                click
        )
    }

    // Splits the button into the icon and the rest of the button
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(
                color = buttonColour,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(all = 8.dp),
    ) {
        if (icon != null) {

            // Draws and icon specified by the variable
            Icon(
                imageVector = icon,
                contentDescription = iconContentDescription,
                modifier = Modifier
                    .padding(8.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }

        // Splits the button into the title, description and the content
        Column(
            // Aligns everything to the top of the button
            verticalArrangement = Arrangement.Top
        ) {
            // Displays the title in big font
            Text(
                text = title,
                fontSize = titleSize.sp
            )

            // Display the description
            if (description != null) {
                Text(
                    text = description,
                    fontSize = descriptionSize.sp
                )
            }
            // Display the custom content
            content?.invoke()
        }
    }
}