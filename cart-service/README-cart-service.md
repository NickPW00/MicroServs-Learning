# Cart Service

Serviço responsável pelo carrinho de compras. Consulta o User Service e o Product Service via WebClient para validar e enriquecer os dados.

## Como rodar

```bash
# Entre na pasta do serviço
cd cart-service

# Rode o projeto
./mvnw spring-boot:run
```

O serviço sobe na porta `8083`.

> O User Service e o Product Service precisam estar rodando antes.

## Endpoints

### Buscar carrinho do usuário
```
GET /users/{userId}/cart
```
**Resposta:**
```json
[
  {
    "cartItemId": "uuid",
    "quantity": 2,
    "product": {
      "id": "uuid",
      "name": "Teclado Mecânico",
      "description": "Teclado com switches blue"
    }
  }
]
```

---

### Adicionar item ao carrinho
```
POST /users/{userId}/cart
```
**Body:**
```json
{
  "productId": "uuid",
  "quantity": 2
}
```
**Resposta:**
```json
{
  "cartItemId": "uuid",
  "quantity": 2,
  "product": {
    "id": "uuid",
    "name": "Teclado Mecânico",
    "description": "Teclado com switches blue"
  }
}
```

---

### Remover item do carrinho
```
DELETE /users/{userId}/cart/{cartItemId}
```
**Resposta:** `204 No Content`
