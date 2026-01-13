package com.example.mentalhealthmonitor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProgressScreen() {

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF1A2980),
            Color(0xFF26D0CE)
        )
    )

    var selectedTab by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Your Progress 📈",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.Transparent,
            contentColor = Color.White
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("Weekly") }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("Monthly") }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (selectedTab == 0) {
            WeeklyContent()
        } else {
            MonthlyContent()
        }
    }
}

/* ---------- WEEKLY ---------- */

@Composable
private fun WeeklyContent() {

    ProgressCard(
        title = "Average Sleep",
        value = "6.5 hrs",
        subtitle = "↓ 0.4 hrs from last week"
    )

    Spacer(modifier = Modifier.height(16.dp))

    ProgressCard(
        title = "Average Stress",
        value = "Moderate",
        subtitle = "Stable overall"
    )

    Spacer(modifier = Modifier.height(16.dp))

    ProgressCard(
        title = "Mood Pattern",
        value = "Fluctuating",
        subtitle = "More calm days than stressed"
    )
}

/* ---------- MONTHLY ---------- */

@Composable
private fun MonthlyContent() {

    ProgressCard(
        title = "Overall Trend",
        value = "Improving 🌱",
        subtitle = "Your routine is helping"
    )

    Spacer(modifier = Modifier.height(16.dp))

    ProgressCard(
        title = "Good Days",
        value = "18 days",
        subtitle = "Out of last 30 days"
    )

    Spacer(modifier = Modifier.height(16.dp))

    ProgressCard(
        title = "Difficult Days",
        value = "6 days",
        subtitle = "Mostly related to sleep loss"
    )

    Spacer(modifier = Modifier.height(24.dp))

    Text(
        text = "Insight",
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.White
    )

    Text(
        text = "Your stress spikes usually follow poor sleep. Improving sleep consistency may help stabilize your mood.",
        fontSize = 13.sp,
        color = Color.White.copy(alpha = 0.9f)
    )
}

/* ---------- CARD ---------- */

@Composable
private fun ProgressCard(
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
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, color = Color.White.copy(alpha = 0.9f), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(value, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
        }
    }
}
