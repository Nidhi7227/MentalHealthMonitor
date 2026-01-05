package com.example.mentalhealthmonitor.ui.navigations

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Dashboard : Screen("dashboard")
    object Insight : Screen("insight")
    object Calm : Screen("calm")
    object Progress : Screen("progress")
    object TrustedPerson : Screen("trusted_person")
    object EmergencyPreview : Screen("emergency_preview")
}
