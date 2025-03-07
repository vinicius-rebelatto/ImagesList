# 📷 Aplicativo de Lista de Imagens

O **Aplicativo de Lista de Imagens** é um app Android que exibe uma lista de imagens obtidas de uma API pública. Ele utiliza paginação para carregar mais imagens à medida que o usuário rola a tela. O aplicativo é desenvolvido com práticas modernas de desenvolvimento Android, incluindo `ViewModel`, `LiveData` e `RecyclerView`.

---

## 🚀 Funcionalidades

- **Paginação**: Carrega mais imagens conforme o usuário chega ao final da lista.  
- **Carregamento de Imagens**: Usa **Glide** para carregar e exibir imagens de forma eficiente.  
- **Separação de Responsabilidades**: Segue o padrão de arquitetura **MVVM** para um código mais limpo e fácil de manter.  
- **Integração com API**: Obtém dados das APIs públicas (`https://jsonplaceholder.typicode.com/` e `https://picsum.photos`).  

---

## 🛠️ Tecnologias Utilizadas

- **Kotlin**: Linguagem principal do projeto.  
- **ViewModel**: Gerencia os dados relacionados à interface e sobrevive a mudanças de configuração.  
- **RecyclerView**: Exibe a lista de imagens.
- **ConstraintLayout**: Permite criar layouts responsivos no xml do projeto.
- **Retrofit**: Gerencia as requisições para a API.  
- **Glide**: Faz o carregamento e cache de imagens a partir de URLs.
- **LiveData**: Observa mudanças nos dados e atualiza a interface automaticamente.   
- **Coroutines**: Controla tarefas assíncronas.  

---

## 🏗️ Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

- **`api`**: Contém a configuração do Retrofit e as interfaces de serviço da API.  
- **`models`**: Define os modelos de dados (por exemplo, `Photo`).  
- **`ui.adapters`**: Contém o adaptador `RecyclerView` (`PhotoAdapter`).  
- **`viewmodels`**: Contém o `PhotoViewModel`, responsável pelo gerenciamento de dados.  
- **`MainActivity`**: A activity principal que exibe a lista de imagens.  

---

## 🖼️ Como Funciona

### 📡 Obtenção de Dados:

- A API pública `https://jsonplaceholder.typicode.com/photos` não fornece mais imagens válidas nos links do arquivo JSON. Por isso, para cada objeto retornado, foi atribuída uma imagem aleatória obtida de outra API.
  Exemplo de resposta da API:
  ```json
  {
    "albumId": 1,
    "id": 1,
    "title": "accusamus beatae ad facilis cum similique qui sunt",
    "url": "https://via.placeholder.com/600/92c952",
    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
  }
  ```
- O app exibe uma lista de imagens obtidas da API pública `https://picsum.photos`.
- Cada item da lista apresenta um título e uma miniatura.

###  Paginação:

- Quando o usuário rola até o final da lista, o aplicativo busca a próxima página de imagens

###  Carregamento de Imagens:

- Glide é usado para carregar imagens de forma eficiente e armazená-las em cache para melhor desempenho.

---

### 📦 Dependências (Gradle: App)

```kts
dependencies {
    //Android standard
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Retrofit e Gson (Consumo de API)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Componentes de UI
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.constraintlayout)

    // Arquitetura (ViewModel e LiveData)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.kotlinx.coroutines.android)

    // Glide (Carregamento de Imagens)
    implementation(libs.glide)
}
```

---

## 🎥 Demonstração
![Demonstração do App](./demo.gif)


