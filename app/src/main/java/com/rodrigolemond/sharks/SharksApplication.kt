package com.rodrigolemond.sharks

import android.app.Application

/**
 * Classe principal da aplicação Sharks App
 * 
 * Esta classe é inicializada quando o aplicativo é iniciado e permanece ativa
 * durante todo o ciclo de vida da aplicação. Utilizada para inicializar
 * recursos globais como o banco de dados Room.
 */
class SharksApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        // Inicialização de recursos globais da aplicação
        // O banco de dados Room será inicializado aqui quando implementado
    }
}
