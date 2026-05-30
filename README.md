# 🛰️ AgroSat Alert

> Plataforma de monitoramento agrícola via satélite — Global Solution 2026 | FIAP

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue?style=flat-square&logo=mysql)
![Docker](https://img.shields.io/badge/Docker-compose-2496ED?style=flat-square&logo=docker)
![Maven](https://img.shields.io/badge/Build-Maven-red?style=flat-square)
![Swagger](https://img.shields.io/badge/Docs-Swagger-85EA2D?style=flat-square&logo=swagger)

---

## 📋 Sobre o Projeto

O **AgroSat Alert** é uma API REST desenvolvida como parte da Global Solution 2026 da FIAP, com tema **Space Connect — Tecnologia Espacial Aplicada a Desafios Reais**.

O sistema conecta dados de satélites espaciais (CBERS-4A, Sentinel-1A, GOES-16, Aqua) ao agronegócio brasileiro, emitindo alertas climáticos e ambientais em tempo real para produtores rurais. A plataforma permite que cooperativas agrícolas tomem decisões estratégicas com base em dados orbitais precisos, reduzindo perdas nas safras causadas por eventos climáticos extremos.

### 🎯 Problema que resolve

O Brasil perde bilhões de reais anualmente em safras por falta de informação climática precisa no campo. Satélites já captam esses dados em tempo real, mas não chegam de forma estruturada ao produtor rural. O AgroSat Alert preenche essa lacuna.

### 🌍 ODS Atendidos

- **ODS 2** — Fome zero e agricultura sustentável
- **ODS 9** — Indústria, inovação e infraestrutura
- **ODS 13** — Ação contra a mudança global do clima

---

## 🏗️ Arquitetura do Projeto

```
agrosat-alert/
├── src/
│   ├── main/
│   │   ├── java/giovanni_565123/agrosatalert/
│   │   │   ├── config/
│   │   │   │   ├── ModelMapperConfig.java
│   │   │   │   └── SwaggerConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── ProdutorController.java
│   │   │   │   ├── SateliteController.java
│   │   │   │   ├── TalhaoController.java
│   │   │   │   └── AlertaClimaticoController.java
│   │   │   ├── service/
│   │   │   │   ├── ProdutorService.java
│   │   │   │   ├── SateliteService.java
│   │   │   │   ├── TalhaoService.java
│   │   │   │   └── AlertaClimaticoService.java
│   │   │   ├── repository/
│   │   │   │   ├── ProdutorRepository.java
│   │   │   │   ├── SateliteRepository.java
│   │   │   │   ├── TalhaoRepository.java
│   │   │   │   └── AlertaClimaticoRepository.java
│   │   │   ├── entity/
│   │   │   │   ├── Produtor.java
│   │   │   │   ├── Satelite.java
│   │   │   │   ├── Talhao.java
│   │   │   │   └── AlertaClimatico.java
│   │   │   ├── dto/
│   │   │   │   ├── request/
│   │   │   │   │   ├── ProdutorRequest.java
│   │   │   │   │   ├── SateliteRequest.java
│   │   │   │   │   ├── TalhaoRequest.java
│   │   │   │   │   └── AlertaClimaticoRequest.java
│   │   │   │   └── response/
│   │   │   │       ├── ProdutorResponse.java
│   │   │   │       ├── SateliteResponse.java
│   │   │   │       ├── TalhaoResponse.java
│   │   │   │       └── AlertaClimaticoResponse.java
│   │   │   └── exception/
│   │   │       ├── ResourceNotFoundException.java
│   │   │       └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── import.sql
├── docker-compose.yml
└── pom.xml
```

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Versão | Uso |
|-----------|--------|-----|
| Java | 17 | Linguagem principal |
| Spring Boot | 3.5 | Framework web |
| Spring Data JPA | 3.5 | Persistência de dados |
| MySQL | 8.0 | Banco de dados |
| Docker | - | Container do banco de dados |
| ModelMapper | 3.2.0 | Mapeamento Entity/DTO |
| SpringDoc OpenAPI | 2.5.0 | Documentação Swagger |
| Maven | - | Gerenciador de dependências |

---

## 🚀 Como Executar

### Pré-requisitos

- Java 17 instalado
- Maven instalado (ou usar o wrapper do projeto)
- Docker e Docker Compose instalados

### Passo 1 - Clone o repositório

```bash
git clone https://github.com/seuusuario/agrosat-alert.git
cd agrosat-alert
```

### Passo 2 - Suba o banco de dados MySQL com Docker

```bash
docker-compose up -d
```

Verifique se o container subiu corretamente:

```bash
docker ps
```

Deve aparecer o container `agrosat-mysql` com status `Up`.

### Passo 3 - Execute o projeto

No Linux/Mac:
```bash
./mvnw spring-boot:run
```

No Windows:
```bash
mvnw.cmd spring-boot:run
```

### Passo 4 - Acesse a API e a documentação

| Recurso | URL |
|---------|-----|
| Swagger UI | http://localhost:9000/ |
| API Docs JSON | http://localhost:9000/api-docs |
| Produtores | http://localhost:9000/api/v2/produtores |
| Satelites | http://localhost:9000/api/v2/satelites |
| Talhoes | http://localhost:9000/api/v2/talhoes |
| Alertas | http://localhost:9000/api/v2/alertas |

---

## 🐳 Docker Compose

O arquivo `docker-compose.yml` sobe o MySQL 8.0 com as seguintes configurações:

| Parâmetro | Valor |
|-----------|-------|
| Container | agrosat-mysql |
| Porta | 3306 |
| Banco | agrosat_db |
| Usuário | root |
| Senha | agrosat2026 |

Para parar o container:
```bash
docker-compose down
```

Para parar e remover os dados:
```bash
docker-compose down -v
```

---

## 📊 Modelo de Dados

### Entidades e Relacionamentos

```
Produtor (1) ----< (N) Talhao (1) ----< (N) AlertaClimatico >---- (1) Satelite
```

### Produtor

| Campo | Tipo | Tamanho | Nullable | Descrição |
|-------|------|---------|----------|-----------|
| id | Long | - | false | Chave primária |
| nome | String | 100 | false | Nome do produtor |
| cpf | String | 14 | false | CPF único |
| email | String | 100 | false | Email |
| telefone | String | 20 | false | Telefone |
| dataCadastro | LocalDate | - | false | Data de cadastro |

### Satelite

| Campo | Tipo | Tamanho | Nullable | Descrição |
|-------|------|---------|----------|-----------|
| id | Long | - | false | Chave primária |
| nome | String | 100 | false | Nome do satélite |
| agencia | String | 100 | false | Agência responsável |
| altitudeKm | Double | - | false | Altitude em km |
| dataLancamento | LocalDate | - | false | Data de lançamento |
| statusOperacional | String | 50 | false | Status (ATIVO/INATIVO) |

### Talhao

| Campo | Tipo | Tamanho | Nullable | Descrição |
|-------|------|---------|----------|-----------|
| id | Long | - | false | Chave primária |
| nome | String | 100 | false | Nome do talhão |
| cultura | String | 100 | false | Cultura plantada |
| areaHectares | Double | - | false | Área em hectares |
| localizacao | String | 200 | false | Localização geográfica |
| dataCadastro | LocalDate | - | false | Data de cadastro |
| produtorId | Long | - | false | FK para Produtor |

### AlertaClimatico

| Campo | Tipo | Tamanho | Nullable | Descrição |
|-------|------|---------|----------|-----------|
| id | Long | - | false | Chave primária |
| tipoAlerta | String | 100 | false | Tipo do alerta |
| severidade | Integer | 1-10 | false | Nível de severidade |
| impactoEstimado | Double | - | false | Impacto estimado |
| dataEvento | LocalDate | - | false | Data do evento |
| status | String | 50 | false | Status do alerta |
| talhaoId | Long | - | false | FK para Talhao |
| sateliteId | Long | - | false | FK para Satelite |

---

## 🔌 Endpoints da API (v2)

### Produtores `/api/v2/produtores`

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/api/v2/produtores` | Lista todos os produtores | 200 |
| GET | `/api/v2/produtores/{id}` | Busca produtor por ID | 200 / 404 |
| POST | `/api/v2/produtores` | Cria novo produtor | 201 |
| PUT | `/api/v2/produtores/{id}` | Atualiza produtor | 200 / 404 |
| DELETE | `/api/v2/produtores/{id}` | Remove produtor | 204 / 404 |

### Satelites `/api/v2/satelites`

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/api/v2/satelites` | Lista todos os satélites | 200 |
| GET | `/api/v2/satelites/{id}` | Busca satélite por ID | 200 / 404 |
| POST | `/api/v2/satelites` | Cria novo satélite | 201 |
| PUT | `/api/v2/satelites/{id}` | Atualiza satélite | 200 / 404 |
| DELETE | `/api/v2/satelites/{id}` | Remove satélite | 204 / 404 |

### Talhoes `/api/v2/talhoes`

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/api/v2/talhoes` | Lista todos os talhões | 200 |
| GET | `/api/v2/talhoes/{id}` | Busca talhão por ID | 200 / 404 |
| GET | `/api/v2/talhoes/produtor/{id}` | Lista talhões por produtor | 200 |
| POST | `/api/v2/talhoes` | Cria novo talhão | 201 |
| PUT | `/api/v2/talhoes/{id}` | Atualiza talhão | 200 / 404 |
| DELETE | `/api/v2/talhoes/{id}` | Remove talhão | 204 / 404 |

### Alertas `/api/v2/alertas`

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/api/v2/alertas` | Lista todos os alertas | 200 |
| GET | `/api/v2/alertas/{id}` | Busca alerta por ID | 200 / 404 |
| GET | `/api/v2/alertas/talhao/{id}` | Lista alertas por talhão | 200 |
| POST | `/api/v2/alertas` | Cria novo alerta | 201 |
| PUT | `/api/v2/alertas/{id}` | Atualiza alerta | 200 / 404 |
| DELETE | `/api/v2/alertas/{id}` | Remove alerta | 204 / 404 |

---

## 📝 Exemplos de Uso

### Criar um produtor

```http
POST http://localhost:9000/api/v2/produtores
Content-Type: application/json

{
  "nome": "Joao Silva",
  "cpf": "123.456.789-00",
  "email": "joao@fazenda.com",
  "telefone": "(65) 99999-1111",
  "dataCadastro": "2026-01-05"
}
```

### Criar um satélite

```http
POST http://localhost:9000/api/v2/satelites
Content-Type: application/json

{
  "nome": "CBERS-4A",
  "agencia": "INPE",
  "altitudeKm": 628.0,
  "dataLancamento": "2019-12-20",
  "statusOperacional": "ATIVO"
}
```

### Criar um talhão

```http
POST http://localhost:9000/api/v2/talhoes
Content-Type: application/json

{
  "nome": "Talhao Norte 1",
  "cultura": "Soja",
  "areaHectares": 120.5,
  "localizacao": "Fazenda A - Regiao Norte, MT",
  "dataCadastro": "2026-01-10",
  "produtorId": 1
}
```

### Criar um alerta

```http
POST http://localhost:9000/api/v2/alertas
Content-Type: application/json

{
  "tipoAlerta": "Risco de Seca",
  "severidade": 8,
  "impactoEstimado": 6.5,
  "dataEvento": "2026-05-26",
  "status": "EM_ANALISE",
  "talhaoId": 1,
  "sateliteId": 1
}
```

---

## ⚠️ Respostas de Erro

### Recurso não encontrado (404)

```json
{
  "timestamp": "2026-05-26T10:00:00",
  "status": 404,
  "error": "Recurso nao encontrado",
  "message": "Talhao nao encontrado com id: 99"
}
```

### Erro de validação (400)

```json
{
  "timestamp": "2026-05-26T10:00:00",
  "status": 400,
  "error": "Erro de validacao",
  "campos": {
    "nome": "Nome é obrigatorio",
    "severidade": "Severidade maxima é 10"
  }
}
```

> *"A próxima corrida tecnológica já começou. E você faz parte dela."* — FIAP Global Solution 2026
