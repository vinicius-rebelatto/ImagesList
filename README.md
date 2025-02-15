# 📷 Aplicativo de Lista de Imagens

O **Aplicativo de Lista de Imagens** é um app Android que exibe uma lista de imagens obtidas de uma API pública. Ele utiliza paginação para carregar mais imagens à medida que o usuário rola a tela. O aplicativo é desenvolvido com práticas modernas de desenvolvimento Android, incluindo `ViewModel`, `LiveData` e `RecyclerView`.

---

## 🚀 Funcionalidades

- **Paginação**: Carrega mais imagens conforme o usuário chega ao final da lista.  
- **Carregamento de Imagens**: Usa **Glide** para carregar e exibir imagens de forma eficiente.  
- **Separação de Responsabilidades**: Segue o padrão de arquitetura **MVVM** para um código mais limpo e fácil de manter.  
- **Integração com API**: Obtém dados de uma API pública (`https://picsum.photos`).  

---

## 🛠️ Tecnologias Utilizadas

- **Kotlin**: Linguagem principal do projeto.  
- **ViewModel**: Gerencia os dados relacionados à interface e sobrevive a mudanças de configuração.  
- **LiveData**: Observa mudanças nos dados e atualiza a interface automaticamente.  
- **RecyclerView**: Exibe a lista de imagens.  
- **Glide**: Faz o carregamento e cache de imagens a partir de URLs.  
- **Retrofit**: Gerencia as requisições para a API.  
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

## 🚀 Começando

### Pré-requisitos

- Android Studio (recomendado: última versão).  
- Um dispositivo Android ou emulador com nível de API 21 ou superior.  

### Instalação

1. **Clone o repositório**:  
   ```bash
   git clone https://github.com/seu-usuario/image-list-app.git
