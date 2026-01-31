package com.rodrigolemond.sharks.view

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigolemond.sharks.R
import com.rodrigolemond.sharks.ui.theme.SharksTheme
import kotlinx.coroutines.delay

/**
 * Tela de Splash Screen do aplicativo Sharks
 * 
 * Esta é a primeira tela que o usuário vê ao abrir o aplicativo.
 * Exibe o logo e o nome do aplicativo com uma animação de fade-in
 * enquanto recursos são carregados em segundo plano.
 * 
 * @param onSplashFinished Callback executado quando o splash screen termina
 */
@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit = {}
) {
    // Animação de fade-in
    val alpha = remember { Animatable(0f) }
    
    // Executa a animação quando a tela é carregada
    LaunchedEffect(key1 = true) {
        // Anima o fade-in
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1500)
        )
        // Aguarda 2 segundos antes de prosseguir
        delay(2000)
        // Notifica que o splash terminou
        onSplashFinished()
    }
    
    // UI do Splash Screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(alpha.value)
        ) {
            // Ícone representando o aplicativo (ondas/tubarão)
            Icon(
                imageVector = Icons.Default.Waves,
                contentDescription = stringResource(id = R.string.app_name),
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(120.dp)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Nome do aplicativo
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Tagline do aplicativo
            Text(
                text = stringResource(id = R.string.splash_tagline),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

/**
 * Preview da Splash Screen no Android Studio
 */
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SharksTheme {
        SplashScreen()
    }
}
