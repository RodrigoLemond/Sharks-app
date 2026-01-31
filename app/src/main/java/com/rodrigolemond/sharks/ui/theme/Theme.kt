package com.rodrigolemond.sharks.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Esquema de cores do tema claro do Sharks App
 */
private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = TextOnPrimary,
    primaryContainer = PrimaryLight,
    onPrimaryContainer = TextPrimary,
    secondary = Secondary,
    onSecondary = TextOnPrimary,
    secondaryContainer = SecondaryLight,
    onSecondaryContainer = TextPrimary,
    tertiary = Info,
    onTertiary = TextOnPrimary,
    error = Error,
    onError = TextOnPrimary,
    background = Background,
    onBackground = TextPrimary,
    surface = Surface,
    onSurface = TextPrimary,
    surfaceVariant = PrimaryLight,
    onSurfaceVariant = TextSecondary
)

/**
 * Esquema de cores do tema escuro do Sharks App
 */
private val DarkColorScheme = darkColorScheme(
    primary = PrimaryLight,
    onPrimary = TextPrimary,
    primaryContainer = PrimaryVariant,
    onPrimaryContainer = TextOnPrimary,
    secondary = SecondaryLight,
    onSecondary = TextPrimary,
    secondaryContainer = SecondaryVariant,
    onSecondaryContainer = TextOnPrimary,
    tertiary = Info,
    onTertiary = TextPrimary,
    error = Error,
    onError = TextPrimary,
    background = BackgroundDark,
    onBackground = TextOnPrimary,
    surface = SurfaceDark,
    onSurface = TextOnPrimary,
    surfaceVariant = PrimaryVariant,
    onSurfaceVariant = TextSecondary
)

/**
 * Tema principal do Sharks App
 * 
 * @param darkTheme Define se o tema escuro está ativo
 * @param dynamicColor Habilita cores dinâmicas no Android 12+ (desabilitado por padrão para manter identidade visual)
 * @param content Conteúdo composable que utilizará este tema
 */
@Composable
fun SharksTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Desabilitado para manter identidade visual consistente
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        // Cores dinâmicas disponíveis no Android 12+
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        // Tema escuro
        darkTheme -> DarkColorScheme
        // Tema claro (padrão)
        else -> LightColorScheme
    }
    
    // Configuração da cor da status bar
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Aplica o tema Material Design 3
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
