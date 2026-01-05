package com.example.mentalhealthmonitor.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun BreathingScreen() {

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF1A2980),
            Color(0xFF26D0CE)
        )
    )

    var isBreathing by remember { mutableStateOf(false) }
    var phaseText by remember { mutableStateOf("Tap start to breathe") }

    val transition = rememberInfiniteTransition(label = "breath")
    val circleSize by transition.animateFloat(
        initialValue = 160f,
        targetValue = if (isBreathing) 260f else 160f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        ),
        label = "circle"
    )

    LaunchedEffect(isBreathing) {
        while (isBreathing) {
            phaseText = "Breathe In 🌬️"
            delay(3000)

            phaseText = "Hold ⏸️"
            delay(2000)

            phaseText = "Breathe Out 😮‍💨"
            delay(4000)
        }
        phaseText = "Tap start to breathe"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Calm Breathing",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = phaseText,
            fontSize = 18.sp,
            color = Color.White.copy(alpha = 0.95f)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier
                .size(circleSize.dp)
                .background(
                    color = Color.White.copy(alpha = 0.3f),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "🫁",
                fontSize = 40.sp
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { isBreathing = !isBreathing },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text(
                text = if (isBreathing) "Stop" else "Start Breathing",
                color = Color(0xFF1A2980),
                fontWeight = FontWeight.Bold
            )
        }
    }
}
