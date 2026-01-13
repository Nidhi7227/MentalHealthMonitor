package com.example.mentalhealthmonitor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// ---- DARK AND LIGHT COLOR SCHEMES ----
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90DBF4),
    secondary = Color(0xFF3A86FF),
    tertiary = Color(0xFFE63946),
    background = Color(0xFF0B132B),
    surface = Color(0xFF1C2541),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF3A86FF),
    secondary = Color(0xFF8338EC),
    tertiary = Color(0xFFE63946),
    background = Color(0xFFF5F7FA),
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

// ---- COMPOSABLE THEME FUNCTION ----
@Composable
fun MentalHealthMonitorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
