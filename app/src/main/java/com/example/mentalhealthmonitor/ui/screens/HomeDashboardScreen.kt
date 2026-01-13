package com.example.mentalhealthmonitor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

// Reusable data class for dashboard cards
data class DashboardCardData(val title: String, val description: String)

@Composable
fun HomeDashboardScreen(
    onBreathingClick: () -> Unit
) {

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF1A2980), Color(0xFF26D0CE))
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(horizontal = 20.dp),
        contentPadding = PaddingValues(vertical = 24.dp)
    ) {

        // Header Section
        item {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Good Evening 🌙",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Here’s a gentle overview of your mind today",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.85f)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Dashboard Cards
        val cards = listOf(
            DashboardCardData("Stress Level", "Low — You are emotionally balanced today 💙"),
            DashboardCardData("Sleep Quality", "Moderate — Try resting a bit earlier tonight"),
            DashboardCardData("Body Activity", "Calm — Minimal restlessness detected")
        )

        items(cards) { card ->
            DashboardCard(title = card.title, description = card.description)
        }

        // Breathing Button
        item {
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { onBreathingClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Start Breathing Exercise",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A2980)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

/* ---------- REUSABLE CARD ---------- */
@Composable
private fun DashboardCard(
    title: String,
    description: String
) {
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
                fontWeight = FontWeight.Bold,
                color = Color.Black
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
