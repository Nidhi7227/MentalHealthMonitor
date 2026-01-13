package com.example.mentalhealthmonitor.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun BandStatus(isConnected: Boolean) {
    val infiniteTransition = rememberInfiniteTransition(label = "bandScan")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Filled.Bluetooth,
            contentDescription = "Band Status",
            tint = if (isConnected) Color.Green else Color.Gray,
            modifier = Modifier
                .size(28.dp)
                .rotate(if (isConnected) 0f else rotation)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = if (isConnected) "Band Connected" else "Searching band...",
            color = Color.White
        )
    }
}
