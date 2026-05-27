# 🛰️ AgroSat Alert

> Plataforma de monitoramento agrícola via satélite — Global Solution 2026 | FIAP

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green?style=flat-square&logo=springboot)
![H2](https://img.shields.io/badge/Database-H2-blue?style=flat-square)
![Maven](https://img.shields.io/badge/Build-Maven-red?style=flat-square)

---

## 📋 Sobre o Projeto

O **AgroSat Alert** é uma API REST desenvolvida como parte da Global Solution 2026 da FIAP, com tema **Space Connect | Tecnologia Espacial Aplicada a Desafios Reais**.

O sistema conecta dados de satélites espaciais ao agronegócio brasileiro, emitindo alertas climáticos e ambientais em tempo real para produtores rurais. A plataforma permite que cooperativas agrícolas tomem decisões estratégicas com base em dados orbitais precisos, reduzindo perdas nas safras causadas por eventos climáticos extremos.

### 🎯 Problema que resolve

O Brasil perde bilhões de reais anualmente em safras por falta de informação climática precisa no campo. Satélites já captam esses dados em tempo real, mas não chegam de forma estruturada ao produtor rural. O AgroSat Alert preenche essa lacuna.

---

## 🏗️ Arquitetura do Projeto

```
agrosat-alert/
├── src/
│   ├── main/
│   │   ├── java/rm_seuRM/agrosat_alert/
│   │   │   ├── controller/
│   │   │   │   ├── TalhaoController.java
│   │   │   │   └── AlertaClimaticoController.java
│   │   │   ├── service/
│   │   │   │   ├── TalhaoService.java
│   │   │   │   └── AlertaClimaticoService.java
│   │   │   ├── repository/
│   │   │   │   ├── TalhaoRepository.java
│   │   │   │   └── AlertaClimaticoRepository.java
│   │   │   ├── entity/
│   │   │   │   ├── Talhao.java
│   │   │   │   └── AlertaClimatico.java
│   │   │   ├── dto/
│   │   │   │   ├── TalhaoDTO.java
│   │   │   │   └── AlertaClimaticoDTO.java
│   │   │   └── exception/
│   │   │       ├── ResourceNotFoundException.java
│   │   │       └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-test.properties
│   │       └── import.sql
└── pom.xml
```

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Versão | Uso |
|-----------|--------|-----|
| Java | 17 | Linguagem principal |
| Spring Boot | 3.5 | Framework web |
| Spring Data JPA | 3.5 | Persistência de dados |
| H2 Database | - | Banco em memória para testes |
| Bean Validation | - | Validação dos DTOs |
| Maven | - | Gerenciador de dependências |

---

## 🚀 Como Executar

### Pré-requisitos

- Java 17 instalado
- Maven instalado (ou usar o wrapper do projeto)

### Passos

**1. Clone o repositório**
```bash
git clone https://github.com/seuusuario/agrosat-alert.git
cd agrosat-alert
```

**2. Execute o projeto**

No Linux/Mac:
```bash
./mvnw spring-boot:run
```

No Windows:
```bash
mvnw.cmd spring-boot:run
```

**3. Acesse a API**
```
http://localhost:8080
```

**4. Acesse o console H2 (banco de dados)**
```
http://localhost:8080/h2-console
```
- JDBC URL: `jdbc:h2:mem:agrosat`
- Username: `sa`
- Password: *(vazio)*

---

## 📊 Modelo de Dados

### Entidades

#### Talhao

| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | Long | Chave primária |
| nome | String | Nome do talhão |
| cultura | String | Cultura plantada |
| areaHectares | Double | Área em hectares |
| localizacao | String | Localização geográfica |
| dataCadastro | LocalDate | Data de cadastro |

#### AlertaClimatico

| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | Long | Chave primária |
| tipoAlerta | String | Tipo do alerta (Seca, Geada, etc.) |
| severidade | Integer | Nível de severidade (1-10) |
| impactoEstimado | Double | Impacto estimado (0-10) |
| dataEvento | LocalDate | Data do evento |
| status | String | Status (EM_ANALISE, MONITORANDO, CRITICO) |
| talhaoId | Long | Chave estrangeira para Talhao |

### Relacionamento

```
TB_TALHAO (1) ----< (N) TB_ALERTA_CLIMATICO
```

---

## 🔌 Endpoints da API

### Talhao

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/talhoes` | Lista todos os talhões | 200 |
| GET | `/talhoes/{id}` | Busca talhão por ID | 200 / 404 |
| POST | `/talhoes` | Cria novo talhão | 201 |
| PUT | `/talhoes/{id}` | Atualiza talhão | 200 / 404 |
| DELETE | `/talhoes/{id}` | Remove talhão | 204 / 404 |

### AlertaClimatico

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/alertas` | Lista todos os alertas | 200 |
| GET | `/alertas/{id}` | Busca alerta por ID | 200 / 404 |
| GET | `/alertas/talhao/{talhaoId}` | Lista alertas por talhão | 200 |
| POST | `/alertas` | Cria novo alerta | 201 |
| PUT | `/alertas/{id}` | Atualiza alerta | 200 / 404 |
| DELETE | `/alertas/{id}` | Remove alerta | 204 / 404 |

---

## 📝 Exemplos de Uso

### Criar um talhão

```http
POST http://localhost:8080/talhoes
Content-Type: application/json

{
  "nome": "Talhao Norte 1",
  "cultura": "Soja",
  "areaHectares": 120.5,
  "localizacao": "Fazenda A - Regiao Norte, MT",
  "dataCadastro": "2026-01-10"
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "Talhao Norte 1",
  "cultura": "Soja",
  "areaHectares": 120.5,
  "localizacao": "Fazenda A - Regiao Norte, MT",
  "dataCadastro": "2026-01-10"
}
```

---

### Criar um alerta

```http
POST http://localhost:8080/alertas
Content-Type: application/json

{
  "tipoAlerta": "Risco de Seca",
  "severidade": 8,
  "impactoEstimado": 6.5,
  "dataEvento": "2026-05-26",
  "status": "EM_ANALISE",
  "talhaoId": 1
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "tipoAlerta": "Risco de Seca",
  "severidade": 8,
  "impactoEstimado": 6.5,
  "dataEvento": "2026-05-26",
  "status": "EM_ANALISE",
  "talhaoId": 1
}
```

---

### Atualizar um talhão

```http
PUT http://localhost:8080/talhoes/1
Content-Type: application/json

{
  "nome": "Talhao Norte 1 Atualizado",
  "cultura": "Milho",
  "areaHectares": 150.0,
  "localizacao": "Fazenda A - Regiao Norte, MT",
  "dataCadastro": "2026-01-10"
}
```

---

### Buscar alertas de um talhão

```http
GET http://localhost:8080/alertas/talhao/1
```

---

### Deletar um alerta

```http
DELETE http://localhost:8080/alertas/1
```

**Resposta:** `204 No Content`

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

---

## 👥 Equipe

| Nome | RM | 
|------|----|
| Giovanni Sguizzardi Conde | RM-565123
| Lucas Lima Franco | RM-550255
| Bruno César Toledo D Oliveira | RM-554878

---
