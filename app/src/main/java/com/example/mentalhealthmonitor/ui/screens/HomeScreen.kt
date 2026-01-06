package com.example.mentalhealthmonitor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onBreathingClick: () -> Unit) {

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

        Text(
            text = "Good Evening 🌙",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Let’s check how your mind feels today",
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.8f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        CalmCard(
            title = "Stress Level",
            description = "You seem calm today 💙"
        )

        CalmCard(
            title = "Sleep Insight",
            description = "Your sleep was light but consistent"
        )

        CalmCard(
            title = "Activity",
            description = "Low movement detected — relaxed state"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBreathingClick,
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        )
        {
            Text(
                text = "Start Breathing Exercise",
                color = Color(0xFF1A2980),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun CalmCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.95f)
        )
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}
@Composable
fun HomeScreen(
    onBreathingClick: () -> Unit,
    onDashboardClick: () -> Unit,
    onInsightClick: () -> Unit,
    onProgressClick: () -> Unit,
    onTrustedPersonClick: () -> Unit,
    onEmergencyClick: () -> Unit
) {

    Column {

        Button(onClick = onBreathingClick) {
            Text("Breathing / Calm")
        }

        Button(onClick = onDashboardClick) {
            Text("Dashboard")
        }

        Button(onClick = onInsightClick) {
            Text("Insights")
        }

        Button(onClick = onProgressClick) {
            Text("Progress")
        }

        Button(onClick = onTrustedPersonClick) {
            Text("Trusted Person")
        }

        Button(onClick = onEmergencyClick) {
            Text("Emergency Preview")
        }
    }
}
