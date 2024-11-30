# Atividade Caixa Branca

Este repositório contém um exemplo de implementação em Java que realiza a conexão com um banco de dados e a verificação de usuários. Ele também inclui a documentação gerada com **Javadoc**.

## Estrutura do Projeto

O projeto possui as seguintes classes principais:

### 1. `User`
A classe `User` é responsável por:
- **Conectar ao banco de dados**: Utiliza o driver JDBC para se conectar a um banco MySQL.
- **Verificar usuários**: Realiza a autenticação de login e senha no banco de dados.

### Funcionalidades Principais
#### Método `conectarBD()`
- Estabelece uma conexão com o banco de dados MySQL.
- Retorna um objeto `Connection` para ser utilizado em consultas.
- Retornando `null` caso a conexão não seja bem-sucedida.

#### Método `verificarUsuario(String login, String senha)`
- Valida as credenciais fornecidas (`login` e `senha`) contra os dados armazenados no banco de dados.
- Retorna `true` caso a autenticação seja bem-sucedida.
- Preenche a variável `nome` com o nome do usuário autenticado.

## Gerando a Documentação Javadoc

A documentação do código foi gerada utilizando o **Javadoc**.


