# Sistema de Investimentos

Esse repositório contém 3 microsserviços que atuam como um sistema de cadastro de investimentos para um cliente. O sistema não faz a atualização dos valores, ele apenas registra a contratação de um **produto** por um determinado **cliente**, o que é denominado de **aplicação**. Note que cada um desses itens é tratado por um microsserviço específico.

## Microsserviço Cliente

Porta padrão: 8081

### POST /
Cadastra um novo cliente no sistema.

**Request Body**
```json
{
    "nome": "José da Silva",
    "cpf": "312.412.534-56",
    "email": "jose@gmail.com"
}
```

### GET /{cpf}
Exibe os dados de um cliente.

**Response 200**
```json
{
    "nome": "José da Silva",
    "cpf": "312.412.534-56",
    "email": "jose@gmail.com"
}
```

## Microsserviço Produto

Porta padrão: 8082

### POST /
Cadastra um novo produto no sistema.

**Request Body**
```json
    {
        "nome": "Poupança",
        "rendimento": 0.005
    }
```

### GET /
Exibe a lista de produtos no sistema.

**Response 200**
```json
[
    {
        "id": 1,
        "nome": "Poupança",
        "rendimento": 0.005
    },
    {
        "id": 2,
        "nome": "CDB",
        "rendimento": 0.007
    },
    {
        "id": 3,
        "nome": "Fundos",
        "rendimento": 0.008
    }
]
```

### GET /{id}
Exibe dados de um produto.

**Response 200**
```json
{
    "id": 1,
    "nome": "Poupança",
    "rendimento": 0.005
}
```

## Aplicacao
Porta padrão: 8083

### POST /
Cria uma nova aplicação.

**Request Body**
```json
{
    "cliente": {
        "cpf": "312.412.534-56"
    },
    "produto": {
        "id": 1
    },
    "valor": 10000.00,
    "meses": 24
}
```


