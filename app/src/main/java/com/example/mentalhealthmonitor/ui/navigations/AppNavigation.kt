package com.example.mentalhealthmonitor.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.m.ui.screens.EmergencyAlertPreviewScreen
import com.example.mentalhealthmonitor.ui.screens.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {
            SplashScreen {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Splash.route) {
                        this.inclusive = true
                    }
                }
            }
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onBreathingClick = {
                    navController.navigate(Screen.Calm.route)
                },
                onDashboardClick = {
                    navController.navigate(Screen.Dashboard.route)
                },
                onInsightClick = {
                    navController.navigate(Screen.Insight.route)
                },
                onProgressClick = {
                    navController.navigate(Screen.Progress.route)
                },
                onTrustedPersonClick = {
                    navController.navigate(Screen.TrustedPerson.route)
                },
                onEmergencyClick = {
                    navController.navigate(Screen.EmergencyPreview.route)
                }
            )
        }


        composable(Screen.Dashboard.route) {
            HomeDashboardScreen(
                onBreathingClick = { navController.navigate(Screen.Calm.route) }
            )
        }

        composable(Screen.Insight.route) {
            ExplainableInsightScreen()
        }

        composable(Screen.Calm.route) {
            BreathingScreen()
        }

        composable(Screen.Progress.route) {
            ProgressScreen()
        }

        composable(Screen.TrustedPerson.route) {
            TrustedPersonSetupScreen()
        }

        composable(Screen.EmergencyPreview.route) {
            EmergencyAlertPreviewScreen()
        }
    }
}
