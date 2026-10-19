
package com.example.superheroes.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary = Color(0xFF466800),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFC2F280),
    onPrimaryContainer = Color(0xFF121F00),
    secondary = Color(0xFF596248),
    secondaryContainer = Color(0xFFDDE6C6),
    background = Color(0xFFFDFCF5),
    surface = Color(0xFFFDFCF5),
    surfaceVariant = Color(0xFFE0E4D6)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFA7D568),
    onPrimary = Color(0xFF223600),
    primaryContainer = Color(0xFF344F00),
    secondary = Color(0xFFC1CAA9),
    secondaryContainer = Color(0xFF424A32),
    background = Color(0xFF1A1C16),
    surface = Color(0xFF1A1C16),
    surfaceVariant = Color(0xFF44483D)
)

@Composable
fun SuperheroesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as Activity).window
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
