# Rodando a Aplicação Java com Jetty e Autenticação Básica: Guia Passo a Passo

## Pré-requisitos

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) instalado.
- [Apache Maven](https://maven.apache.org/download.cgi) instalado.

## Preparação do Projeto

1. Crie um novo projeto Java (ou use um projeto existente) em sua IDE favorita (por exemplo, Eclipse, IntelliJ IDEA).

2. Abra o arquivo `pom.xml` do seu projeto e adicione as dependências necessárias, conforme você já forneceu no exemplo.

## Rodando Pela IDE

1. Abra o arquivo principal da sua aplicação (por exemplo, a classe `Main`).

2. Configure sua IDE para criar e executar um novo "Run Configuration" ou "Profile". Certifique-se de que a classe principal está definida corretamente.

3. Execute a configuração que você criou na etapa anterior. A IDE irá compilar e executar a aplicação, e você poderá acessar a aplicação pelo navegador usando a URL `http://localhost:8080/transaction`.

## Rodando Fora da IDE

1. Abra um terminal.

2. Navegue até o diretório raiz do seu projeto.

3. Execute o seguinte comando Maven para construir e rodar a aplicação:

   ```bash
   mvn clean package jetty:run


## Autenticação Básica

Para acessar a aplicação, é necessário fornecer credenciais de autenticação básica. O modelo de autenticação é **Basic**, e as credenciais de acesso são:

- Usuário: miguel
- Senha: 123456

Quando você acessar a aplicação, um prompt de autenticação será exibido no navegador. Insira as credenciais fornecidas acima para acessar a aplicação.

## Endpoints da Aplicação

A aplicação possui os seguintes endpoints, todos sob o contexto `/transaction`:

- `/list`: Retorna a lista de transações.
- `/filter`: Filtra as transações com base no tipo de transação.
- `/count`: Retorna o total de transações.

Você pode acessar esses endpoints adicionando o caminho correspondente à URL, por exemplo: `http://localhost:8080/transaction/list`.
