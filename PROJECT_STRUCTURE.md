# Estrutura do Projeto Sharks App

## 📁 Organização de Pacotes

O projeto segue a arquitetura **MVVM (Model-View-ViewModel)** com a seguinte estrutura:

```
app/src/main/java/com/rodrigolemond/sharks/
├── SharksApplication.kt          # Classe Application principal
├── model/                        # Camada de Modelo (Model)
│   └── package-info.kt          # Documentação do pacote
├── view/                         # Camada de Visualização (View)
│   ├── MainActivity.kt          # Activity principal
│   └── SplashScreen.kt          # Tela de Splash Screen
├── viewmodel/                    # Camada de ViewModel
│   └── package-info.kt          # Documentação do pacote
└── ui/
    └── theme/                    # Tema e estilização
        ├── Color.kt             # Definição de cores
        ├── Theme.kt             # Tema Material Design 3
        └── Type.kt              # Tipografia
```

## 🏗️ Arquitetura MVVM

### Model (Modelo)
Responsável por:
- Definir entidades de dados
- Gerenciar acesso ao banco de dados Room
- Implementar lógica de negócio
- Fornecer dados através de Repositories

**Futuras implementações:**
- `Trip.kt` - Entidade de corrida/viagem
- `Expense.kt` - Entidade de despesa
- `SharksDatabase.kt` - Banco de dados Room
- `TripDao.kt`, `ExpenseDao.kt` - Data Access Objects

### View (Visualização)
Responsável por:
- Exibir a interface do usuário
- Capturar interações do usuário
- Observar mudanças de estado do ViewModel

**Implementações atuais:**
- `MainActivity.kt` - Activity principal com Jetpack Compose
- `SplashScreen.kt` - Tela inicial do aplicativo

### ViewModel
Responsável por:
- Gerenciar estado da UI
- Processar ações do usuário
- Comunicar-se com o Model
- Expor dados observáveis (StateFlow/LiveData)

**Futuras implementações:**
- `TripViewModel.kt` - Gerenciar corridas
- `ExpenseViewModel.kt` - Gerenciar despesas
- `DashboardViewModel.kt` - Estatísticas e dashboard

## 🎨 Tema e Design

O aplicativo utiliza **Material Design 3** com um tema personalizado:

### Cores Principais
- **Primary (Azul Tubarão)**: `#0D47A1` - Representa confiança e profissionalismo
- **Secondary (Laranja Energia)**: `#FF6F00` - Representa energia e dinamismo

### Tipografia
Utiliza a tipografia padrão do Material Design 3 com hierarquia bem definida:
- Display: Textos muito grandes
- Headline: Títulos
- Title: Subtítulos
- Body: Textos de corpo
- Label: Rótulos e botões

## 📦 Dependências Principais

### Jetpack Compose
```gradle
androidx.compose.ui:ui
androidx.compose.material3:material3
androidx.activity:activity-compose
```

### Room Database
```gradle
androidx.room:room-runtime
androidx.room:room-ktx
```

### Lifecycle & ViewModel
```gradle
androidx.lifecycle:lifecycle-viewmodel-compose
androidx.lifecycle:lifecycle-runtime-compose
```

### Navigation
```gradle
androidx.navigation:navigation-compose
```

## 🚀 Tela de Splash Screen

A Splash Screen implementada possui:
- Animação de fade-in suave (1.5 segundos)
- Exibição do logo e nome do aplicativo
- Tagline motivacional
- Transição automática para a tela principal após 2 segundos

### Código Destacado

```kotlin
@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    val alpha = remember { Animatable(0f) }
    
    LaunchedEffect(key1 = true) {
        alpha.animateTo(1f, animationSpec = tween(1500))
        delay(2000)
        onSplashFinished()
    }
    // ... UI da Splash Screen
}
```

## 📝 Boas Práticas Implementadas

1. **Código Comentado**: Todas as classes e funções possuem documentação KDoc
2. **Separação de Responsabilidades**: Arquitetura MVVM bem definida
3. **Composables Reutilizáveis**: Preview para cada Composable
4. **Temas Centralizados**: Cores e tipografia em arquivos dedicados
5. **Material Design 3**: Utilização das últimas práticas de UI/UX do Google
6. **Suporte a Tema Escuro**: Preparado para temas claro e escuro

## 🔧 Como Compilar

### Pré-requisitos
- Android Studio Hedgehog ou superior
- JDK 17
- Android SDK 34
- Gradle 8.2+

### Passos
1. Clone o repositório
2. Abra o projeto no Android Studio
3. Aguarde a sincronização do Gradle
4. Execute o app em um emulador ou dispositivo físico (API 24+)

## 📱 Requisitos Mínimos

- **minSdk**: 24 (Android 7.0 Nougat)
- **targetSdk**: 34 (Android 14)
- **compileSdk**: 34

## 🎯 Próximos Passos

1. Implementar navegação entre telas
2. Criar banco de dados Room com entidades
3. Implementar tela de dashboard
4. Adicionar funcionalidade de registro de corridas
5. Implementar sistema de despesas
6. Criar relatórios e gráficos
7. Adicionar testes unitários e de UI

## 📄 Licença

Este projeto está em desenvolvimento pela comunidade.
