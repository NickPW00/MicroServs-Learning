# User Service

Serviço responsável pelo cadastro e consulta de usuários.

## Como rodar

```bash
# Entre na pasta do serviço
cd user-service

# Rode o projeto
./mvnw spring-boot:run
```

O serviço sobe na porta `8081`.

## Endpoints

### Buscar usuário por ID
```
GET /users/{id}
```
**Resposta:**
```json
{
  "id": "uuid",
  "name": "João Silva",
  "email": "joao@email.com"
}
```

---

### Cadastrar usuário
```
POST /users
```
**Body:**
```json
{
  "name": "João Silva",
  "email": "joao@email.com"
}
```
**Resposta:**
```json
{
  "id": "uuid",
  "name": "João Silva",
  "email": "joao@email.com"
}
```
