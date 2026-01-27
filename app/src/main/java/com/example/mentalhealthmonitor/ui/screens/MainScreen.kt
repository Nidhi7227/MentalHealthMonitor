package com.example.mentalhealthmonitor.ui.screens

import SettingsScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mentalhealthmonitor.ui.navigations.BottomNavigationBar
import com.example.mentalhealthmonitor.ui.navigations.Screen

@Composable
fun MainScreen(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    language: String,
    onLanguageChange: (String) -> Unit,
    trustedName: String,
    onTrustedNameChange: (String) -> Unit,
    trustedPhone: String,
    onTrustedPhoneChange: (String) -> Unit
) {

    val navController = rememberNavController()
    val context = LocalContext.current

    androidx.compose.material3.Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        content = { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {

                // 🏠 Home Screen
                composable(Screen.Home.route) {
                    HomeScreen(
                        userName = "Nivetha",
                        heartRate = 78,
                        bandConnected = true,
                        batteryLevel = 82,
                        onBreathingClick = {
                            navController.navigate(Screen.Calm.route)
                        },
                        onSettingsClick = {
                            navController.navigate(Screen.Settings.route)
                        }
                    )
                }

                // 🌬 Calm / Breathing
                composable(Screen.Calm.route) {
                    BreathingScreen()
                }

                // 📊 Progress
                composable(Screen.Progress.route) {
                    ProgressScreen()
                }

                // 🧠 Insights
                composable(Screen.Insight.route) {
                    ExplainableInsightScreen()
                }

                // 🧾 Dashboard with ML Inputs
                composable(Screen.Dashboard.route) {
                    HomeDashboardScreen(
                        onBreathingClick = {
                            navController.navigate(Screen.Calm.route)
                        },
                        context = context
                    )
                }

                // ⚙️ Settings
                composable(Screen.Settings.route) {
                    SettingsScreen(
                        isDarkTheme = isDarkTheme,
                        onThemeChange = onThemeChange,
                        currentLanguage = language,
                        onLanguageChange = onLanguageChange,
                        trustedPersonName = trustedName,
                        onTrustedPersonChange = onTrustedNameChange,
                        trustedPersonPhone = trustedPhone,
                        onTrustedPhoneChange = onTrustedPhoneChange
                    )
                }
            }
        }
    )
}
