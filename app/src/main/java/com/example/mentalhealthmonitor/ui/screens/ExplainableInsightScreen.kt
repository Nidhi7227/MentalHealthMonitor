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
fun ExplainableInsightScreen() {

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F2027),
            Color(0xFF203A43),
            Color(0xFF2C5364)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(20.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Understanding Your Stress",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Today feels heavier than usual. Let’s understand why.",
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.85f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        InsightCard(
            title = "Primary Cause",
            value = "Low Sleep Quality",
            description = "Your sleep duration dropped below your normal pattern for the past 3 days."
        )

        Spacer(modifier = Modifier.height(16.dp))

        InsightCard(
            title = "Secondary Factor",
            value = "High Restlessness",
            description = "Frequent movements during night indicate difficulty reaching deep sleep."
        )

        Spacer(modifier = Modifier.height(16.dp))

        InsightCard(
            title = "Behavior Pattern",
            value = "Irregular Routine",
            description = "Sleep and wake times changed significantly compared to last week."
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.15f)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {

                Text(
                    text = "What this means",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Your body hasn’t had enough time to recover. This often increases stress sensitivity and emotional fatigue.",
                    fontSize = 13.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Suggestion",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFA5F3FC)
                )

                Text(
                    text = "Try sleeping 30–45 minutes earlier tonight. A short breathing exercise can also help calm your nervous system.",
                    fontSize = 13.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }
    }
}

/* ---------- REUSABLE CARD ---------- */

@Composable
private fun InsightCard(
    title: String,
    value: String,
    description: String
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.12f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = title,
                fontSize = 13.sp,
                color = Color.White.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = description,
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.85f)
            )
        }
    }
}
