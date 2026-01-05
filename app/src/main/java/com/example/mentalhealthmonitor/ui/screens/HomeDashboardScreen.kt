package com.example.mentalhealthmonitor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeDashboardScreen(
    onBreathingClick: () -> Unit
) {

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF1A2980),
            Color(0xFF26D0CE)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Good Evening 🌙",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Let’s check how you’re feeling today",
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.9f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        DashboardCard(
            title = "Mental State",
            value = "Calm 😊",
            subtitle = "Stable compared to yesterday"
        )

        Spacer(modifier = Modifier.height(16.dp))

        DashboardCard(
            title = "Sleep Quality",
            value = "6.8 hrs 😴",
            subtitle = "Slightly below your average"
        )

        Spacer(modifier = Modifier.height(16.dp))

        DashboardCard(
            title = "Stress Level",
            value = "Moderate ⚠️",
            subtitle = "Detected restlessness today"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBreathingClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text(
                text = "Start Breathing Exercise 🫁",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A2980)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Why this matters",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Your stress is higher today mainly due to reduced sleep and increased movement.",
            fontSize = 13.sp,
            color = Color.White.copy(alpha = 0.9f)
        )
    }
}

@Composable
private fun DashboardCard(
    title: String,
    value: String,
    subtitle: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.15f)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(title, color = Color.White.copy(alpha = 0.9f), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(value, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
        }
    }
}
