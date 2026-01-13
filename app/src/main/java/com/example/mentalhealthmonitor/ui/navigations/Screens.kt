package com.example.mentalhealthmonitor.ui.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Splash : Screen("splash", "", Icons.Default.Home)
    object Main : Screen("main", "", Icons.Default.Home)

    object Home : Screen("home", "Home", Icons.Default.Home)
    object Dashboard : Screen("dashboard", "Dashboard", Icons.Default.Menu)
    object Insight : Screen("insight", "Insights", Icons.Default.Info)
    object Progress : Screen("progress", "Progress", Icons.Default.List)

    object Calm : Screen("calm", "Calm", Icons.Default.Favorite)
    object TrustedPerson : Screen("trusted_person", "Trusted", Icons.Default.Person)
    object EmergencyPreview : Screen("emergency_preview", "Emergency", Icons.Default.Warning)

    // ✅ Corrected Settings
    object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}
