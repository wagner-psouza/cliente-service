# Projeto
Serviço responsável por manipulações referentes ao cliente.

# Requisitos
* Java 8 ou superior
* Maven
* Docker

## Configuração do Ambiente

Foi criado um docker-compose para facilitar a criação dos serviços necessários para execução da aplicação.

Antes de iniciar o desenvolvimento executar o comando abaixo na raiz do projeto:

```bash
docker-compose up -d
```

## Compilar a Aplicação

Para gerar a versão é necessário executar o comando abaixo na raiz do projeto:

```bash
mvn clean install
```

## Subir Aplicação

Para subir a aplicação o comando abaixo deve ser executado na raiz do projeto:

```bash
java -jar target/cliente-service.jar
```
## Swagger

Como alternativa para a documentação dos endpoints foi utilizado o Swagger, que pode ser acessado pelo link abaixo:

```
http://localhost:8080/cliente/swagger-ui.html
```

### Tecnologias e Ferramentas Utilizadas

* Java 8
* Maven
* Docker
* Liquibase - Para versionamento do banco de dados
* Swagger  - Para testes e documentação dos Endpoint
* Mockito - Para testes de unidade

