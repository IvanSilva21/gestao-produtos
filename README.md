# 📦 Gestão de Produtos API

API REST desenvolvida com Java e Spring Boot para gerenciamento de produtos.
O projeto implementa boas práticas de arquitetura backend, incluindo DTOs, validações, tratamento global de exceções, testes unitários e documentação automática da API.

---

# 🚀 Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Maven
* PostgreSQL
* Swagger / OpenAPI
* Bean Validation
* JUnit 5
* Mockito

---

# 🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura em camadas, garantindo separação de responsabilidades e maior organização do código.

Controller → Responsável pelas requisições HTTP
Service → Contém a lógica de negócio
Repository → Comunicação com o banco de dados
DTO → Transferência de dados entre camadas
Mapper → Conversão entre Entity e DTO

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Banco de Dados
```

---

# 📌 Funcionalidades da API

✔ Cadastrar produtos
✔ Listar produtos com paginação
✔ Buscar produto por ID
✔ Atualizar produto
✔ Deletar produto
✔ Filtrar produtos por nome
✔ Filtrar produtos por faixa de preço

---

# 📖 Documentação da API

A documentação da API é gerada automaticamente utilizando Swagger.

Após iniciar a aplicação, acesse:

http://localhost:8080/swagger-ui/index.html

Com o Swagger é possível visualizar todos os endpoints da API e testar requisições diretamente no navegador.

---

# ✅ Validação de Dados

A API utiliza Bean Validation para garantir que os dados enviados estejam corretos antes de serem processados.

Exemplo de validações utilizadas:

* @NotBlank
* @NotNull
* @Positive

Essas validações ajudam a manter a integridade dos dados e evitar inconsistências no sistema.

---

# ⚠️ Tratamento Global de Exceções

O projeto possui um tratamento global de erros utilizando um GlobalExceptionHandler.

Esse mecanismo captura exceções da aplicação e retorna respostas padronizadas para o cliente.

Exemplos de exceções tratadas:

* ProdutoNotFoundException
* MethodArgumentNotValidException

Isso melhora a experiência de consumo da API e facilita o entendimento de erros.

---

# 🧪 Testes Automatizados

Foram implementados testes unitários utilizando:

* JUnit 5
* Mockito

Os testes garantem o funcionamento correto da camada de serviço isolando dependências externas.

---

# ⚙️ Como executar o projeto

Clonar o repositório:

git clone https://github.com/IvanSilva21/gestao-produtos.git

Entrar na pasta do projeto:

cd gestao-produtos

Executar a aplicação:

mvn spring-boot:run

---

# 📁 Estrutura do Projeto

src
├── controller
├── service
├── repository
├── dto
├── mapper
├── entity
├── exception
├── config
└── validation

---

# 👨‍💻 Autor

Ivan L. Silva Junior

LinkedIn
https://www.linkedin.com/in/ivan-silva-258480141/

GitHub
https://github.com/IvanSilva21


Este projeto foi desenvolvido com o objetivo de praticar boas práticas de desenvolvimento backend utilizando Spring Boot, incluindo arquitetura em camadas, validações, tratamento de exceções, testes automatizados e documentação de API.
