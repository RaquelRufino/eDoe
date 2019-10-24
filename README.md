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

# Authentication and Authorization
## Authentication
A autenticação do usuário é feita através da rota default: `POST /login`  
Para realizar a autenticação é necessário enviar no body da requisição user e password no formato json.  
* Exemplo de body enviado na requqisição: { user: "admin", password: "admin" }
É utilizado o Bearer Authentication para geração e criptografia dos tokens, mais informações em:   https://swagger.io/docs/specification/authentication/bearer-authentication/
* No sucesso da autenticacão será retornado status 202 e um Token Bearer JWT para o usuario. *


## Authorization
Para autorização, em algumas rotas, é necessario o envio do Bearer Token JWT, gerado na autenticação do usuario, no Authorization header da requisição.  
O tokenJWT tem informacoes sobre os privilegios do usuario.  
### Existem 2 tipos de usuários no sistema: Admin e User
* Exemplo de rota que checa se o usuário está logado: `GET /edoe/donateditem` [Mostrar todos Donated Itens]
* Exemplo de rota que checa se o usuário tem privilégio de admnistrador: `DELETE /edoe/donateditem/{id}` [Deletar um Donated Item]  
* Caso o usuário não tenha o privilégio para acessar a rota, será retornado status 403. *

# Performance and scalability
Para garantir que a aplicação aguentará uma certa quantidade de usuários e avaliar a experiência que ele terá na aplicação verificando qual o tempo de resposta a cada iteração. Simplificando, é aquele em que submetemos o sistema a uma avaliação de carga, stress ou desempenho para avaliar se os resultados estão de acordo com o esperado, garantindo assim a qualidade do sistema.
## JMeter
Quando falamos em teste de performance o JMeter é a ferramenta mais utilizada para este seguimento.

### Vazão
#### Gráfico JMeter
![graph_cache](https://user-images.githubusercontent.com/20324935/67443402-17f3b000-f5db-11e9-8ba2-f29b0f3cb1ec.png)
- Vazão: 47k por minuto / 786,2 por segundo.

### Tempo de resposta
O teste de tempo de resposta, foi feito primeiro sem utilizar a abstração de cache do JMeter e depois utilizando o a biblioteca de cache do springframework.
#### Sem cache
![response_time_graph](https://user-images.githubusercontent.com/20324935/67442910-05787700-f5d9-11e9-8ae4-5036bdfdf6ee.png)
- Tempo médio de resposta: 1250
#### Com cache
![response_time_graph_cache](https://user-images.githubusercontent.com/20324935/67442871-df52d700-f5d8-11e9-8443-e62035c6fbad.png)
- Tempo médio de resposta: 1050

#### Resultados
Esperava que com cache o tempo de resposta médio se reduzisse, e foi o que aconteceu, mesmo com um pico o tempo média de resposta com cache foi 200 milisegundos menor do que utilizando a biblioteca de cache do springframwork. 

# REST API Docs

## Endpoints

Endpoints para visualizar e manipular as Doações que o Usuário Autenticado
tem permissões para acessar.

### Donated Item

* [Mostrar todos Donated Itens](docs/donateditem/get.md) : `GET /edoe/donateditem`

* [Criar Donated Item](docs/donateditem/post.md) : `POST /edoe/donateditem`

* [Mostrar um Donated Item pelo Id](docs/donateditem/id/get.md) : `GET /edoe/donateditem/findById?id=`

* [Mostrar um Donated Item pela Descrição](docs/donateditem/descricao/get.md) : `GET /edoe/donateditem/findByDescription?description=`

* [Atualizar um Donated Item](docs/donateditem/id/put.md) : `PUT /edoe/donateditem/{id}`    

* [Deletar um Donated Item](docs/donateditem/id/delete.md) : `DELETE /edoe/donateditem/{id}`

### Required Item

* [Show Accessible Required Itens](docs/requireditem/get.md) : `GET /edoe/requireditem`

* [Criar Required Item](docs/requireditem/post.md) : `POST /edoe/requireditem`

* [Mostrar um Required Item pelo id](docs/requireditem/id/get.md) : `GET /edoe/requireditem/findById?id=`

* [Mostrar um Required Item pela descrição](docs/requireditem/descricao/get.md) : `GET /edoe/requireditem/findByDescription?description=`

* [Atualizar um Required Item](docs/requireditem/id/put.md) : `PUT /edoe/requireditem/{id}`    

* [Deletar um Required Item](docs/requireditem/id/delete.md) : `DELETE /edoe/requireditem/{id}`

* [Identificar possiveis matches](docs/requireditem/id/description/match.md) : `GET /edoe//match?id= description=`

    
### User

* [Mostrar todos Users](docs/user/get.md) : `GET /edoe/user/`

* [Criar User](docs/user/post.md) : `POST /edoe/user/`

* [Mostrar um usuario pelo id](docs/user/id/get.md) : `GET /edoe/user?id=`

* [Mostrar um usuario pelo name](docs/user/name/get.md) : `GET /edoe/user/findByName?name=`

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
