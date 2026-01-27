package com.example.mentalhealthmonitor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.mentalhealthmonitor.ml.StressPredictor

// Reusable data class for dashboard cards
data class DashboardCardData(val title: String, val description: String)

@Composable
fun HomeDashboardScreen(
    onBreathingClick: () -> Unit,
    context: android.content.Context
) {

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF1A2980), Color(0xFF26D0CE))
    )

    // ----- ML Inputs -----
    var sleep by remember { mutableStateOf("") }
    var heartRate by remember { mutableStateOf("") }
    var activity by remember { mutableStateOf("") }
    var stressResult by remember { mutableStateOf("Not predicted") }
    var stressColor by remember { mutableStateOf(Color.White) }

    val predictor = remember { StressPredictor(context) }

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

        // ----- Manual ML Input Fields -----
        item {
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = sleep,
                onValueChange = { sleep = it },
                label = { Text("Sleep Hours") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = heartRate,
                onValueChange = { heartRate = it },
                label = { Text("Heart Rate") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = activity,
                onValueChange = { activity = it },
                label = { Text("Activity Level (1–10)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (sleep.isNotEmpty() && heartRate.isNotEmpty() && activity.isNotEmpty()) {
                        try {
                            val result = predictor.predict(
                                sleep.toFloat(),
                                heartRate.toFloat(),
                                activity.toFloat()
                            )
                            stressResult = result
                            stressColor = when (result) {
                                "Low Stress" -> Color.Green
                                "Medium Stress" -> Color.Yellow
                                "High Stress" -> Color.Red
                                else -> Color.White
                            }
                        } catch (e: Exception) {
                            stressResult = "Invalid input"
                            stressColor = Color.White
                        }
                    } else {
                        stressResult = "Please fill all fields"
                        stressColor = Color.White
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Predict Stress",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A2980)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Stress Level: $stressResult",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = stressColor
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Breathing Button
        item {
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
