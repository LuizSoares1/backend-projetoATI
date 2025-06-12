# Sistema de Suporte - Back-end

Este é o back-end do Sistema de Suporte, desenvolvido em Java com Spring Boot. Ele fornece uma API REST para gerenciamento de clientes e tickets, incluindo operações de cadastro, edição, exclusão, listagem e busca.

## Tecnologias Utilizadas

- [Java 17+]
- [Spring Boot]
- [Spring Data JPA]
- [Spring Web]
- [Banco de Dados: PostgreeSQL]
- [Gradle]

## Instruções de Instalação e Execução

1 - Ter instalado o Java e o Gradle.
2 - Clone o repositório.
3 - Configure para o seu banco de dados em "src/main/resources/application.properties"
    
    spring.application.name=backend
    spring.datasource.url=jdbc:postgresql://localhost:5432/projectati
    spring.datasource.username=postgres
    spring.datasource.password=root
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

4 - Execute o servidor com "./mvnw spring-boot:run" ou "mvn spring-boot:run".

## Arquivos de Configuração Necessários

1 - application.properties
Configure o banco de dados, porta e outras propriedades do Spring Boot. Por padrão a porta está com a numeração 8080.


