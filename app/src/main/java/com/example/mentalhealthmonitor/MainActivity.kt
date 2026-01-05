package com.example.mentalhealthmonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mentalhealthmonitor.ui.navigations.AppNavigation

import com.example.mentalhealthmonitor.ui.screens.BreathingScreen
import com.example.mentalhealthmonitor.ui.screens.ExplainableInsightScreen
import com.example.mentalhealthmonitor.ui.screens.HomeScreen
import com.example.mentalhealthmonitor.ui.screens.SplashScreen
import com.example.mentalhealthmonitor.ui.screens.HomeDashboardScreen
import com.example.mentalhealthmonitor.ui.screens.ProgressScreen
import com.example.mentalhealthmonitor.ui.theme.MentalHealthMonitorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentalHealthMonitorTheme {
                AppNavigation()
            }
        }
    }
}
