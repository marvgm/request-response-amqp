# Visão arquitetural
Pensando em um modelo arquitetural mais produtivo mas ainda desacoplado, utilizo uma arquitetura hexagonal baseada na implementação realizada pela Netflix (link abaixo).
- [Ready for changes with Hexagonal Architecture](https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749)


Este modelo tem isolamento de cada uma das camadas facilitando os testes unitários e a manutenção.
Idealmente, deve-se deixar apenas uma classe publica por camada e contexto, deixando assim isoladas todas as outras classes com o modificador package-private.

Cada camada deve criar suas `Exceptions` se necessário. A camanda de HTTP intercepta as exceções via `@ControllerAdvice`e faz o tratamento adequado para HTTP (lembramos que este é um exemplo bem simples e deve ser alterado conforme necessidade).

Abaixo, breve descrição da responsabilidade de cada camada.

- **transport**: Reponsável pela entrada de dados. Aqui podem ficar os Controllers HTTP ou Listeners SQS, por exemplo.

- **interactor**: Responsável pela lógica de negócio, recebe os dados da camada de transport e delega, se necessário, para a camada de datasource.

- **datasource**: Responsável pelo destino ou armazenamento da informação como banco de dados, sqs, s3, etc. **Esta camada pode ter mais de uma implementação.**

# Passo a passo setup rápido
1. Compilar o projeto com maven `mvn clean install`
2. Realizar o import do projeto como maven-project em sua IDE (Eclipse ou Intellij).
3. Prover um container Rabbitmq (docker-compose) localizado na pasta Docker 
4. Subir o spring-boot a partir da classe `ApibffcalculadorApplication e servicecalculatorApplication`


# Build e Testes
Para compilar o projeto, é necessário JDK versão 11 e maven 3.6+


- Compilar o projeto e rodar os testes `mvn clean install`

# Docker
- entrar no diretório `docker` e subir docker compose com o comando `docker-compose up -d`
- RabbitMQ tem uma maneger UI: http://localhost:15672 OU the HTTP API: http://localhost:15672/api/index.html.

