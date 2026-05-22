# Product Service

Serviço responsável pelo catálogo de produtos. Não conhece usuários nem carrinhos.

## Como rodar

```bash
# Entre na pasta do serviço
cd product-service

# Rode o projeto
./mvnw spring-boot:run
```

O serviço sobe na porta `8082`.

## Endpoints

### Buscar produto por ID
```
GET /products/{id}
```
**Resposta:**
```json
{
  "id": "uuid",
  "name": "Teclado Mecânico",
  "description": "Teclado com switches blue"
}
```

---

### Buscar produto por nome
```
GET /products?name=Teclado Mecânico
```
**Resposta:**
```json
{
  "id": "uuid",
  "name": "Teclado Mecânico",
  "description": "Teclado com switches blue"
}
```

---

### Cadastrar produto
```
POST /products
```
**Body:**
```json
{
  "name": "Teclado Mecânico",
  "description": "Teclado com switches blue"
}
```
**Resposta:**
```json
{
  "id": "uuid",
  "name": "Teclado Mecânico",
  "description": "Teclado com switches blue"
}
```
