![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/springboot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Postgres](https://img.shields.io/badge/postgresql-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Cloudflare R2](https://img.shields.io/badge/cloudflare-r2-orange?style=for-the-badge&logo=cloudflare&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

# 📝 API de Postagens com Upload de Imagens

Uma API RESTful construída com **Java + Spring Boot**, utilizando **PostgreSQL** (via Docker), com armazenamento de imagens na **Cloudflare R2**. Permite o cadastro de postagens com título, descrição, conteúdo, tags e imagem.

## 🚀 Primeiros passos

Para utilizar a aplicação localmente, é necessário ter instalado em sua máquina:

- <a href="https://git-scm.com">Git</a>
- <a href="https://www.oracle.com/br/java/technologies/downloads/">JDK</a>
- **Recomendado**: <a href="https://www.jetbrains.com/pt-br/idea/">IntelliJ IDEA</a>

## 📌 Funcionalidades

- ✅ Criar postagens com imagem, título, descrição, conteúdo e tags
- ✅ Listar todas as postagens
- ✅ Buscar por título, descrição ou tags
- 📦 Armazenamento de dados com PostgreSQL via Docker
- ☁️ Suporte a armazenamento de imagens no Cloudflare R2

## 🧱 Diagrama da Arquitetura

![Image](https://github.com/victorzld/api-post/issues/1#issue-2977681798)


## 🧑‍💻 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- PostgreSQL
- Cloudflare R2 (simulação por UUID nos testes)
- Docker
- Maven
- Lombok

## 📥 Instalação Local

```bash
git clone https://github.com/seu-usuario/postagem-api.git

cd postagem-api

./mvnw spring-boot:run
```

- <p id="local-installation"> Configure o arquivo src/main/resources/application.properties com as informações do seu banco PostgreSQL e CloudFlare R2</p>

- <p id="local-installation-docker"> Utilize o Docker para executar o seu PostgreSQL:</p>

```bash
docker-compose up -d
```

## 🌐 Endpoints

| Método           | Endpoint                                   | Descrição                                                                                      |
| ---------------- | ------------------------------------------ | ---------------------------------------------------------------------------------------------- |
| <kbd>POST </kbd> | <kbd> /posts</kbd>                         | Cria uma nova postagem com imagem - [response details](#post-posts)                            |
| <kbd>GET </kbd>  | <kbd> /posts</kbd>                         | Retorna todas as postagens. - [response details](#get-posts)                                   |
| <kbd>GET </kbd>  | <kbd> /posts/{id}</kbd>                    | Busca uma postagem pelo ID- [response details](#get-postsID)                                   |
| <kbd>GET </kbd>  | <kbd> /posts/titulo?titulo=...</kbd>       | Busca postagens pelo título (parcial ou completo) - [response details](#get-postsTitulo)       |
| <kbd>GET </kbd>  | <kbd> /posts/descricao?descricao=...</kbd> | Busca postagens pela descrição (parcial ou completa) - [response details](#get-postsDescricao) |
|                  |

<h3 id="post-posts">🔹 POST  /posts</h3>

**Descrição**: Cria uma nova postagem com imagem.

**Request**:

**Multipart/form-data:**

```bash
{
    titulo: "Meu post"
    descricao: "Descrição do post"
    postagem: "Conteúdo completo"
    tag1: "java"
    tag2: "spring"
    imagem: [arquivo .jpg/.png]
}
```

**Response**:

```bash
{
  "id": 1,
  "titulo": "Meu post",
  "descricao": "Descrição do post",
  "postagem": "Conteúdo completo",
  "tag1": "java",
  "tag2": "spring",
  "imagemUrl": "https://meu-bucket.cloudflare-r2.com/UUID-ALEATORIO",
  "criadoEm": "06/04/2025 16:50"
}
```

<h3 id="get-posts">🔹 GET  /posts</h3>

**Descrição**: Retorna todas as postagens.

**Response**:

```bash
[
  {
    "id": 1,
    "titulo": "Meu post",
    "descricao": "Descrição do post",
    "postagem": "Conteúdo completo",
    "tag1": "java",
    "tag2": "spring",
    "imagemUrl": "https://meu-bucket.cloudflare-r2.com/UUID-ALEATORIO",
    "criadoEm": "06/04/2025 16:50"
  }
]
```

## 🛫 Instruções de Deploy

### Recomendado usar serviços como:

- 1. <a href="https://railway.app" > Railway</a>
- 2. <a href="https://render.com/" > Render</a>
- 3. AWS ou Heroku (caso use Cloudflare R2 externamente)
- 4. Caso não tenha feito, configure o arquivo application.properties como explicado na [seção](#local-installation) acima.

## Autor

Feito com 💚 por <a href="https://github.com/victorzld" >victorzld</a>

## Licença

<a href="/LICENSE" >MIT</a>
