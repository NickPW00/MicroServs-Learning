# API Gateway

Ponto único de entrada da aplicação. Roteia as requisições para os serviços corretos.

## Como rodar

```bash
# Entre na pasta do serviço
cd api-gateway

# Rode o projeto
./mvnw spring-boot:run
```

O gateway sobe na porta `8080`.

> Todos os outros serviços precisam estar rodando antes.

## Roteamento

| Rota | Serviço | Porta |
|------|---------|-------|
| `/users/*/cart/**` | cart-service | 8083 |
| `/users/**` | user-service | 8081 |
| `/products/**` | product-service | 8082 |

## Exemplos de uso pelo Gateway

```
GET  http://localhost:8080/users/123
POST http://localhost:8080/users

GET  http://localhost:8080/products/123
POST http://localhost:8080/products

GET  http://localhost:8080/users/123/cart
POST http://localhost:8080/users/123/cart
DELETE http://localhost:8080/users/123/cart/456
```
