# Guia de Configuração e Desenvolvimento - Sharks App

## 📋 Pré-requisitos

### Software Necessário
1. **Android Studio Hedgehog (2023.1.1) ou superior**
   - Download: https://developer.android.com/studio
   
2. **JDK 17**
   - Já incluído no Android Studio
   - Ou download: https://adoptium.net/

3. **Android SDK**
   - API Level 34 (Android 14)
   - Build Tools 34.0.0
   - Instalado via Android Studio SDK Manager

4. **Git**
   - Para controle de versão

### Configuração do Ambiente

#### 1. Instalar Android Studio
```bash
# Linux
sudo snap install android-studio --classic

# macOS
brew install --cask android-studio

# Windows
# Baixar instalador do site oficial
```

#### 2. Configurar SDK
1. Abra Android Studio
2. Vá em `Tools > SDK Manager`
3. Na aba `SDK Platforms`, instale:
   - Android 14.0 (API 34)
   - Android 7.0 (API 24) - para teste do minSdk
4. Na aba `SDK Tools`, instale:
   - Android SDK Build-Tools 34.0.0
   - Android Emulator
   - Android SDK Platform-Tools
   - Google Play Services

## 🚀 Primeiros Passos

### 1. Clonar o Repositório
```bash
git clone https://github.com/RodrigoLemond/Sharks-app.git
cd Sharks-app
```

### 2. Abrir no Android Studio
1. Abra Android Studio
2. Clique em `File > Open`
3. Navegue até a pasta `Sharks-app`
4. Clique em `OK`

### 3. Sincronizar Dependências
O Android Studio automaticamente sincronizará o Gradle. Aguarde o processo terminar.

Se houver problemas:
```bash
# No terminal do Android Studio
./gradlew clean
./gradlew build --refresh-dependencies
```

### 4. Executar o App

#### Opção A: Emulador
1. Vá em `Tools > Device Manager`
2. Crie um novo dispositivo virtual:
   - Hardware: Pixel 6
   - System Image: API 34 (Android 14)
3. Clique no botão ▶️ (Run) ou pressione `Shift + F10`

#### Opção B: Dispositivo Físico
1. Ative o modo desenvolvedor no seu Android:
   - Configurações > Sobre o telefone
   - Toque 7 vezes em "Número da versão"
2. Ative `Depuração USB` em:
   - Configurações > Opções do desenvolvedor
3. Conecte o dispositivo via USB
4. Clique no botão ▶️ (Run)

## 🏗️ Comandos Gradle Úteis

### Build e Instalação
```bash
# Build do projeto
./gradlew build

# Build apenas do módulo app
./gradlew :app:build

# Build de debug
./gradlew assembleDebug

# Build de release
./gradlew assembleRelease

# Instalar no dispositivo conectado
./gradlew installDebug
```

### Limpeza e Cache
```bash
# Limpar build
./gradlew clean

# Limpar cache do Gradle
./gradlew cleanBuildCache

# Atualizar dependências
./gradlew build --refresh-dependencies
```

### Testes
```bash
# Executar testes unitários
./gradlew test

# Executar testes de instrumentação
./gradlew connectedAndroidTest

# Gerar relatório de cobertura
./gradlew jacocoTestReport
```

### Verificação de Código
```bash
# Lint do Android
./gradlew lint

# Detekt (análise estática Kotlin)
./gradlew detekt

# Formatar código Kotlin
./gradlew ktlintFormat
```

## 📁 Estrutura de Diretórios

```
Sharks-app/
├── app/                          # Módulo principal do app
│   ├── build.gradle             # Configuração do módulo
│   ├── proguard-rules.pro       # Regras ProGuard
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/rodrigolemond/sharks/
│           │   ├── SharksApplication.kt
│           │   ├── model/       # Entidades e lógica
│           │   ├── view/        # UI e Activities
│           │   ├── viewmodel/   # ViewModels
│           │   └── ui/theme/    # Tema e estilo
│           └── res/             # Recursos (layouts, strings, etc)
├── build.gradle                 # Configuração raiz do projeto
├── settings.gradle              # Configuração de módulos
├── gradle.properties            # Propriedades do Gradle
└── .gitignore                   # Arquivos ignorados pelo Git
```

## 🎨 Temas e Cores

### Cores Primárias
```kotlin
val Primary = Color(0xFF0D47A1)        // Azul Tubarão
val Secondary = Color(0xFFFF6F00)      // Laranja Energia
```

### Usar Cores no Compose
```kotlin
Text(
    text = "Exemplo",
    color = MaterialTheme.colorScheme.primary
)
```

## 🧩 Adicionar Nova Funcionalidade

### 1. Criar uma Nova Tela (View)
```kotlin
// app/src/main/java/.../view/MinhaNovaScreen.kt
@Composable
fun MinhaNovaScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text("Minha Nova Tela")
    }
}
```

### 2. Criar um ViewModel
```kotlin
// app/src/main/java/.../viewmodel/MinhaViewModel.kt
class MinhaViewModel : ViewModel() {
    private val _state = MutableStateFlow(MinhaState())
    val state: StateFlow<MinhaState> = _state.asStateFlow()
    
    fun fazerAlgo() {
        // Lógica aqui
    }
}
```

### 3. Criar uma Entidade (Model)
```kotlin
// app/src/main/java/.../model/MinhaEntidade.kt
@Entity(tableName = "minha_tabela")
data class MinhaEntidade(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "campo") val campo: String
)
```

## 🐛 Troubleshooting

### Erro: "SDK location not found"
Crie o arquivo `local.properties` na raiz do projeto:
```properties
sdk.dir=/caminho/para/Android/Sdk
```

### Erro de compilação Compose
Verifique versões:
- Kotlin: 1.9.22
- Compose Compiler: 1.5.4

### Erro de dependências
```bash
./gradlew clean
./gradlew build --refresh-dependencies
```

### Emulador lento
1. Habilite aceleração de hardware (HAXM/KVM)
2. Use uma imagem do sistema sem Google Play
3. Reduza a resolução do emulador

## 📚 Recursos Adicionais

### Documentação
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Room Database](https://developer.android.com/training/data-storage/room)
- [Material Design 3](https://m3.material.io/)
- [MVVM Architecture](https://developer.android.com/topic/architecture)

### Tutoriais Recomendados
- [Compose Basics](https://developer.android.com/courses/pathways/compose)
- [Room Database Guide](https://developer.android.com/codelabs/android-room-with-a-view-kotlin)
- [ViewModel and LiveData](https://developer.android.com/codelabs/kotlin-android-training-live-data)

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📄 Checklist de Desenvolvimento

### Antes de Commitar
- [ ] Código compilado sem erros
- [ ] Lint passou sem warnings críticos
- [ ] Testes unitários passando
- [ ] Código comentado adequadamente
- [ ] Preview dos Composables funcionando

### Antes de Pull Request
- [ ] Build de release funcionando
- [ ] Testado em dispositivo físico
- [ ] Documentação atualizada
- [ ] Screenshots adicionados (se UI)
- [ ] Changelog atualizado

## ⚡ Performance Tips

1. **Recomposição**: Use `remember` e `derivedStateOf`
2. **LazyColumn**: Para listas grandes
3. **Imagens**: Use Coil para carregamento eficiente
4. **Room**: Use Flow para queries reativas
5. **ViewModel**: Evite lógica pesada no MainThread

## 🔒 Segurança

- Nunca commite chaves de API no código
- Use BuildConfig para constantes sensíveis
- Implemente ofuscação com ProGuard/R8
- Valide inputs do usuário
- Use HTTPS para comunicação de rede

---

**Versão do documento**: 1.0  
**Última atualização**: Janeiro 2026  
**Mantenedor**: Equipe Sharks App
