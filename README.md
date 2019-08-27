# Aplicação Spring eDoe

<p align="center">
  <img src="https://lh6.googleusercontent.com/lT7mQse0ChZB0iMO0MMXZp_k-nTqtyfY9_FuNl7eELiVQcjRztnz5d1Iu_m39pKhGeXP8-37MfmRQlkszMDEDyjlgxSfa7_5nsbJEJjkmztA0St3wy4art8UIGekWKjQOINpxtgo" height="200" width="600"> 
</p>

>Muitas pessoas tem interesse em fazer doações, mas as vezes não tem o tempo necessário para encontrar onde doar ou como doar. Como sabemos, vivemos em um país em que a desigualdade social ainda existe e por isso há várias pessoas necessitadas, às vezes grupos de pessoas com um problema em comum. Precisamos de um sistema para apoiar essa rede de doações: o eDoe.com.

#### [Especificação original](https://docs.google.com/document/d/e/2PACX-1vST2TI5lDbtMlv8rhFYJkYnrfgqzyWDv6DDvvAajz3_KK4tAs_UnAbYdI6oeMQA6jEHo5HwUAatHmd8/pub)

#### [Diagrama de Componentes](docs/diagrama.png)
### Pré Requisitos:

Os itens a seguir devem ser instalados no seu sistema:
* Java 11
* Git
* PostgreSQL
* Maven
* Sua IDE preferida: 
  * Eclipse.https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

### Setup:

**1. Clone a aplicação**

```bash
git clone https://github.com/caiofelipe97/eDoe.git
```

**2. Crie PostgreSQL database**
```bash
psql
createdb edoe
```
**3. Adicione as credenciais para `/resources/application.properties`**

```
spring.datasource.url=jdbc:postgresql://localhost:5432/edoe
spring.datasource.username=postgres
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

**4. Rode a aplicação usando maven**

```bash
mvn spring-boot:run
```
O aplicativo começará a ser executado em: <http://localhost:8085/>

# REST API Docs

## Endpoints

Endpoints para visualizar e manipular as Doações que o Usuário Autenticado
tem permissões para acessar.

### Donated Item

* [Mostrar todos Donated Itens](docs/donateditem/get.md) : `GET /edoe/donateditem`

* [Criar Donated Item](docs/donateditem/post.md) : `POST /edoe/donateditem`

* [Mostrar um Donated Item](docs/donateditem/id/get.md) : `GET /edoe/donateditem/{id}`

* [Atualizar um Donated Item](docs/donateditem/id/put.md) : `PUT /edoe/donateditem/{id}`    

* [Deletar um Donated Item](docs/donateditem/id/delete.md) : `DELETE /edoe/donateditem/{id}`

### Required Item

* [Show Accessible Required Itens](docs/requireditem/get.md) : `GET /edoe/requireditem`

* [Criar Required Item](docs/requireditem/post.md) : `POST /edoe/requireditem`

* [Mostrar um Required Item](docs/requireditem/id/get.md) : `GET /edoe/requireditem/{id}`

* [Atualizar um Required Item](docs/requireditem/id/put.md) : `PUT /edoe/requireditem/{id}`    

* [Deletar um Required Item](docs/requireditem/id/delete.md) : `DELETE /edoe/requireditem/{id}`

* [Identificar possiveis matches](docs/requireditem/id/description/match.md) : `GET /edoe//match/{id}/{description}`

    
### User

* [Mostrar todos Users](docs/user/get.md) : `GET /edoe/user/`

* [Criar User](docs/user/post.md) : `POST /edoe/user/`

* [Mostrar um usuario pelo id](docs/user/id/get.md) : `GET /edoe/user/id/{id}`

* [Mostrar um usuario pelo name](docs/user/name/get.md) : `GET /edoe/user/name/{name}`

* [Atualizar um User](docs/user/id/put.md) : `PUT /edoe/user/{id}`    

* [Deletar um User](docs/user/id/delete.md) : `DELETE /edoe/user/{id}`
   
### Item

* [Mostrar todos Itens](docs/item/get.md) : `GET /edoe/item`

* [Criar Item](docs/item/post.md) : `POST /edoe/item`

* [Mostrar um Item pelo id](docs/item/id/get.md) : `GET /edoe/item/id/{id}`

* [Mostrar Itens pela descricao](docs/item/description/get.md) : `GET /edoe/item/description/{description}`

* [Atualizar um Item](docs/item/id/put.md) : `PUT /edoe/item/{id}`    

* [Deletar um Item](docs/item/id/delete.md) : `DELETE /edoe/item/{id}`

### Donation

* [Mostrar todas Donations](docs/donation/get.md) : `GET /edoe/donation`

* [Criar Donation](docs/donation/post.md) : `POST /edoe/donation`

* [Mostrar uma Donation](docs/donation/id/get.md) : `GET /edoe/donation/{id}`

* [Atualizar uma Donation](docs/donation/id/put.md) : `PUT /edoe/donation/{id}`    

* [Deletar uma Donation](docs/donation/id/delete.md) : `DELETE /edoe/donation/{id}`


Você pode testá-los usando o Postman ou qualquer outro rest client.
