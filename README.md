# ToolsChallenge

## Descrição
O **ToolsChallenge** é uma API RESTful desenvolvida em **Java Spring Boot**, projetada para realizar o processamento de transações financeiras. Ele fornece endpoints para criar, consultar e gerenciar transações de pagamento, garantindo segurança, confiabilidade e alta performance.

## Tecnologias Utilizadas

- **Java 17** - Linguagem principal do projeto
- **Spring Boot 3.4.2** - Framework para criação da API REST
- **Spring Web** - Para construção da API REST
- **Spring Validation** - Para validação de dados da entrada
- **Spring Data JPA** - Para interação com o banco de dados
- **H2 Database** - Banco de dados em memória para testes
- **Lombok** - Para redução de boilerplate no código
- **JUnit 5 & Mockito** - Para testes unitários
- **Gradle** - Gerenciador de dependências

## Instalação e Execução

### **Requisitos**
- **Java 17** ou superior instalado
- **Gradle** instalado

### **Passos para rodar o projeto**

1. Clone o repositório:
   ```sh
   git clone https://github.com/gsaleal/ToolsChallenge.git
   ```

2. Acesse a pasta do projeto:
   ```sh
   cd ToolsChallenge
   ```

3. Execute a aplicação:
   ```sh
   ./gradlew bootRun
   ```

4. A API estará disponível em: `http://localhost:8080`

## Endpoints Principais

### **Criar uma transação**
**POST** `/api/transactions`
```json
{
	"transacao": {
		"cartao": "1231231231231231",
		"id": "123",
		"descricao": {
			"valor": "500",
			"dataHora": "01/01/2025 18:30:01",
			"estabelecimento": "Pet"
		},
		"formaPagamento": {
			"tipo": "AVISTA",
			"parcelas": "10000"
		}
	}
}
```

### **Realizar estorno**
**POST** `/api/transactions/estorno/1`

Retorno
```json
{
    "transacao": {
        "cartao": "1231231231231231",
        "id": "1",
        "descricao": {
            "valor": "500.0",
            "dataHora": "01/01/2025 18:30:01",
            "estabelecimento": "Pet",
            "nsu": "123",
            "codigoAutorizacao": "123",
            "status": "NEGADO"
        },
        "formaPagamento": {
            "tipo": "AVISTA",
            "parcelas": "1"
        }
    }
}
```

### **Consultar todas as transações**
**GET** `/api/transactions`


### **Consultar uma transação pelo ID**
**GET** `/api/transactions/{id}`

## Testes
Para rodar os testes automatizados, execute:
```sh
./gradlew test
```

## Contribuição
1. Fork o repositório
2. Crie uma branch com sua feature: `git checkout -b minha-feature`
3. Commit suas modificações: `git commit -m 'Adiciona nova funcionalidade'`
4. Push para a branch: `git push origin minha-feature`
5. Abra um Pull Request

## Licença
Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---
Criado por **Gabriel Leal** 🚀

