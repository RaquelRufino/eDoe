# Aplicação Spring eDoe

<p align="center">
  <img src="https://lh6.googleusercontent.com/lT7mQse0ChZB0iMO0MMXZp_k-nTqtyfY9_FuNl7eELiVQcjRztnz5d1Iu_m39pKhGeXP8-37MfmRQlkszMDEDyjlgxSfa7_5nsbJEJjkmztA0St3wy4art8UIGekWKjQOINpxtgo" height="200" width="600"> 
</p>

>Muitas pessoas tem interesse em fazer doações, mas as vezes não tem o tempo necessário para encontrar onde doar ou como doar. Como sabemos, vivemos em um país em que a desigualdade social ainda existe e por isso há várias pessoas necessitadas, às vezes grupos de pessoas com um problema em comum. Precisamos de um sistema para apoiar essa rede de doações: o eDoe.com.

#### [Especificação original](https://docs.google.com/document/d/e/2PACX-1vST2TI5lDbtMlv8rhFYJkYnrfgqzyWDv6DDvvAajz3_KK4tAs_UnAbYdI6oeMQA6jEHo5HwUAatHmd8/pub)

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

# RESTAPIDocs

## Endpoints

Endpoints for viewing and manipulating the Donations that the Authenticated User
has permissions to access.

### Donated Item

* [Show Accessible Donated Item](docs/donateditem/get.md) : `GET /edoe/donateditem`

* [Create Donated Item](docs/donateditem/post.md) : `POST /edoe/donateditem`

* [Show An Donated Item](docs/donateditem/get.md) : `GET /edoe/donateditem/{id}`

* [Update An Donated Item](docs/donateditem/put.md) : `PUT /edoe/donateditem/{id}`    

* [Delete An Donated Item](docs/donateditem/delete.md) : `DELETE /edoe/donateditem/{id}`
    
### user

    GET edoe/user/
    
    POST edoe/user/
    
    GET edoe/user/id/{id}
    
    GET edoe/user/name/{name}
    
    PUT edoe/user/{id}
    
    DELETE edoe/user/{id}
    
### item
        
    GET /edoe/item
    
    POST /edoe/item
    
    GET /edoe/item/{id}
    
    PUT /edoe/item/{id}
    
    DELETE /edoe/item/{id}
    
### donation
       
    GET /edoe/donation
    
    POST /edoe/donation
    
    GET /edoe/donation/{id}
    
    PUT /edoe/donation/{id}
    
    DELETE /edoe/donation/{id}


Você pode testá-los usando o Postman ou qualquer outro rest client.
