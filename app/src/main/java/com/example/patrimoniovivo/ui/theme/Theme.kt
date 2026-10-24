package com.example.patrimoniovivo.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.LightingColorFilter
import androidx.compose.ui.platform.LocalContext


private val PatrimonioColorScheme = lightColorScheme(
    primary = PrimaryNavy,
    onPrimary = ColorBlanco,

    secondary = SecondaryCopperGreen,
    onSecondary = ColorBlanco,

    background = BackgroundParchment,
    onBackground = TextDark,

    surface = BackgroundParchment,
    onSurface = TextDark,

    error = AccentTerracotta
)

@Composable
fun PatrimonioVivoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PatrimonioColorScheme,
        content = content
    )
}