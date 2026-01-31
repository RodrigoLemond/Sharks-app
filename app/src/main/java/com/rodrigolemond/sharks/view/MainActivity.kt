package com.rodrigolemond.sharks.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rodrigolemond.sharks.ui.theme.SharksTheme

/**
 * MainActivity - Atividade principal do aplicativo Sharks
 * 
 * Esta activity implementa o padrão MVVM com Jetpack Compose.
 * Gerencia a navegação entre a Splash Screen e a tela principal do app.
 * 
 * Arquitetura:
 * - View: Esta activity e os Composables
 * - ViewModel: Será implementado para gerenciar o estado da UI
 * - Model: Entidades e lógica de negócio
 */
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        // Instala o Splash Screen nativo do Android 12+
        installSplashScreen()
        
        super.onCreate(savedInstanceState)
        
        // Define o conteúdo da tela usando Jetpack Compose
        setContent {
            SharksTheme {
                // Surface container usando a cor de background do tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SharksApp()
                }
            }
        }
    }
}

/**
 * Composable principal do aplicativo
 * Gerencia a navegação entre Splash Screen e tela principal
 */
@Composable
fun SharksApp() {
    // Estado que controla se o splash screen está sendo exibido
    var showSplashScreen by remember { mutableStateOf(true) }
    
    if (showSplashScreen) {
        // Exibe a Splash Screen
        SplashScreen(
            onSplashFinished = {
                // Quando o splash terminar, alterna para a tela principal
                showSplashScreen = false
            }
        )
    } else {
        // Tela principal do aplicativo (temporária)
        // Será substituída pela navegação real quando implementada
        MainScreen()
    }
}

/**
 * Tela principal temporária do aplicativo
 * Esta será substituída pela implementação real com navegação
 */
@Composable
fun MainScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Bem-vindo ao Sharks App!\n\nTela principal em desenvolvimento...",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

/**
 * Preview da aplicação no Android Studio
 */
@Preview(showBackground = true)
@Composable
fun SharksAppPreview() {
    SharksTheme {
        SharksApp()
    }
}

/**
 * Preview da tela principal no Android Studio
 */
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    SharksTheme {
        MainScreen()
    }
}
