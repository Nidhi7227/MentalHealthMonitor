package com.example.mentalhealthmonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.mentalhealthmonitor.ui.screens.MainScreen
import com.example.mentalhealthmonitor.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var isDarkTheme by remember { mutableStateOf(false) }
            var language by remember { mutableStateOf("English") }
            var trustedName by remember { mutableStateOf("") }
            var trustedPhone by remember { mutableStateOf("") }

            MyAppTheme(darkTheme = isDarkTheme) {
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
}
