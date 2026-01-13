package com.example.mentalhealthmonitor.ui.navigations

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mentalhealthmonitor.ui.screens.MainScreen
import com.example.mentalhealthmonitor.ui.screens.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    // 🌱 App-level states (shared across screens)
    var isDarkTheme by remember { mutableStateOf(false) }
    var language by remember { mutableStateOf("English") }
    var trustedName by remember { mutableStateOf("") }
    var trustedPhone by remember { mutableStateOf("") }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        // 🌅 Splash Screen
        composable(Screen.Splash.route) {
            SplashScreen {
                navController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Splash.route) {
                        inclusive = true
                    }
                }
            }
        }

        // 🏠 Main App
        composable(Screen.Main.route) {
            MainScreen(
                isDarkTheme = isDarkTheme,
                onThemeChange = { isDarkTheme = it },
                language = language,
                onLanguageChange = { language = it },
                trustedName = trustedName,
                onTrustedNameChange = { trustedName = it },
                trustedPhone = trustedPhone,
                onTrustedPhoneChange = { trustedPhone = it }
            )
        }
    }
}
