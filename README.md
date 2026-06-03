# Sistema de Vendas & Funcionários

> Duas APIs REST em Java + Spring Boot que se comunicam entre si via HTTP, cada uma com seu próprio banco de dados SQL Server.

## Estrutura do Repositório

```
sistema-vendas-funcionarios/
|-> APIFuncionarios/     → API de gerenciamento de funcionários
|-> APIVendas/           → API de registro de vendas
```

---

## Tecnologias

- **Java 17** + **Spring Boot**
- **Spring Data JPA** (API Funcionários)
- **JDBC Puro** (API Vendas)
- **SQL Server**
- **RestTemplate** — comunicação entre as APIs

---

## APIs

### API Funcionários — porta `8082`

Gerencia o cadastro de funcionários. Utiliza **Spring Data JPA**, onde o `JpaRepository` gera as queries automaticamente.

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/funcionario` | Cadastra um novo funcionário |
| `GET` | `/funcionario/{id}` | Busca um funcionário pelo ID |

**Exemplo de requisição POST:**
```json
{
  "Nome": "Ana Silva",
  "Telefone": "16999999999",
  "Email": "ana@email.com",
  "Endereco": "Rua das Árvores, 456",
  "Cidade": "Araraquara",
  "Salario": 3500.50,
  "DataNascimento": "1998-05-20"
}
```

---

### API Vendas — porta `8081`

Registra as vendas realizadas pelos funcionários. Utiliza **JDBC puro** com queries SQL escritas manualmente.

| Método | Endpoint  | Descrição |
|--------|-----------|-----------|
| `POST` | `/vendas` | Cadastra uma nova venda |
| `GET`  | `/vendas` | Lista todas as vendas com dados do funcionário |

**Exemplo de requisição POST:**
```json
{
  "descricao": "Venda balcão",
  "nomeProduto": "Notebook",
  "valorProduto": 3500.00,
  "quantidade": 2,
  "idFuncionario": 1
}
```

**Exemplo de resposta GET:**
```json
[
  {
    "id": 1,
    "descricao": "Venda balcão",
    "dataVenda": "2026-06-02",
    "nomeProduto": "Notebook",
    "valorProduto": 3500.00,
    "quantidade": 2,
    "valorTotalVenda": 7000.00,
    "funcionario": {
      "IdFuncionario": 1,
      "Nome": "Ana Silva",
      "Telefone": "16999999999",
      "Email": "ana@email.com",
      "Cidade": "Araraquara",
      "Salario": 3500.50
    }
  }
]
```

---

## Comunicação entre as APIs

As duas APIs são completamente independentes, cada uma com seu próprio banco de dados. A integração é feita via **RestTemplate** na camada de Service da API de Vendas.

```
Postman
  |--> POST /vendas
        |--> VendaService
              |--> GET http://localhost:8082/funcionario/{id}  ← valida se existe
                    |--> Salva a venda com idFuncionario
```

No **GET de vendas**, o Service busca cada venda no banco e consulta a API de Funcionários para montar a resposta completa - já que são bancos separados, o JOIN é feito em código Java, não em SQL.

---

## Arquitetura em Camadas

Ambas as APIs seguem o mesmo padrão:

```
Controller  ->  recebe a requisição HTTP
Service     ->  regras de negócio e validações
Repository  ->  acesso ao banco de dados
DTOs        ->  RequestDTO (entrada) / ResponseDTO (saída)
```

---

## Como rodar

1. Clone o repositório
```bash
git clone https://github.com/juhfrancic/sistema-vendas-funcionarios.git
```

2. Configure a string de conexão nos `application.properties` de cada projeto

3. Execute a **API Funcionários** primeiro (porta 8082)

4. Execute a **API Vendas** (porta 8081)

5. Importe as requisições no Postman e teste!

---

> As duas APIs precisam estar rodando ao mesmo tempo para a comunicação via RestTemplate funcionar.
