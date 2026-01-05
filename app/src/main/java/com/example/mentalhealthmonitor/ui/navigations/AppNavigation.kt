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
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            }
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onBreathingClick = {
                    navController.navigate(Screen.Calm.route)
                }
            )
        }


        composable(Screen.Dashboard.route) {
            HomeDashboardScreen(
                onBreathingClick = TODO()
            )
        }

        composable(Screen.Insight.route) {
            ExplainableInsightScreen()
        }

        composable(Screen.Calm.route) {
            BreathingScreen() //
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
