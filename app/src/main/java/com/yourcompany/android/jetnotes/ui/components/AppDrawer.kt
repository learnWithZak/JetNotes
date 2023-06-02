package com.yourcompany.android.jetnotes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourcompany.android.jetnotes.theme.JetNotesTheme

class AppDrawer {

    @Composable
    fun AppDrawerHeader() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Drawer header icon",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                modifier = Modifier.padding(16.dp)
            )
            Text(text = "JetNotes", modifier = Modifier.align(Alignment.CenterVertically))
        }
    }

    @Preview
    @Composable
    fun AppDrawerHeaderPreview() {
        JetNotesTheme {
            AppDrawerHeader()
        }
    }

    @Composable
    fun ScreenNavigationButton(
        icon: ImageVector,
        label: String,
        isSelected: Boolean,
        onClick: () -> Unit
    ) {
        val colors = MaterialTheme.colors
        val imageAlpha = if (isSelected) 1f else 0.6f
        val textColor = if (isSelected) colors.primary else colors.onSurface.copy(alpha = 0.6f)
        val backgroundColor = if (isSelected) colors.primary.copy(alpha = 0.12f) else colors.surface

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 8.dp),
            color = backgroundColor,
            shape = MaterialTheme.shapes.small
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .clickable(onClick = onClick)
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Image(
                    imageVector = icon,
                    contentDescription = "Screen Navigation Button",
                    colorFilter = ColorFilter.tint(textColor),
                    alpha = imageAlpha
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = label,
                    style = MaterialTheme.typography.body2,
                    color = textColor,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    @Preview
    @Composable
    fun ScreenNavigationButtonPreview() {
        JetNotesTheme {
            ScreenNavigationButton(icon = Icons.Filled.Home, label = "Notes", isSelected = true) {

            }
        }
    }
}